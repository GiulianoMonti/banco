package com.giulian.banco.dao;

import com.giulian.banco.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Purchase, Long> {
}
