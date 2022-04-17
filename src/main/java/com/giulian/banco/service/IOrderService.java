package com.giulian.banco.service;

import com.giulian.banco.model.Purchase;

import javax.transaction.Transactional;
import java.util.List;

public interface IOrderService {
    List<Purchase> findAll();

    Purchase findById(Long id);

    List<Purchase> save(List<Purchase> purchase);
}
