package com.solozabal.pixautomatico.pix_automatico.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificacoes")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificacao_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 255)
    private String mensagem;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data_envio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        LIDA,
        NAO_LIDA
    }

    // Getters e setters necessários
    public Long getNotificacao_id() {
        return notificacao_id;
    }

    public void setNotificacao_id(Long notificacao_id) {
        this.notificacao_id = notificacao_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Timestamp getData_envio() {
        return data_envio;
    }

    public void setData_envio(Timestamp data_envio) {
        this.data_envio = data_envio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}