package com.giulian.banco.service.impl;

import com.giulian.banco.model.Shop;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements IShopService {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Shop createShop(Shop shop) {

        return shopRepository.save(shop);
    }


}
