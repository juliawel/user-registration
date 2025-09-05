package com.personal.userregistration.infrastructure.repository;

import com.personal.userregistration.infrastructure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
