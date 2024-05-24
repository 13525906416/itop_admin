package org.example.itop_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @ClassName ClientApplication
 * @Author zhaoyb
 * @Date 2024-05-24
 * @Version 1.0
 */
@SpringBootApplication
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}
