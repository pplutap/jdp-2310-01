package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(final Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product non invenitur per id: " + id));
    }

    public void deleteProduct(final Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(final Product product, final Long id) throws ProductNotFoundException {
        Optional<Product> productEntity = productRepository.findById(id);
        Product productToUpdate = productEntity.orElseThrow(() ->
                new ProductNotFoundException("Product non invenitur per id: " + id));

        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setGroup(product.getGroup());
        productToUpdate.setDescription(product.getDescription());
        return productRepository.save(productToUpdate);
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }
}
