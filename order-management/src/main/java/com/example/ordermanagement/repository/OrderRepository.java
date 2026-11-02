package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.CustomerOrder;
import com.example.ordermanagement.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByCustomerNameContainingIgnoreCase(String customerName);
    List<CustomerOrder> findByCustomerEmailIgnoreCase(String customerEmail);
    List<CustomerOrder> findByStatus(OrderStatus status);
}
