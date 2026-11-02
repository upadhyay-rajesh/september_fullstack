package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.OrderRequest;
import com.example.ordermanagement.entity.CustomerOrder;
import com.example.ordermanagement.entity.OrderStatus;
import com.example.ordermanagement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<CustomerOrder> create(@Valid @RequestBody OrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public List<CustomerOrder> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public CustomerOrder getById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public CustomerOrder update(@PathVariable Long id, @Valid @RequestBody OrderRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public CustomerOrder updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/search/customer")
    public List<CustomerOrder> searchByCustomer(@RequestParam String name) {
        return service.searchByCustomerName(name);
    }

    @GetMapping("/search/email")
    public List<CustomerOrder> searchByEmail(@RequestParam String email) {
        return service.searchByEmail(email);
    }

    @GetMapping("/search/status")
    public List<CustomerOrder> searchByStatus(@RequestParam OrderStatus status) {
        return service.searchByStatus(status);
    }

    @GetMapping("/page")
    public Page<CustomerOrder> page(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "createdAt") String sortBy,
                                    @RequestParam(defaultValue = "DESC") String direction) {
        return service.page(page, size, sortBy, direction);
    }
}
