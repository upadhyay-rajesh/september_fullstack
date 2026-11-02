package com.example.ordermanagement.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/*
 * Read-only mapping to the products table created by the Product Management app.
 * This app reads product details but does not create/update/delete catalogue products.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    public Product() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
}
