package com.admafk.union.union_app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
open class SecurityConfig {

    @Bean
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() }  // Desabilita CSRF para simplificar a segurança em APIs REST
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/api/auth/**").permitAll()  // Permitir acesso público à rota de autenticação
                    .anyRequest().authenticated()  // Todas as outras requisições precisam de autenticação
            }
            .sessionManagement { session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) } // Define a política de sessão como STATELESS para APIs
            .httpBasic { httpBasic -> }  // Usa autenticação básica HTTP para simplificar

        return http.build()
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()  // Define o codificador de senha como BCrypt
    }
}
