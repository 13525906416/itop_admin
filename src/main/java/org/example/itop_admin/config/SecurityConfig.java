package org.example.itop_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @ClassName SecurityConfig  5.4以后的版本都是通过组件的方式进行配置，不需要继承WebSecurityConfigurerAdapter，重写里面方法实现
 * @Author zhaoyb
 * @Date 2024-05-08
 * @Version 1.0
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {



//    5.4版本以后基于内存的管理器
    @Bean
    public UserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("user")
                        .authorities("app")
                        .roles("USER")
                        .build(),
                User.withUsername("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/admin")
//                        .hasAnyRole("USER","ADMIN")
                                .hasRole("ADMIN")
                                .requestMatchers("user")
                                .hasAnyRole("USER","ADMIN")
                                .requestMatchers("/")
                                .permitAll()
                )
                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")
                        .permitAll()

                );
        return http.build();
    }
}

//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                .anyRequest().authenticated()
//                )
//                .csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
//                .httpBasic(Customizer.withDefaults())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling((exceptions) -> exceptions
//                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//                .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
//                );