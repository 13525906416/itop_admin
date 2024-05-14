package org.example.itop_admin.controller;

import org.example.itop_admin.config.MyUserDetailsService;
import org.example.itop_admin.entity.AuthenticationReq;
import org.example.itop_admin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author zhaoyb
 * @Date 2024-05-08
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String sayHelloSecurity() {
        return "Hello,Security!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello,USER!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello,ADMIN!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationReq req) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        } catch (BadCredentialsException e) {
            throw new IllegalArgumentException("验证失败");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        String token = jwtUtil.generateTaken(userDetails);

        return ResponseEntity.ok(token);
    }
}
