package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestConfiguration
@EnableWebSecurity
class TestSecurityConfig {
    @Bean
    SecurityFilterChain testFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            );
        return http.build();
    }
}

@WebMvcTest(controllers = {PublicApiController.class, UserApiController.class, AdminApiController.class})
@AutoConfigureMockMvc
@Import(TestSecurityConfig.class)
class HttpSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPublicEndpointWithoutAuth() throws Exception {
        mockMvc.perform(get("/public/info"))
                .andExpect(status().isOk());
    }

    @Test
    void testUserEndpointWithoutAuthFails() throws Exception {
        mockMvc.perform(get("/user/profile"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "USER")
    void testUserEndpointWithUserRole() throws Exception {
        mockMvc.perform(get("/user/profile"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void testAdminEndpointWithUserRoleFails() throws Exception {
        mockMvc.perform(get("/admin/dashboard"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testAdminEndpointWithAdminRole() throws Exception {
        mockMvc.perform(get("/admin/dashboard"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testUserEndpointWithAdminRole() throws Exception {
        mockMvc.perform(get("/user/profile"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeleteUserWithAdminRole() throws Exception {
        mockMvc.perform(delete("/admin/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void testDeleteUserWithUserRoleFails() throws Exception {
        mockMvc.perform(delete("/admin/users/1"))
                .andExpect(status().isForbidden());
    }
}
