package com.solozabal.pixautomatico.pix_automatico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solozabal.pixautomatico.pix_automatico.entity.PagamentoRecorrente;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.service.PagamentoRecorrenteService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoRecorrenteController {

    @Autowired
    private PagamentoRecorrenteService pagamentoRecorrenteService;

    @PostMapping
    public ResponseEntity<PagamentoRecorrente> criarPagamentoRecorrente(@RequestBody PagamentoRecorrente pagamento) {
        PagamentoRecorrente novoPagamento = pagamentoRecorrenteService.adicionarPagamentoRecorrente(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamento);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PagamentoRecorrente>> listarPagamentosPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioId);
        List<PagamentoRecorrente> pagamentos = pagamentoRecorrenteService.buscarPagamentosPorUsuario(usuario);
        return ResponseEntity.ok(pagamentos);
    }
}