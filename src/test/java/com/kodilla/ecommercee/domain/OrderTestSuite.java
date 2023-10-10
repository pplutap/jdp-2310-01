package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindById() {
        //Given
        Order order1 = new Order("Order1", LocalDate.now());

        //When
        orderRepository.save(order1);
        Long id = order1.getId();

        //Then
        Order orderTest = orderRepository.findById(id).get();
        assertEquals("Order1",orderTest.getName());


        //CleanUp
        orderRepository.delete(order1);
    }

    @Test
    public void testFindAll() {
        //Given
        Order order1 = new Order("Order1", LocalDate.now());
        Order order2 = new Order("Order2", LocalDate.now());
        Order order3 = new Order("Order3", LocalDate.now());

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //Then
        List<Order> orderList = orderRepository.findAll();
        assertEquals(3,orderList.size());

        //CleanUp
        orderRepository.delete(order1);
        orderRepository.delete(order2);
        orderRepository.delete(order3);
    }

    @Test
    public void testSave() {
        //Given
        Order order1 = new Order("Order1", LocalDate.now());
        Order order2 = new Order("Order2", LocalDate.now());

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
        Order order1 = new Order("Order1", LocalDate.now());

        //When
        orderRepository.save(order1);
        Long id = order1.getId();
        order1 = orderRepository.findById(id).get();
        order1.setName("Order1 Test update");

        //Then
        orderRepository.save(order1);
        Order orderUpdate = orderRepository.findById(id).get();
        assertEquals("Order1 Test update",orderUpdate.getName());

        //CleanUp
        orderRepository.delete(order1);
    }

    @Test
    public void testDelete() {
        //Given
        Order order1 = new Order("Order1", LocalDate.now());
        Order order2 = new Order("Order2", LocalDate.now());
        Order order3 = new Order("Order3", LocalDate.now());

        //When
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        //Then
        orderRepository.delete(order2);
        assertEquals(2,orderRepository.findAll().size());

        //CleanUp
        orderRepository.delete(order1);
        orderRepository.delete(order3);

    }
}
