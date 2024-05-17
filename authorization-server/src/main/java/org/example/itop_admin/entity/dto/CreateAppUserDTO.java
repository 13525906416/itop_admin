package org.example.itop_admin.entity.dto;

import java.util.List;

/**
 * @ClassName CreateAppUser
 * @Author zhaoyb
 * @Date 2024-05-16
 * @Version 1.0
 */
public record CreateAppUserDTO(
        String username,
        String password,
        List<String>roles
) {
}