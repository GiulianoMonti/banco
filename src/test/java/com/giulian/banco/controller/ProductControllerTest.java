package com.giulian.banco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giulian.banco.model.Product;
import com.giulian.banco.payload.ProductDto;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.service.IProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductRepository productRepository;


    @Test
    void addProduct() throws Exception {
        // given - precondition or setup
        Product product = Product.builder()
                .name("first")
                .price(new BigDecimal(11))
                .stock(10)
                .build();

        given(productService.createProduct(any(ProductDto.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(objectMapper.writeValueAsString(product))));
        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.name",
                        is(product.getName())))
                .andExpect(jsonPath("$.stock",
                        is(product.getStock())))
                .andExpect(jsonPath("$.price",
                        is(product.getPrice())));
    }

    @Test
    void getProduct() throws Exception {

        List<ProductDto> listOfProducts = new ArrayList<>();
        listOfProducts.add(ProductDto.builder()
                .name("prueba1")
                .price(new BigDecimal(12.5))
                .stock(1111)
                .build());
        listOfProducts.add(ProductDto.builder()
                .name("prueba2")
                .price(new BigDecimal(1111.5))
                .stock(2222)
                .build());
        given(productService.getAllProducts()).willReturn(listOfProducts);
        // when - action or the behaviour that we are going to test
        ResultActions response =
                mockMvc.perform(get("/product"));
        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfProducts.size())));
    }


    @Test
    void updateProduct() throws Exception {

        ProductDto savedProduct = ProductDto.builder()
                .name("prueba1")
                .price(new BigDecimal(12.5))
                .stock(1111)
                .build();
        ProductDto updatedProduct = ProductDto.builder()
                .name("updated name")
                .price(new BigDecimal(123.5))
                .stock(4444)
                .build();

        when(productService.updateProduct( savedProduct,1L)).thenReturn(updatedProduct);

        mockMvc.perform(put("/product/{id}", 1L)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(savedProduct)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(updatedProduct.getName())))
                .andExpect(jsonPath("$.price", Matchers.is(updatedProduct.getPrice())))
                .andExpect(jsonPath("$.stock", Matchers.is(updatedProduct.getStock())))

                .andDo(print());

    }
}