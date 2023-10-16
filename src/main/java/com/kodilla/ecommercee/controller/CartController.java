package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    //private final OrderMapper orderMapper;
    //private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CartDto> createEmptyCart() {
        Cart emptyCart = new Cart();
        CartDto cartDto = cartMapper.mapToCartDto(emptyCart);
        Cart createdCart = cartService.saveCart(emptyCart);
        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<List<ProductDto>> getProductsFromCart(@PathVariable Long cartId) throws CartNotFoundException {
        Cart cart = cartService.getCartById(cartId);
        List<Product> productList = cart.getListProduct();
        List<ProductDto> productListDto = productMapper.mapToProductDtoList(productList);
        return new ResponseEntity<>(productListDto, HttpStatus.OK);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long cartId, @RequestBody List<ProductDto> productsDto) throws CartNotFoundException {
        Cart cart = cartService.getCartById(cartId);
        for(ProductDto productDto : productsDto) {
            Product product = productMapper.mapToProduct(productDto);
            cart.addProductToCart(product);
        }
        cartService.saveCart(cart);
        CartDto cartDto = cartMapper.mapToCartDto(cart);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}/{productID}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable Long cartId, Long productId) throws CartNotFoundException {
        Cart cart = cartService.getCartById(cartId);
        cart.getListProduct().removeIf(product -> product.getId().equals(productId));
        cartService.saveCart(cart);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// potrzebna implementacja klas orderMapper, orderService
//    @PostMapping("/{cartId}")
//    public ResponseEntity<Order> crateOrderByCartId(@PathVariable Long cartId) throws CartNotFoundException {
//        Cart cart = cartService.getCartById(cartId);
//        Order order = new Order();
//        order.setCartId(cart);
//        Order createdOrder = orderService.createOrder(order);
//        OrderDto orderDto = orderMapper.mapToOrderDto(createdOrder);
//        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
//    }
}