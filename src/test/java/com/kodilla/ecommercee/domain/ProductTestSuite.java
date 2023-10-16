package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class ProductTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindById() {
        //Given
        Product product = new Product("Product1Test", "Text", 99L);

        //When
        productRepository.save(product);
        Long id = product.getId();

        //Then
        Product productTest = productRepository.findById(id).get();
        assertEquals(99L, productTest.getPrice());

        //CleanUp
        productRepository.delete(product);
    }

    @Test
    public void testFindAll() {
        //Given
        Product product1 = new Product("Product1Test", "Text", 99L);
        Product product2 = new Product("Product2Test", "Text", 199L);
        Product product3 = new Product("Product3Test", "Text", 299L);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //Then
        List<Product> productList = productRepository.findAll();
        assertEquals(3, productList.size());

        //CleanUp
        productRepository.delete(product1);
        productRepository.delete(product2);
        productRepository.delete(product3);
    }

    @Test
    public void testSave() {
        //Given
        Product product1 = new Product("Product1Test", "Text", 99L);
        Product product2 = new Product("Product2Test", "Text", 199L);

        //When
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Long id1 = product1.getId();
        Long id2 = product1.getId();
        assertNotNull(id1);
        assertNotNull(id2);

        //CleanUp
        productRepository.delete(product1);
        productRepository.delete(product2);
    }

    @Test
    public void testUpdate() {
        //Given
        Product product1 = new Product("Product1Test", "Text", 99L);

        //When
        productRepository.save(product1);
        Long id = product1.getId();
        product1 = productRepository.findById(id).get();
        product1.setName("Product1Test update");
        product1.setPrice(299L);

        //Then
        productRepository.save(product1);
        Product productUpdate = productRepository.findById(id).get();
        assertEquals("Product1Test update", productUpdate.getName());
        assertEquals(299L, productUpdate.getPrice());

        //CleanUp
        productRepository.delete(product1);

    }

    @Test
    public void testDelete() {
        //Given
        Product product1 = new Product("Product1Test", "Text", 99L);
        Product product2 = new Product("Product2Test", "Text", 199L);
        Product product3 = new Product("Product3Test", "Text", 299L);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //Then
        productRepository.delete(product1);
        assertEquals(2, productRepository.findAll().size());

        //CleanUp
        productRepository.delete(product1);
        productRepository.delete(product2);
        productRepository.delete(product3);

    }
}