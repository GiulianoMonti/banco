package com.giulian.banco.controller;

import com.giulian.banco.model.Product;
import com.giulian.banco.payload.ProductDto;
import com.giulian.banco.service.IProductService;
import com.giulian.banco.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto dto) {

        return new ResponseEntity<>(productService.createProduct(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProduct() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto dto,
                                                    @PathVariable(name = "id") long id)
            throws Exception {

        ProductDto productResponse = productService.updateProduct(dto, id);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }


}
