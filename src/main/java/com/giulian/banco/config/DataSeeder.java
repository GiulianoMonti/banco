package com.giulian.banco.config;

import com.giulian.banco.model.Product;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.service.IProductService;
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

//    private static final Logger log = LoggerFactory.getLogger(DataSeederUsers.class);
//
//
//    @Autowired
//    private IProductService productService;
//
//    @Bean
//    CommandLineRunner initDatabaseProducts(
//                                   ProductRepository productRepository) {
//
//        return args -> {
//            createDefaultProducts();
//        };
//    }
//
//
//
//    void createDefaultProducts() {
//        String nameExample = "prod%d";
////        String lastNameExample = "Nuevo";
////        String emailExample = "UsuarioMail%d@mail.com";
////        String passwordExample = "123";
////        String photoExample = "Foto%d.jpg";
//
//        List<Product> productList = new ArrayList<>();
//        for (int i = 1; i <= 5; i++) {
//            Product productAux = new Product();
//            productAux.setName(String.format(nameExample,i));
//
//            productAux.setPrice((double) (Math.round((Math.random()+5+i)*100.0)/100.0));
//            productAux.setStock(10+i);
//
//            productList.add(productAux);
//        }
//        saveProducts(productList);
//    }
//
//
//
//    void saveProducts(List<Product> product) {
//
//        for (Product products: product){
//
//                productService.createProduct(products);
//
//        }
//    }
//


}
