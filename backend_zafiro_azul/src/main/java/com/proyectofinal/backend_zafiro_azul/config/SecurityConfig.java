package com.proyectofinal.backend_zafiro_azul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Forma correcta de deshabilitar CSRF en Spring Security 6
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permitir todas las peticiones sin autenticación
                );

        return http.build();
    }
}
