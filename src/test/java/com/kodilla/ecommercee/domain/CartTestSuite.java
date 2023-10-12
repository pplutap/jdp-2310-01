package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

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

        //When

        //Then

        //CleanUp

    }

    @Test
    public void findAllCartsTest() {
        //Given

        //When

        //Then

        //CleanUp

    }

    @Test
    public void saveCartTest() {
        //Given

        //When

        //Then

        //CleanUp

    }
}
