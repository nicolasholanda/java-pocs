package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {PublicController.class, SecureController.class})
@Import(CsrfSecurityConfig.class)
class CsrfProtectionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPublicEndpointWithoutAuth() throws Exception {
        mockMvc.perform(get("/api/public/hello"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testGetRequestWithoutCsrf() throws Exception {
        mockMvc.perform(get("/api/secure/data"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testPostRequestWithoutCsrfFails() throws Exception {
        mockMvc.perform(post("/api/secure/update")
                        .content("test data"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void testPostRequestWithCsrfSucceeds() throws Exception {
        mockMvc.perform(post("/api/secure/update")
                        .with(csrf())
                        .content("test data"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testDeleteRequestWithoutCsrfFails() throws Exception {
        mockMvc.perform(delete("/api/secure/delete/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void testDeleteRequestWithCsrfSucceeds() throws Exception {
        mockMvc.perform(delete("/api/secure/delete/1")
                        .with(csrf()))
                .andExpect(status().isOk());
    }
}
