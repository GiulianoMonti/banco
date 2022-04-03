package com.giulian.banco.service.impl;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.model.ShopProduct;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopProductServiceImpl implements IShopProductService {


    @Autowired
    private ShopProductRepository shopProductRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductRepository productRepository;


    public ShopProduct createShopProduct(Long shopId, Long productId) {
//        ShopProduct shopProducts = findByShopProduct(shop, product);

        ShopProduct shopProduct = new ShopProduct();


        Product product = productRepository.findById(productId)
                .orElseThrow();

        Shop shop = shopRepository.findById(shopId)
                .orElseThrow();

        shopProduct.setShop(shop);
        shopProduct.setProduct(product);

        return shopProductRepository.save(shopProduct);

    }

    private ShopProduct findByShopProduct(Shop shop, Product product) {
        return shopProductRepository.findByShopAndProduct(shop, product);
    }

}
