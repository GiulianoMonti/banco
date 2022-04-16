package com.giulian.banco.repository;

import com.giulian.banco.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Purchase, Long> {
//    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
