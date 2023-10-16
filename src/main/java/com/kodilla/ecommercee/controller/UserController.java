package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(0001L,"Adam",1,020322005L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createUser(UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public UserDto updateUser(UserDto userDto) {
        return new UserDto(0001L,"Adam",1,010100110L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteUser(@PathVariable Long userId) {
    }
}
