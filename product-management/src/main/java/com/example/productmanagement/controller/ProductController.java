package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(product));
	}

	@GetMapping
	public List<Product> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @Valid @RequestBody Product product) {
		return service.update(id, product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search/name")
	public List<Product> searchByName(@RequestParam String name) {
		return service.searchByName(name);
	}

	@GetMapping("/search/category")
	public List<Product> searchByCategory(@RequestParam String category) {
		return service.searchByCategory(category);
	}

	@GetMapping("/search/brand")
	public List<Product> searchByBrand(@RequestParam String brand) {
		return service.searchByBrand(brand);
	}

	@GetMapping("/search/price")
	public List<Product> searchByPrice(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
		return service.searchByPrice(min, max);
	}

	@GetMapping("/search/category-brand")
	public List<Product> searchByCategoryAndBrand(@RequestParam String category, @RequestParam String brand) {
		return service.searchByCategoryAndBrand(category, brand);
	}

	@GetMapping("/search")
	public List<Product> search(@RequestParam String keyword) {
		return service.search(keyword);
	}

	@GetMapping("/sort")
	public List<Product> sort(@RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "ASC") String direction) {
		return service.sort(sortBy, direction);
	}

	@GetMapping("/filter")
	public Page<Product> filter(@RequestParam(required = false) String keyword,
			@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
			@RequestParam(required = false) BigDecimal minPrice, @RequestParam(required = false) BigDecimal maxPrice,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "ASC") String direction) {
		return service.filter(keyword, category, brand, minPrice, maxPrice, page, size, sortBy, direction);
	}
}
