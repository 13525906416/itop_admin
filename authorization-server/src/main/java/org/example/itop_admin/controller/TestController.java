package org.example.itop_admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author zhaoyb
 * @Date 2024-05-23
 * @Version 1.0
 */
@RestController
public class TestController {
    @GetMapping("/test01")
    @PreAuthorize("hasAuthority('SCOPE_message.read')")
    public String test01() {
        return "test01";
    }

    @GetMapping("/test02")
    @PreAuthorize("hasAuthority('SCOPE_message.write')")
    public String test02() {
        return "test02";
    }

    @GetMapping("/app")
    @PreAuthorize("hasAuthority('app')")
    public String app() {
        return "app";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_admin')")
    public String admin() {
        return "hello admin";
    }
}
