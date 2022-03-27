package com.giulian.banco.config;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class DataSeeder {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);


    @Autowired
    private IShopService shopService;

    @Bean
    CommandLineRunner initDatabaseProducts(
            ProductRepository productRepository,

            ShopRepository shopRepository) {

        return args -> {
//            Product product1 = new Product(1L, "product 1", new BigDecimal(100),
//                    100);
//            Product product2 = new Product(2L, "product 2", new BigDecimal(200),
//                    200);
//            Product product3 = new Product(3L, "product 3", new BigDecimal(300), 300);
//            Product product4 = new Product(4L, "product 4", new BigDecimal(400), 400);

            Shop shop1 = new Shop(1L, "shop 1", "code 1");
            Shop shop2 = new Shop(2L, "shop 2", "code 2");
            Shop shop3 = new Shop(3L, "shop 3", "code 3");
            Shop shop4 = new Shop(4L, "shop 4", "code 4");

            List<Shop> shopList = new ArrayList<>();
            Collections.addAll(shopList, shop1, shop2, shop3, shop4);
            saveShops(shopList, shopRepository);
        };


    }


    void saveShops(List<Shop> shops, ShopRepository shopRepository) {
        for (Shop shop : shops) {
            if (!shopRepository.existsByName(shop.getName())) {
                shopRepository.save(shop);
            }
        }
    }

    void saveShops(List<Shop> shop) {

        for (Shop shops : shop) {

            shopService.createShop(shops);

        }
    }


}
