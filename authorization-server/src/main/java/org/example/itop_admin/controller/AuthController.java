package org.example.itop_admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.itop_admin.entity.dto.CreateAppUserDTO;
import org.example.itop_admin.entity.dto.MessageDTO;
import org.example.itop_admin.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AuthController
 * @Author zhaoyb
 * @Date 2024-05-16
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/createUser")
    public ResponseEntity<MessageDTO> createUser(@RequestBody CreateAppUserDTO createAppUserDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(createAppUserDTO));
    }
}
