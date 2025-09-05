package com.personal.userregistration.business.service;

import com.personal.userregistration.infrastructure.domain.User;
import com.personal.userregistration.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }


}
