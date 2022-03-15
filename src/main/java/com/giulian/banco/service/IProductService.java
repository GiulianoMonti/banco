package com.giulian.banco.service;

import com.giulian.banco.model.Product;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();


    // faltan todos los DTO, no llego por ahora con el tiempo
    Product updateProduct(long id, Product product) throws Exception;

    Product getProductById(long id) throws Exception;
}
