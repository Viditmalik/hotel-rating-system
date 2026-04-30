package com.micro.user.controller;

import com.micro.user.dto.UserDto;
import com.micro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ================= CREATE USER =================
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        UserDto savedUser = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // ================= GET SINGLE USER =================
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {

        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // ================= GET ALL USERS =================
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // ================= DELETE USER =================
    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDto> deleteUserById(@PathVariable String userId) {

        UserDto user = userService.deleteUserById(userId);
        return ResponseEntity.ok(user);
    }
}