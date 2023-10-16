package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orderMapper.mapToOrderDtoList(orders));
    }

    @RequestMapping(method = RequestMethod.GET, value = "orderId")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.getOrderById(orderId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "orderId")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long orderId, @PathVariable OrderDto orderDto) throws OrderNotFoundException {
        Order order = orderMapper.mapToOrder(orderDto);
        Order orderToUpdate = orderService.updateOrder(order, orderId);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderToUpdate));
    }

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.saveOrder(order);
        return ResponseEntity.ok().build();
    }
}
