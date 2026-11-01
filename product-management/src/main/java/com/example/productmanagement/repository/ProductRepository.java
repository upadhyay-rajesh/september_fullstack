package com.example.productmanagement.repository;
import com.example.productmanagement.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findByBrandIgnoreCase(String brand);
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByCategoryIgnoreCaseAndBrandIgnoreCase(String category, String brand);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE (:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND (:category IS NULL OR LOWER(p.category) = LOWER(:category)) AND (:brand IS NULL OR LOWER(p.brand) = LOWER(:brand)) AND (:minPrice IS NULL OR p.price >= :minPrice) AND (:maxPrice IS NULL OR p.price <= :maxPrice)")
    Page<Product> filterProducts(@Param("keyword") String keyword, @Param("category") String category,
        @Param("brand") String brand, @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice, Pageable pageable);
}
