package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
	private static final Set<String> SORT_FIELDS = Set.of("id", "name", "price", "rating", "category", "brand",
			"stockQuantity");
	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Product create(Product product) {
		product.setId(null);
		return repository.save(product);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found: " + id));
	}

	public Product update(Long id, Product input) {
		Product p = findById(id);
		p.setName(input.getName());
		p.setDescription(input.getDescription());
		p.setCategory(input.getCategory());
		p.setBrand(input.getBrand());
		p.setPrice(input.getPrice());
		p.setStockQuantity(input.getStockQuantity());
		p.setRating(input.getRating());
		return repository.save(p);
	}

	public void delete(Long id) {
		repository.delete(findById(id));
	}

	public List<Product> searchByName(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public List<Product> searchByCategory(String category) {
		return repository.findByCategoryIgnoreCase(category);
	}

	public List<Product> searchByBrand(String brand) {
		return repository.findByBrandIgnoreCase(brand);
	}

	public List<Product> searchByPrice(BigDecimal min, BigDecimal max) {
		validateRange(min, max);
		return repository.findByPriceBetween(min, max);
	}

	public List<Product> searchByCategoryAndBrand(String category, String brand) {
		return repository.findByCategoryIgnoreCaseAndBrandIgnoreCase(category, brand);
	}

	public List<Product> search(String keyword) {
		if (keyword == null || keyword.isBlank())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Keyword cannot be blank");
		return repository.searchProducts(keyword.trim());
	}

	public List<Product> sort(String sortBy, String direction) {
		validateSort(sortBy);
		try {
			return repository.findAll(Sort.by(Sort.Direction.fromString(direction), sortBy));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Direction must be ASC or DESC");
		}
	}

	public Page<Product> filter(String keyword, String category, String brand, BigDecimal min, BigDecimal max, int page,
			int size, String sortBy, String direction) {
		if (page < 0 || size < 1 || size > 100)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Page must be >= 0 and size must be between 1 and 100");
		validateSort(sortBy);
		if (min != null && max != null)
			validateRange(min, max);
		try {
			Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
			return repository.filterProducts(blank(keyword), blank(category), blank(brand), min, max, pageable);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Direction must be ASC or DESC");
		}
	}

	private void validateSort(String field) {
		if (field == null || !SORT_FIELDS.contains(field))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid sortBy. Allowed: " + SORT_FIELDS);
	}

	private void validateRange(BigDecimal min, BigDecimal max) {
		if (min == null || max == null || min.compareTo(max) > 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide min and max prices with min <= max");
	}

	private String blank(String s) {
		return s == null || s.isBlank() ? null : s.trim();
	}
}
