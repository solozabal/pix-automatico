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
@Table(name = "logs_atividade")
public class LogAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Acao acao;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data_acao;

    public enum Acao {
        CRIACAO,
        ATUALIZACAO,
        CANCELAMENTO
    }

    // Getters e setters necessários
    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Timestamp getData_acao() {
        return data_acao;
    }

    public void setData_acao(Timestamp data_acao) {
        this.data_acao = data_acao;
    }
}