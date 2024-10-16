package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.Notificacao;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao adicionarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> buscarNotificacoesPorUsuarioEStatus(Usuario usuario, Notificacao.Status status) {
        return notificacaoRepository.findByUsuarioAndStatus(usuario, status);
    }
}