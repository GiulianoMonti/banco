package com.giulian.banco.service;

import com.giulian.banco.model.Product;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();
}
