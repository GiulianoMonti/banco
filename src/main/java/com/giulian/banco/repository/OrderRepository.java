package com.giulian.banco.repository;

import com.giulian.banco.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
