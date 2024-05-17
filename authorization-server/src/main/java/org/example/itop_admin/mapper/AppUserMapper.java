package org.example.itop_admin.mapper;

import org.example.itop_admin.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserMapper extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);
}
