package org.example.itop_admin.entity;

import lombok.Data;

/**
 * @ClassName AuthticationReq
 * @Author zhaoyb
 * @Date 2024-05-09
 * @Version 1.0
 */
@Data
public class AuthenticationReq {
    private String username;
    private String password;
}
