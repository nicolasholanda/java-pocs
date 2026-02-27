package com.github.nicolasholanda.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableWebSecurity
class HttpSecurityConfig {

    @Bean("httpSecurityFilterChain")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(basic -> {});
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        var admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

@RestController
@RequestMapping("/public")
class PublicApiController {
    @GetMapping("/info")
    String getInfo() {
        return "Public information";
    }
}

@RestController
@RequestMapping("/user")
class UserApiController {
    @GetMapping("/profile")
    String getProfile() {
        return "User profile";
    }

    @PostMapping("/update")
    String updateProfile(@RequestBody String data) {
        return "Profile updated: " + data;
    }
}

@RestController
@RequestMapping("/admin")
class AdminApiController {
    @GetMapping("/dashboard")
    String getDashboard() {
        return "Admin dashboard";
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id) {
        return "User deleted: " + id;
    }
}

public class HttpSecurityDemo {

    public static void execute() {
        System.out.println("HTTP Security Demo:");
        System.out.println("Features:");
        System.out.println("- SecurityFilterChain - configures security filters");
        System.out.println("- authorizeHttpRequests - defines URL-based authorization");
        System.out.println("- requestMatchers - matches URL patterns");
        System.out.println("- hasRole/hasAnyRole - role-based access control");
        System.out.println("- permitAll - allows unauthenticated access");
        System.out.println("- authenticated - requires authentication");
        System.out.println("- InMemoryUserDetailsManager - in-memory user store");
        System.out.println("- BCryptPasswordEncoder - password encoding");
        System.out.println("Run within Spring Boot context to test");
    }
}
