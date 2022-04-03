package com.giulian.banco.service.impl;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.model.ShopProduct;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IShopProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ShopProductServiceImpl implements IShopProductService {


    private ShopProductRepository shopProductRepository;

    private ShopRepository shopRepository;
    private ProductRepository productRepository;

    @Autowired
    public ShopProductServiceImpl(ShopProductRepository shopProductRepository,
                                  ShopRepository shopRepository,
                                  ProductRepository productRepository) {
        this.shopProductRepository = shopProductRepository;
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }


    public ShopProduct createShopProduct(Long shopId, Long productId) {
        ShopProduct shopProduct =
                new ShopProduct();


        Product product = productRepository.findById(productId)
                .orElseThrow();

        Shop shop = shopRepository.findById(shopId)
                .orElseThrow();



        shopProduct.setShop(shop);
        shopProduct.setProduct(product);

    for(ShopProduct sp : shopProductRepository.findAll()){
        if(sp.getShop().getId().equals(shopId) && sp.getProduct().getId().equals(productId)){
            throw new RuntimeException("Product already exists in this shop");
        }
    }

//        log.info("shopProductId: " +
//                shopProductRepository.findByShopId(shopId));

        return shopProductRepository.save(shopProduct);

    }



    private ShopProduct findByShopProduct(Shop shop, Product product) {
        return shopProductRepository.findByShopAndProduct(shop, product);
    }

}
