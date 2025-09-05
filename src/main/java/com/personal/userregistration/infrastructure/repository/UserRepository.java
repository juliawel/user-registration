package com.personal.userregistration.infrastructure.repository;

import com.personal.userregistration.infrastructure.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
