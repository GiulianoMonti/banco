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

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }


    // faltan todos los DTO, no llego por ahora con el tiempo
    @Override
    public Product updateProduct(long id,Product product) throws Exception {

        // orelsethrow exception...
        // TODO excepciones si llego con el tiempo
        Product productUpdated = productRepository.findById(id)
                .orElseThrow (()->new  Exception("TODO TTODO"));

        productUpdated.setName(product.getName());
        productUpdated.setStock(product.getStock());
        productUpdated.setPrice(product.getPrice());

        return  productRepository.save(productUpdated);

    }

    @Override
    public Product getProductById(long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new Exception("TODO"));
        return product;
    }

}
