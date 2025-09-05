package com.personal.userregistration.business.service;

import com.personal.userregistration.business.dto.UserRegistrationDto;
import com.personal.userregistration.business.dto.UserResponseDto;
import com.personal.userregistration.infrastructure.domain.User;
import com.personal.userregistration.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        User newUser = new User();
        newUser.setName(userRegistrationDto.getName());
        newUser.setEmail(userRegistrationDto.getEmail());
        newUser.setPassword(userRegistrationDto.getPassword());
        newUser.setBirthdate(userRegistrationDto.getBirthdate());

        User savedUser = userRepository.save(newUser);

        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(savedUser.getId());
        responseDto.setName(savedUser.getName());
        responseDto.setEmail(savedUser.getEmail());
        responseDto.setBirthdate(savedUser.getBirthdate());

        return responseDto;
    }

    private UserResponseDto convertToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBirthdate(user.getBirthdate());

        return dto;
    }

    public UserResponseDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Email not found."));
    }

    public void deleteByEmail(String email) {
        Optional<User> userToDelete = Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found.")));
        userRepository.delete(userToDelete.get());
    }

}
