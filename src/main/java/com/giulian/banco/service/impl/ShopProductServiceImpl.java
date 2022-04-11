package com.giulian.banco.service.impl;

import com.giulian.banco.model.OrderItem;
import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IShopProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public OrderItem createShopProduct(Long shopId, Long productId) {
        OrderItem shopProduct =
                new OrderItem();


        Product product = productRepository.findById(productId)
                .orElseThrow();

        Shop shop = shopRepository.findById(shopId)
                .orElseThrow();

        shopProduct.setShop(shop);
        shopProduct.setProduct(product);

    for(OrderItem sp : shopProductRepository.findAll()){
        if(sp.getShop().getId().equals(shopId) && sp.getProduct().getId().equals(productId)){
            throw new RuntimeException("Product already exists in this shop");
        }
    }

//        log.info("shopProductId: " +
//                shopProductRepository.findByShopId(shopId));

        return shopProductRepository.save(shopProduct);

    }



    private OrderItem findByShopProduct(Shop shop, Product product) {
        return shopProductRepository.findByShopAndProduct(shop, product);
    }

}
