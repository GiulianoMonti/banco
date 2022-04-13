package com.giulian.banco.service;

import com.giulian.banco.model.ShopProduct;

public interface IShopProductService {

   ShopProduct createShopProduct(Long shopId, Long productId);
}
