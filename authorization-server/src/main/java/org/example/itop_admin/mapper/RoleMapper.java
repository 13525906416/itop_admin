package org.example.itop_admin.mapper;

import org.example.itop_admin.entity.Role;
import org.example.itop_admin.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleMapper extends JpaRepository<Role,Integer> {
    Optional<Role> findByRole(RoleName roleName);
}
