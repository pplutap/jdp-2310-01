package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest
public class OrderTestSuite {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindById() {
        //Given
        Order order = new Order(LocalDate.of(2023,7,22));

        //When
        orderRepository.save(order);
        Long id = order.getId();

        //Then
        Order orderTest = orderRepository.findById(id).get();
        assertEquals(7,orderTest.getCreated().getMonthValue());

        //CleanUp
        orderRepository.delete(order);
    }

    @Test
    public void testFindAll() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,7,22));
        Order order2 = new Order(LocalDate.of(2023,8,24));
        Order order3 = new Order(LocalDate.of(2023,9,17));


        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //Then
        List<Order> orderList = orderRepository.findAll();
        assertEquals(3, orderList.size());

        //CleanUp
        orderRepository.delete(order1);
        orderRepository.delete(order2);
        orderRepository.delete(order3);
    }

    @Test
    public void testSave() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,3,16));
        Order order2 = new Order(LocalDate.of(2023,6,11));

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);

        //Then
        Long id1 = order1.getId();
        Long id2 = order2.getId();
        assertNotNull(id1);
        assertNotNull(id2);

        //CleanUp
        orderRepository.delete(order1);
        orderRepository.delete(order2);
    }

    @Test
    public void testUpdate() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,1,7));

        //When
        orderRepository.save(order1);
        Long id1 = order1.getId();
        order1 = orderRepository.findById(id1).get();
        order1.setCreated(LocalDate.of(2023,2,16));

        //Then
        orderRepository.save(order1);
        Order orderUpdate = orderRepository.findById(id1).get();
        assertEquals(16,orderUpdate.getCreated().getDayOfMonth());
        assertEquals(2,orderUpdate.getCreated().getMonthValue());

        //CleanUp
        orderRepository.delete(order1);
    }

    @Test
    public void testDelete() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,1,2));

        //When
        orderRepository.save(order1);
        Long id = order1.getId();

        //Then
        orderRepository.delete(order1);
        assertFalse(orderRepository.existsById(id));

        //CleanUp
        orderRepository.delete(order1);
    }
}
