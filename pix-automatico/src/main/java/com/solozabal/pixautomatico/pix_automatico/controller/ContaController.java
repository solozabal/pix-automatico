package com.solozabal.pixautomatico.pix_automatico.controller;

import com.solozabal.pixautomatico.pix_automatico.entity.Conta;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
        Conta novaConta = contaService.adicionarConta(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Conta>> listarContasPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioId);
        List<Conta> contas = contaService.buscarContasPorUsuario(usuario);
        return ResponseEntity.ok(contas);
    }
}