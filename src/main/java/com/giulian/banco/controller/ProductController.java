package com.giulian.banco.controller;

import com.giulian.banco.model.Product;
import com.giulian.banco.service.IProductService;
import com.giulian.banco.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        Product products = productService.createProduct(product);


        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }



}
