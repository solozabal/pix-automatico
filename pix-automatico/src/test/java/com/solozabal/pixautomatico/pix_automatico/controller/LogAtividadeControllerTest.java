package com.solozabal.pixautomatico.pix_automatico.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solozabal.pixautomatico.pix_automatico.entity.LogAtividade;
import com.solozabal.pixautomatico.pix_automatico.service.JwtUserDetailsService;
import com.solozabal.pixautomatico.pix_automatico.service.LogAtividadeService;

@WebMvcTest(LogAtividadeController.class)
public class LogAtividadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogAtividadeService logAtividadeService;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @Test
    public void testListarLogs() throws Exception {
        LogAtividade log1 = new LogAtividade();
        LogAtividade log2 = new LogAtividade();
        List<LogAtividade> logs = Arrays.asList(log1, log2);

        when(logAtividadeService.listarLogs()).thenReturn(logs);

        mockMvc.perform(get("/logs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    public JwtUserDetailsService getJwtUserDetailsService() {
        return jwtUserDetailsService;
    }

    public void setJwtUserDetailsService(JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }
}