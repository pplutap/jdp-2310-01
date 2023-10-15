package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findCartByIdTest() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        Long id3 = cart3.getId();
        List<Cart> cartList = cartRepository.findAll();
        assertEquals(3, cartList.size());

        //CleanUp
        cartRepository.deleteById(id1);
        cartRepository.deleteById(id2);
        cartRepository.deleteById(id3);

    }

    @Test
    public void deleteCartByIdTest() {
        //Given
        Product product1 = new Product("Product1Test", "Text", 99L);
        Product product2 = new Product("Product2Test", "Text", 199L);
        productRepository.save(product1);
        productRepository.save(product2);
        Long idProduct1 = product1.getId();
        Long idProduct2 = product2.getId();
        List<Product> productList = new ArrayList<>();
        productList.add(productRepository.findById(idProduct1).get());
        productList.add(productRepository.findById(idProduct2).get());
        Cart cart1 = new Cart(productList);

        //When
        cartRepository.save(cart1);

        //Then
        Long id1 = cart1.getId();
        cartRepository.deleteById(id1);
        assertFalse(cartRepository.existsById(id1));
        assertTrue(productRepository.existsById(idProduct1));
        assertTrue(productRepository.existsById(idProduct2));

    }

    @Test
    public void findAllCartsTest() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        Long id3 = cart3.getId();
        List<Cart> listCarts = cartRepository.findAll();
        assertEquals(3, listCarts.size());

        //CleanUp
        cartRepository.deleteById(id1);
        cartRepository.deleteById(id2);
        cartRepository.deleteById(id3);

    }

    @Test
    public void saveCartTest() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        assertNotNull(id1);
        assertNotNull(id2);

        //CleanUp
        cartRepository.deleteById(id1);
        cartRepository.deleteById(id2);

    }
}