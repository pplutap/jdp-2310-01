package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class GroupTestSuite {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProductRepository productRepository;

    @AfterEach
    public void cleanUp() {
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void findGroupByIdTest() {
        //Given
        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();

        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);

        //When
        List<Group> groupList = groupRepository.findAll();

        //Then
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void groupSaveTest() {
        //Given
        Group group = new Group();

        //When
        groupRepository.save(group);
        Long id = group.getId();
        Optional<Group> groupTest = groupRepository.findById(id);

        //Then
        Assertions.assertTrue(groupTest.isPresent());
        Assertions.assertNotNull(id);
    }

    @Test
    public void groupUpdateTest() {
        //Given
        Group group = new Group();
        group.setProductsList(new ArrayList<>());
        Product product = new Product("TestProduct", "TestDescription", 100L, group);
        group.getProductsList().add(product);
        groupRepository.save(group);

        //When
        Product productBis = new Product("TestProductBis", "TestDescBis", 200L, group);
        group.getProductsList().add(productBis);

        //Then
        Assertions.assertEquals(2, group.getProductsList().size());
    }

    @Test
    public void groupProductsTest() {
        //Given
        Group group = new Group();
        group.setProductsList(new ArrayList<>());

        Product product1 = new Product("TestProduct1", "TestDesc1", 1L, group);
        Product product2 = new Product("TestProduct2", "TestDesc2", 2L, group);
        Product product3 = new Product("TestProduct3", "TestDesc3", 3L, group);

        group.getProductsList().add(product1);
        group.getProductsList().add(product2);
        group.getProductsList().add(product3);

        //When
        groupRepository.save(group);

        //Then
        Assertions.assertNotNull(group.getId());
        Assertions.assertNotNull(product1.getId());
        Assertions.assertNotNull(product2.getId());
        Assertions.assertNotNull(product3.getId());
        Assertions.assertEquals(3, group.getProductsList().size());
    }

    @Test
    public void groupProductsDeleteTest() {
        //Given
        Group group = new Group();
        group.setProductsList(new ArrayList<>());

        Product product1 = new Product("TestProduct1", "TestDesc1", 1L, group);
        Product product2 = new Product("TestProduct2", "TestDesc2", 2L, group);
        Product product3 = new Product("TestProduct3", "TestDesc3", 3L, group);

        group.getProductsList().add(product1);
        group.getProductsList().add(product2);
        group.getProductsList().add(product3);

        //When
        groupRepository.save(group);
        Long groupId = group.getId();
        Long product1Id = product1.getId();
        Long product2Id = product2.getId();
        Long product3Id = product3.getId();

        groupRepository.deleteById(group.getId());

        //Then
        Assertions.assertFalse(groupRepository.existsById(groupId));
        Assertions.assertFalse(groupRepository.existsById(product1Id));
        Assertions.assertFalse(groupRepository.existsById(product2Id));
        Assertions.assertFalse(groupRepository.existsById(product3Id));
    }

}
