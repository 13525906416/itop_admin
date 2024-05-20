package org.example.itop_admin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.itop_admin.entity.dto.CreateClientDTO;
import org.example.itop_admin.entity.dto.MessageDTO;
import org.example.itop_admin.service.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Clientcontroller
 * @Author zhaoyb
 * @Date 2024-05-17
 * @Version 1.0
 */
@RestController
@RequestMapping("/client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> create(@RequestBody CreateClientDTO createClientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(createClientDTO));
    }
}
