package org.example.itop_admin.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author zhaoyb
 * @Date 2024-05-08
 * @Version 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHelloSecurity(){
        return "say Hello,Security!";
    }

    @GetMapping("/user")
    public String user(){
        return "Hello,USER!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello,ADMIN!";
    }
}
