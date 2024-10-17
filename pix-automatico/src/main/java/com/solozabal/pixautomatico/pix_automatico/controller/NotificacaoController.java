package com.solozabal.pixautomatico.pix_automatico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solozabal.pixautomatico.pix_automatico.entity.Notificacao;
import com.solozabal.pixautomatico.pix_automatico.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<Notificacao> enviarNotificacao(@RequestBody Notificacao notificacao) {
        Notificacao enviada = notificacaoService.enviarNotificacao(notificacao);
        return ResponseEntity.ok(enviada);
    }
}