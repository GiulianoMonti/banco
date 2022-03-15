package com.giulian.banco.service;

import com.giulian.banco.model.Product;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product updateProduct(Product product, long id) throws Exception;
    Product getProductById(long id) throws Exception;
}
