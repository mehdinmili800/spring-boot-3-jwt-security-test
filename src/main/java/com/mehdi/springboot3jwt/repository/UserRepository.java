package com.mehdi.springboot3jwt.repository;

import com.mehdi.springboot3jwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {

    Optional<UserEntity> findByEmail(String email);
}
