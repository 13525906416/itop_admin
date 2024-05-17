package org.example.itop_admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.itop_admin.entity.AppUser;
import org.example.itop_admin.entity.Role;
import org.example.itop_admin.entity.dto.CreateAppUserDTO;
import org.example.itop_admin.entity.dto.MessageDTO;
import org.example.itop_admin.enums.RoleName;
import org.example.itop_admin.mapper.AppUserMapper;
import org.example.itop_admin.mapper.RoleMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @ClassName AppUserService
 * @Author zhaoyb
 * @Date 2024-05-16
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserMapper appUserMapper;
    private final RoleMapper roleMapper;
    private final PasswordEncoder passwordEncoder;

    public MessageDTO createUser(CreateAppUserDTO dto){
        AppUser appUser = AppUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();

        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r -> {
            Role role = roleMapper.findByRole(RoleName.valueOf(r)).orElseThrow(() -> new RuntimeException("role not found"));
            roles.add(role);
        });

        appUser.setRoles(roles);
        appUserMapper.save(appUser);
        return new MessageDTO("user " + appUser.getUsername() + " saved");
    }
}
