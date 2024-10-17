package com.solozabal.pixautomatico.pix_automatico.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solozabal.pixautomatico.pix_automatico.entity.Conta;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.service.ContaService;

@WebMvcTest(ContaController.class)
public class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaService contaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCriarConta() throws Exception {
        Conta conta = new Conta();
        conta.setNome("Conta Teste");

        when(contaService.adicionarConta(conta)).thenReturn(conta);

        mockMvc.perform(post("/contas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(conta)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Conta Teste"));
    }

    @Test
    public void testListarContasPorUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1L);
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        List<Conta> contas = Arrays.asList(conta1, conta2);

        when(contaService.buscarContasPorUsuario(usuario)).thenReturn(contas);

        mockMvc.perform(get("/contas/usuario/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}