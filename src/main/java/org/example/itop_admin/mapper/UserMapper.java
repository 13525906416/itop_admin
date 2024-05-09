package org.example.itop_admin.mapper;

import org.example.itop_admin.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @ClassName UserMapper
 * @Author zhaoyb
 * @Date 2024-05-09
 * @Version 1.0
 */
public interface UserMapper extends JpaRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer id);

    Optional<User> findByUsername(String username);
}
