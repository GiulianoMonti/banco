package com.giulian.banco.service;

import com.giulian.banco.model.dto.Purchase;
import com.giulian.banco.model.dto.PurchaseResponse;

import javax.transaction.Transactional;

public interface IOrderService {
    @Transactional
    Purchase placeOrder(Purchase purchase);
}
