package com.giulian.banco.service;

import com.giulian.banco.model.Product;
import com.giulian.banco.payload.ProductDto;

import java.util.List;

public interface IProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();




    // faltan todos los DTO, no llego por ahora con el tiempo
    ProductDto updateProduct(ProductDto dto, long id) throws Exception;

    ProductDto getProductById(long id) throws Exception;
}
