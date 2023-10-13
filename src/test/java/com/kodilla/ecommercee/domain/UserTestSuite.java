package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanUp() {
        userRepository.deleteAll();
    }

    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    @Test
    public void findAllUsersTest() {
        //Given
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //When
        List<User> userList = userRepository.findAll();

        //Then
        Assertions.assertEquals(3, userList.size());
    }

    @Test
    public void findUserByIdTest() {
        //Given
        userRepository.save(user1);

        //When
        Long userId = user1.getId();
        Optional<User> testUser = userRepository.findById(userId);
        Long idTestUser = testUser.get().getId();

        //Then
        Assertions.assertNotNull(userId);
        Assertions.assertEquals(userId, idTestUser);
    }

    @Test
    public void deletingByIdTest() {
        //Given
        userRepository.save(user1);

        //When
        Long userId = user1.getId();
        userRepository.deleteById(userId);

        //Then
        Assertions.assertNotNull(userId);
        Assertions.assertFalse(userRepository.existsById(userId));
    }
}
