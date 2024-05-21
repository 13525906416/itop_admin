package org.example.itop_admin.controller;

import org.example.itop_admin.entity.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ResourceController
 * @Author zhaoyb
 * @Date 2024-05-20
 * @Version 1.0
 */

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @GetMapping("/user")
    public ResponseEntity<MessageDTO> user(Authentication authentication) {
        return ResponseEntity.ok(new MessageDTO("Hello " + authentication.getName()));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MessageDTO> admin(Authentication authentication) {
        return ResponseEntity.ok(new MessageDTO("Hello " + authentication.getName()));
    }
}
