package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.Notificacao;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.repository.NotificacaoRepository;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Notificacao adicionarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> buscarNotificacoesPorUsuarioEStatus(Usuario usuario, Notificacao.Status status) {
        return notificacaoRepository.findByUsuarioAndStatus(usuario, status);
    }

    // Implementação do método enviarNotificacao
    public Notificacao enviarNotificacao(Notificacao notificacao) {
        // Lógica para enviar a notificação por email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notificacao.getDestinatario());
        message.setSubject("Nova Notificação");
        message.setText(notificacao.getMensagem());

        mailSender.send(message);

        // Salvamos a notificação no repositório
        return notificacaoRepository.save(notificacao);
    }
}