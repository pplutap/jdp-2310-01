package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(), cartDto.getListProduct());
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getId(), cart.getListProduct());
    }
}
