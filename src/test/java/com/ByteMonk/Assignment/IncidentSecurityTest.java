package com.ByteMonk.Assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IncidentSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUnauthenticatedAccess() throws Exception {
        // Attempt to access without credentials
        mockMvc.perform(get("/api/incidents"))
                .andExpect(status().isUnauthorized());  // Expect 401 Unauthorized
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void testAuthenticatedAccess() throws Exception {
        // Attempt to access with credentials
        mockMvc.perform(get("/api/incidents"))
                .andExpect(status().isOk());  // Expect 200 OK
    }
}