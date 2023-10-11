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
        Order order1 = new Order(LocalDate.of(2023,2,25));

        //When
        orderRepository.save(order1);
        Long id = order1.getId();

        //Then
        Order orderTest = orderRepository.findById(id).get();
        assertEquals(25,orderTest.getCreated().getDayOfMonth());


        //CleanUp
        orderRepository.delete(order1);
    }

    @Test
    public void testFindAll() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,2,28));
        Order order2 = new Order(LocalDate.of(2023,3,21));
        Order order3 = new Order(LocalDate.of(2023,5,17));

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
        Order order1 = new Order(LocalDate.of(2023,2,28));
        Order order2 = new Order(LocalDate.of(2022,12,7));

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
        Order order1 = new Order(LocalDate.of(2023,11,11));

        //When
        orderRepository.save(order1);
        Long id = order1.getId();
        order1 = orderRepository.findById(id).get();
        order1.setCreated(LocalDate.of(2023,12,9));

        //Then
        orderRepository.save(order1);
        Order orderUpdate = orderRepository.findById(id).get();
        assertEquals(12,orderUpdate.getCreated().getMonthValue());

        //CleanUp
        orderRepository.delete(order1);
    }

    @Test
    public void testDelete() {
        //Given
        Order order1 = new Order(LocalDate.of(2023,2,28));
        Order order2 = new Order(LocalDate.of(2023,2,28));
        Order order3 = new Order(LocalDate.of(2023,2,28));

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
