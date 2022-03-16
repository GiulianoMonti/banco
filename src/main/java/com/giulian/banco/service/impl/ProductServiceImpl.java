package com.giulian.banco.service.impl;

import com.giulian.banco.model.Product;
import com.giulian.banco.payload.ProductDto;
import com.giulian.banco.repository.ProductRepository;
import com.giulian.banco.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {


    ProductRepository productRepository;
    private ModelMapper mapper;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }


    public ProductDto createProduct(ProductDto dto) {
        Product product =
                mapToEntity(dto);

        // retrieve post entity by id
        Product newProduct = productRepository.save(product);
        // set post to comment entity
        ProductDto productResponse = mapToDTO(newProduct);

        return productResponse;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map
                (p -> mapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }


    // faltan todos los DTO, no llego por ahora con el tiempo
    @Override
    public ProductDto updateProduct(ProductDto dto, long id) throws Exception {

        // orelsethrow exception...
        // TODO excepciones si llego con el tiempo
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("TODO TTODO"));

        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());

        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);

    }

    @Override
    public ProductDto getProductById(long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new Exception("TODO"));
        return mapToDTO(product);
    }

    private ProductDto mapToDTO(Product product) {


        return mapper.map(product, ProductDto.class);
    }

    private Product mapToEntity(ProductDto productDto) {

        return mapper.map(productDto, Product.class);
    }

}
