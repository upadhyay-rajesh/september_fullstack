package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderItemRequest;
import com.example.ordermanagement.dto.OrderRequest;
import com.example.ordermanagement.entity.*;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    private static final Set<String> SORT_FIELDS =
            Set.of("id", "customerName", "customerEmail", "status", "totalAmount", "createdAt", "updatedAt");

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public CustomerOrder create(OrderRequest request) {
        CustomerOrder order = new CustomerOrder();
        order.setCustomerName(request.getCustomerName());
        order.setCustomerEmail(request.getCustomerEmail());
        order.setShippingAddress(request.getShippingAddress());
        order.setStatus(OrderStatus.CREATED);

        BigDecimal total = BigDecimal.ZERO;
        for (OrderItemRequest requestedItem : request.getItems()) {
            Product product = productRepository.findById(requestedItem.getProductId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Product not found: " + requestedItem.getProductId()));
            int quantity = requestedItem.getQuantity();
            if (quantity < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be at least 1");
            }

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            item.setUnitPrice(product.getPrice());
            item.setLineTotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            order.addItem(item);
            total = total.add(item.getLineTotal());
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public List<CustomerOrder> findAll() { return orderRepository.findAll(); }

    public CustomerOrder findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found: " + id));
    }

    @Transactional
    public CustomerOrder update(Long id, OrderRequest request) {
        CustomerOrder order = findById(id);
        if (order.getStatus() != OrderStatus.CREATED) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Only orders with CREATED status can be edited");
        }

        order.setCustomerName(request.getCustomerName());
        order.setCustomerEmail(request.getCustomerEmail());
        order.setShippingAddress(request.getShippingAddress());
        order.removeAllItems();

        BigDecimal total = BigDecimal.ZERO;
        for (OrderItemRequest requestedItem : request.getItems()) {
            Product product = productRepository.findById(requestedItem.getProductId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Product not found: " + requestedItem.getProductId()));
            if (requestedItem.getQuantity() < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be at least 1");
            }
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(requestedItem.getQuantity());
            item.setUnitPrice(product.getPrice());
            item.setLineTotal(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            order.addItem(item);
            total = total.add(item.getLineTotal());
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        CustomerOrder order = findById(id);
        if (order.getStatus() != OrderStatus.CREATED && order.getStatus() != OrderStatus.CANCELLED) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Only CREATED or CANCELLED orders can be deleted");
        }
        orderRepository.delete(order);
    }

    public CustomerOrder updateStatus(Long id, OrderStatus status) {
        CustomerOrder order = findById(id);
        if (order.getStatus() == OrderStatus.DELIVERED || order.getStatus() == OrderStatus.CANCELLED) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Delivered or cancelled orders cannot change status");
        }
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<CustomerOrder> searchByCustomerName(String name) {
        return orderRepository.findByCustomerNameContainingIgnoreCase(name);
    }

    public List<CustomerOrder> searchByEmail(String email) {
        return orderRepository.findByCustomerEmailIgnoreCase(email);
    }

    public List<CustomerOrder> searchByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    public Page<CustomerOrder> page(int page, int size, String sortBy, String direction) {
        if (page < 0 || size < 1 || size > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Page must be >= 0 and size must be between 1 and 100");
        }
        if (!SORT_FIELDS.contains(sortBy)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Invalid sortBy. Allowed fields: " + SORT_FIELDS);
        }
        try {
            return orderRepository.findAll(PageRequest.of(page, size,
                    Sort.by(Sort.Direction.fromString(direction), sortBy)));
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Direction must be ASC or DESC");
        }
    }
}
