package com.example.restapiproject.repository;

import com.example.restapiproject.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
