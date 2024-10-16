package com.solozabal.pixautomatico.pix_automatico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solozabal.pixautomatico.pix_automatico.entity.Notificacao;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByUsuarioAndStatus(Usuario usuario, Notificacao.Status status);
}