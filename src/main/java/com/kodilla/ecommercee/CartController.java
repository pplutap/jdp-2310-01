package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@PathVariable Long cartId) {
        return new CartDto(0002L, new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createCart(CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public CartDto updateCart(CartDto cartDto) {
        return new CartDto(0001L, new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteCart(@PathVariable Long cartId) {
    }
}