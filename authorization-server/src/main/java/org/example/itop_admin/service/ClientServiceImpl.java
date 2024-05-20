package org.example.itop_admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.itop_admin.entity.Client;
import org.example.itop_admin.entity.dto.CreateClientDTO;
import org.example.itop_admin.entity.dto.MessageDTO;
import org.example.itop_admin.mapper.ClientMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

/**
 * @ClassName ClientServiceImpl
 * @Author zhaoyb
 * @Date 2024-05-17
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements RegisteredClientRepository {
    private final ClientMapper clientMapper;

    private final PasswordEncoder passwordEncoder;

    private Client clientFromDTO(CreateClientDTO dto){
        Client client = Client.builder()
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .authenticationMethods(dto.getAuthenticationMethods())
                .redirectUris(dto.getRedirectUris())
                .scopes(dto.getScopes())
                .authorizationGrantTypes(dto.getAuthorizationGrantTypes())
                .requireProofKey(dto.isRequireProofKey())
                .build();
        return client;
    }

    public MessageDTO create(CreateClientDTO dto){
        Client client = clientFromDTO(dto);
        clientMapper.save(client);
        return new MessageDTO("client " + client.getClientId() + " saved!");
    }


    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        Client client = clientMapper.findByClientId(id).orElseThrow(() -> new RuntimeException("client not fount"));

        return Client.toRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientMapper.findByClientId(clientId).orElseThrow(() -> new RuntimeException("client not fount"));

        return Client.toRegisteredClient(client);
    }


}
