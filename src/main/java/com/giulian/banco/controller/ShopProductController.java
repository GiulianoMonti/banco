package com.giulian.banco.controller;

import com.giulian.banco.model.OrderItem;
import com.giulian.banco.service.IProductService;
import com.giulian.banco.service.IShopProductService;
import com.giulian.banco.service.IShopService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/shopProduct")
public class ShopProductController {

    IProductService productService;
    IShopService shopService;
    IShopProductService shopProductService;

    public ShopProductController(IProductService productService,
                                 IShopService shopService,
                                 IShopProductService shopProductService) {
        this.productService = productService;
        this.shopService = shopService;
        this.shopProductService = shopProductService;

    }

    @PostMapping("/create/{shopId}/{productId}")
    private OrderItem createShopProducts(
            @PathVariable("shopId") Long shopId,
            @PathVariable("productId") Long productId) {
        OrderItem shopProducts =
               shopProductService.createShopProduct(shopId, productId);

       return shopProducts;

    }
}
