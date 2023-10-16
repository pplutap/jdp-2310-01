package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(final Long id) throws OrderNotFoundException {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException("Order non invenitur per id: " + id));
    }

    public void deleteOrder(final Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(final Order order, final Long id) throws OrderNotFoundException {
        Optional<Order> orderEntity = orderRepository.findById(id);
        Order orderUpdate = orderEntity.orElseThrow(() ->
                new OrderNotFoundException("Order non invenitur per id: " + id));

        orderUpdate.setCreated(order.getCreated());
        orderUpdate.setCost(order.getCost());
        return orderRepository.save(orderUpdate);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }
}
