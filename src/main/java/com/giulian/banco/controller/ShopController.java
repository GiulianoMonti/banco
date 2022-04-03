package com.giulian.banco.controller;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.service.IShopService;
import com.giulian.banco.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ShopController {


    @Autowired
    IShopService shopService;

    @PostMapping
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {

        Shop shops = shopService.createShop(shop);
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }
}
