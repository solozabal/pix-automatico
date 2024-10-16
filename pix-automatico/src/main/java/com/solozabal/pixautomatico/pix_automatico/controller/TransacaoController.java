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
import com.solozabal.pixautomatico.pix_automatico.entity.Transacao;
import com.solozabal.pixautomatico.pix_automatico.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        Transacao novaTransacao = transacaoService.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @GetMapping("/pagamento/{pagamentoId}")
    public ResponseEntity<List<Transacao>> listarTransacoesPorPagamento(@PathVariable Long pagamentoId) {
        PagamentoRecorrente pagamento = new PagamentoRecorrente();
        pagamento.setPagamento_id(pagamentoId);
        List<Transacao> transacoes = transacaoService.buscarTransacoesPorPagamento(pagamento);
        return ResponseEntity.ok(transacoes);
    }
}