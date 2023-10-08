package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class OrderTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindById() {
        //Given

        //When

        //Then

        //CleanUp
    }

    @Test
    public void testFindAll() {
        //Given

        //When

        //Then

        //CleanUp
    }

    @Test
    public void testSave() {
        //Given

        //When

        //Then

        //CleanUp
    }

    @Test
    public void testUpdate() {
        //Given

        //When

        //Then

        //CleanUp
    }

    @Test
    public void testDelete() {
        //Given

        //When

        //Then

        //CleanUp
    }
}
