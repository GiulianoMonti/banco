package com.giulian.banco.service;

import com.giulian.banco.model.OrderItem;

public interface IShopProductService {

   OrderItem createShopProduct(Long shopId, Long productId);
}
