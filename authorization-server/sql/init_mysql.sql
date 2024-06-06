-- 用户授权确认表
CREATE TABLE oauth2_authorization_consent
(
    registered_client_id varchar(100)  NOT NULL,
    principal_name       varchar(200)  NOT NULL,
    authorities          varchar(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);
-- 用户认证信息表
CREATE TABLE oauth2_authorization
(
    id                            varchar(100) NOT NULL,
    registered_client_id          varchar(100) NOT NULL,
    principal_name                varchar(200) NOT NULL,
    authorization_grant_type      varchar(100) NOT NULL,
    authorized_scopes             varchar(1000) DEFAULT NULL,
    attributes                    blob          DEFAULT NULL,
    state                         varchar(500)  DEFAULT NULL,
    authorization_code_value      blob          DEFAULT NULL,
    authorization_code_issued_at  DATETIME      DEFAULT NULL,
    authorization_code_expires_at DATETIME      DEFAULT NULL,
    authorization_code_metadata   blob          DEFAULT NULL,
    access_token_value            blob          DEFAULT NULL,
    access_token_issued_at        DATETIME      DEFAULT NULL,
    access_token_expires_at       DATETIME      DEFAULT NULL,
    access_token_metadata         blob          DEFAULT NULL,
    access_token_type             varchar(100)  DEFAULT NULL,
    access_token_scopes           varchar(1000) DEFAULT NULL,
    oidc_id_token_value           blob          DEFAULT NULL,
    oidc_id_token_issued_at       DATETIME      DEFAULT NULL,
    oidc_id_token_expires_at      DATETIME      DEFAULT NULL,
    oidc_id_token_metadata        blob          DEFAULT NULL,
    refresh_token_value           blob          DEFAULT NULL,
    refresh_token_issued_at       DATETIME      DEFAULT NULL,
    refresh_token_expires_at      DATETIME      DEFAULT NULL,
    refresh_token_metadata        blob          DEFAULT NULL,
    user_code_value               blob          DEFAULT NULL,
    user_code_issued_at           DATETIME      DEFAULT NULL,
    user_code_expires_at          DATETIME      DEFAULT NULL,
    user_code_metadata            blob          DEFAULT NULL,
    device_code_value             blob          DEFAULT NULL,
    device_code_issued_at         DATETIME      DEFAULT NULL,
    device_code_expires_at        DATETIME      DEFAULT NULL,
    device_code_metadata          blob          DEFAULT NULL,
    PRIMARY KEY (id)
);
-- 客户端表
create table oauth2_registered_client
(
    id                            varchar(100)                       not null
        primary key,
    client_id                     varchar(100)                       not null,
    client_id_issued_at           datetime default CURRENT_TIMESTAMP not null,
    client_secret                 varchar(200)                       null,
    client_secret_expires_at      datetime                           null,
    client_name                   varchar(200)                       not null,
    client_authentication_methods varchar(1000)                      not null,
    authorization_grant_types     varchar(1000)                      not null,
    redirect_uris                 varchar(1000)                      null,
    post_logout_redirect_uris     varchar(1000)                      null,
    scopes                        varchar(1000)                      not null,
    client_settings               varchar(2000)                      not null,
    token_settings                varchar(2000)                      not null
);

INSERT INTO yb_admin.oauth2_registered_client (id, client_id, client_id_issued_at, client_secret, client_secret_expires_at, client_name, client_authentication_methods, authorization_grant_types, redirect_uris, post_logout_redirect_uris, scopes, client_settings, token_settings) VALUES ('31798d11-cf2d-46e8-9047-fb4de7d4c113', 'messaging-client', '2023-11-03 08:45:16', '$2a$10$07cVc8LFlDzes4CPghINM.V.y4va.IAZ4ccAYt9OISKb5KQcML.Um', null, '31798d11-cf2d-46e8-9047-fb4de7d4c113', 'client_secret_basic', 'refresh_token,client_credentials,authorization_code,urn:ietf:params:oauth:grant-type:sms_code', 'http://127.0.0.1:8731/login/oauth2/code/messaging-client-oidc,https://oauthdebugger.com/debug', '', 'openid,profile,message.read,message.write', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":true}', '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}');
INSERT INTO yb_admin.oauth2_registered_client (id, client_id, client_id_issued_at, client_secret, client_secret_expires_at, client_name, client_authentication_methods, authorization_grant_types, redirect_uris, post_logout_redirect_uris, scopes, client_settings, token_settings) VALUES ('8fb1e356-795a-4a31-b79c-9de1288c7215', 'pkce-message-client', '2023-11-07 08:10:37', null, null, '8fb1e356-795a-4a31-b79c-9de1288c7215', 'none', 'refresh_token,authorization_code', 'http://localhost:8731/login/oauth2/code/messaging-client-oidc,https://oauthdebugger.com/debug', '', 'message.read,message.write', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":true,"settings.client.require-authorization-consent":false}', '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}');
INSERT INTO yb_admin.oauth2_registered_client (id, client_id, client_id_issued_at, client_secret, client_secret_expires_at, client_name, client_authentication_methods, authorization_grant_types, redirect_uris, post_logout_redirect_uris, scopes, client_settings, token_settings) VALUES ('9c1edfdd-e014-40e6-9821-c50195ad7ae9', 'device-message-client', '2023-11-03 08:45:16', null, null, '9c1edfdd-e014-40e6-9821-c50195ad7ae9', 'none', 'refresh_token,urn:ietf:params:oauth:grant-type:device_code', '', '', 'message.read,message.write', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}', '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}');

