package com.lothin.phoneshp.serviceimplement;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.repository.ProductRepository;
import com.lothin.phoneshp.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImple implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
