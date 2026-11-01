
package com.example.productmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products", indexes = {
    @Index(name = "idx_product_name", columnList = "name"),
    @Index(name = "idx_product_category", columnList = "category"),
    @Index(name = "idx_product_brand", columnList = "brand")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 2000)
    private String description;

    @NotBlank(message = "Category is required")
    @Column(nullable = false, length = 100)
    private String category;

    @NotBlank(message = "Brand is required")
    @Column(nullable = false, length = 100)
    private String brand;

    @NotNull(message = "Price is required")
    @DecimalMin(
        value = "0.01",
        message = "Price must be greater than zero"
    )
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @PositiveOrZero(
        message = "Stock quantity cannot be negative"
    )
    @Column(nullable = false)
    private Integer stockQuantity;

    @Min(value = 0, message = "Rating cannot be less than zero")
    @Max(value = 5, message = "Rating cannot exceed five")
    private Double rating;

    // Automatically generated when the product is created.
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Automatically updated when the product is modified.
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Default constructor required by JPA.
    public Product() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
