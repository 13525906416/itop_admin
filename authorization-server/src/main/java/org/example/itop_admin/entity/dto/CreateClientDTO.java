package org.example.itop_admin.entity.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.Set;

/**
 * @ClassName CreateClientDTO
 * @Author zhaoyb
 * @Date 2024-05-17
 * @Version 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateClientDTO {
    private String clientId;
    private String clientSecret;
    private Set<ClientAuthenticationMethod> authenticationMethods;
    private Set<AuthorizationGrantType> authorizationGrantTypes;
    private Set<String> redirectUris;
    private Set<String> scopes;
    private boolean requireProofKey;
}