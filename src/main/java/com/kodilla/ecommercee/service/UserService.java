package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(final Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public User blockUser(final Long userId) throws UserNotFoundException{
        Optional<User> userEntity = userRepository.findById(userId);
        User userToBlock = userEntity.orElseThrow(UserNotFoundException::new);
        // {4 = block status}
        userToBlock.setStatus(4);
        return userRepository.save(userToBlock);
    }

    public Boolean authenticateUser(final Long userId, User userToAuthenticate) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if(user.getUsername().equals(userToAuthenticate.getUsername()) || user.getUserKey().equals(userToAuthenticate.getUserKey())) {
            return true;
        } else {
            return false;
        }
    }
}