package com.github.nicolasholanda.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableWebSecurity
class CsrfSecurityConfig {

    @Bean
    SecurityFilterChain csrfFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic(basic -> {});
        return http.build();
    }
}

@RestController
@RequestMapping("/api/public")
class PublicController {

    @GetMapping("/hello")
    String hello() {
        return "Hello Public";
    }
}

@RestController
@RequestMapping("/api/secure")
class SecureController {

    @GetMapping("/data")
    String getData() {
        return "Secure Data";
    }

    @PostMapping("/update")
    String updateData(@RequestBody String data) {
        return "Updated: " + data;
    }

    @DeleteMapping("/delete/{id}")
    String deleteData(@PathVariable Long id) {
        return "Deleted: " + id;
    }
}

public class CsrfProtectionDemo {

    public static void execute() {
        System.out.println("CSRF Protection Demo:");
        System.out.println("Features:");
        System.out.println("- CSRF tokens prevent cross-site request forgery");
        System.out.println("- CookieCsrfTokenRepository stores token in cookie");
        System.out.println("- GET requests don't require CSRF token");
        System.out.println("- POST, PUT, DELETE require valid CSRF token");
        System.out.println("- withHttpOnlyFalse allows JavaScript access");
        System.out.println("Run within Spring Boot context to test");
    }
}
