package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "orderId")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(1L, 0002L, 1010L, LocalDate.parse("2023-09-27"), new BigDecimal(1200));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "orderId")
    public void deleteOrder(@PathVariable Long orderId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(0001L, 0002L, 1010L, LocalDate.parse("2023-09-27"), new BigDecimal(1200));
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createOrder(OrderDto orderDto) {

    }
}
