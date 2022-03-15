package com.giulian.banco.mock;

import com.giulian.banco.model.Product;
import com.giulian.banco.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Service
public class MockService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void populateProductsFromApi() {


        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "https://mocki.io/v1/e21989f9-f390-456c-a49a-28fa7b0033a8",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        List<Product> result = response.getBody();

        // Save the list into a database
        if(Objects.nonNull(result)) result.stream().filter(Objects::nonNull).
                forEach(element -> productRepository.saveAndFlush(element));


    }
}
