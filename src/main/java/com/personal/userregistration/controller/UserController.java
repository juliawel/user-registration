package com.personal.userregistration.controller;

import com.personal.userregistration.business.dto.UserRegistrationDto;
import com.personal.userregistration.business.dto.UserResponseDto;
import com.personal.userregistration.business.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        logger.info("Received user registration request: {}", userRegistrationDto);
        UserResponseDto responseDto = userService.registerUser(userRegistrationDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        List<UserResponseDto> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponseDto> findUserByEmail(@RequestParam String email) {
        UserResponseDto user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
        userService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        UserResponseDto updatedUser = userService.updateUserById(id, userRegistrationDto);
        return ResponseEntity.ok(updatedUser);
    }

}
