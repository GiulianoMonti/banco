package com.giulian.banco.config;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.repository.ShopRepository;
import com.giulian.banco.service.IProductService;
import com.giulian.banco.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSeeder {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);


    @Autowired
    private IShopService shopService;

    @Bean
    CommandLineRunner initDatabaseProducts(
                                   ShopRepository shopRepository) {

        return args -> {
            createDefaultProducts();
        };
    }



    void createDefaultProducts() {
        String nameExample = "shop %d";
//        String lastNameExample = "Nuevo";
//        String emailExample = "UsuarioMail%d@mail.com";
//        String passwordExample = "123";
//        String photoExample = "Foto%d.jpg";

        List<Shop> shopList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Shop shopAux = new Shop();
            shopAux.setName(String.format(nameExample,i));

            shopAux.setCode("code N "+(double) (Math.round((Math.random()+5+i))));
            shopList.add(shopAux);
        }
        saveShops(shopList);
    }



    void saveShops(List<Shop> shop) {

        for (Shop shops: shop){

                shopService.createShop(shops);

        }
    }



}
