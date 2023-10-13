package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CartTestSuite {

        @Autowired
        private CartRepository cartRepository;

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
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        cartRepository.deleteById(id1);
        cartRepository.deleteById(id2);
        assertFalse(cartRepository.existsById(id1));
        assertFalse(cartRepository.existsById(id2));

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
        assertEquals(3,listCarts.size());

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
