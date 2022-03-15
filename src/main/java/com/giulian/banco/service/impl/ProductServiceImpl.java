package com.giulian.banco.service.impl;

import com.giulian.banco.model.Product;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){

        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

}
