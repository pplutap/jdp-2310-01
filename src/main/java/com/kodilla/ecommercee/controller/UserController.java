package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User createdUser = userService.saveUser(user);
        UserDto createdUserDto = userMapper.mapToUserDto(createdUser);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Void> blockUser(@PathVariable Long userId) throws UserNotFoundException {
        User userToBlock = userService.blockUser(userId);
        User blockedUser = userService.saveUser(userToBlock);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{userId}/token")
    public ResponseEntity<String> generateToken(@PathVariable Long userId, @RequestBody UserDto userDto) throws UserNotFoundException {
        User user = userMapper.mapToUser(userDto);
        if (userService.authenticateUser(userId, user)) {
            String token = UUID.randomUUID().toString();
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Błąd uwierzytelniania", HttpStatus.UNAUTHORIZED);
        }
    }
}