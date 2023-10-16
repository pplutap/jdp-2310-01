package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getCartId(),
                orderDto.getUserId(),
                orderDto.getCreated(),
                orderDto.getCost()
        );
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getCartId(),
                order.getUserId(),
                order.getCreated(),
                order.getCost()
        );
    }

    public List<Order> mapToOrderList(final List<OrderDto> orderList) {
        return orderList.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
