package org.example.itop_admin.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @ClassName Users
 * @Author zhaoyb
 * @Date 2024-05-09
 * @Version 1.0
 */
@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private Boolean enabled;
    private String roles;
}
