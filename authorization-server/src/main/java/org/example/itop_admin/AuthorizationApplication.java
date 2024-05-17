package org.example.itop_admin;

import org.example.itop_admin.entity.Role;
import org.example.itop_admin.enums.RoleName;
import org.example.itop_admin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName org.example.itop_admin.Application
 * @Author zhaoyb
 * @Date 2024-05-14
 * @Version 1.0
 */

@SpringBootApplication
public class AuthorizationApplication /*implements CommandLineRunner*/ {
//    @Autowired
//    private RoleMapper roleMapper;

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class,args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
//        Role userRole = Role.builder().role(RoleName.ROLE_USER).build();
//        roleMapper.save(adminRole);
//        roleMapper.save(userRole);
//    }
}