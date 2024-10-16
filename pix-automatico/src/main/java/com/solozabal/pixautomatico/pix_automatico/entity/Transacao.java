package com.solozabal.pixautomatico.pix_automatico.entity;

import java.math.BigDecimal;
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
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transacao_id;

    @ManyToOne
    @JoinColumn(name = "pagamento_id", nullable = false)
    private PagamentoRecorrente pagamento;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data_transacao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor_transacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTransacao status_transacao;

    public enum StatusTransacao {
        SUCESSO,
        FALHA
    }

    // Getters e setters necessários
    public Long getTransacao_id() {
        return transacao_id;
    }

    public void setTransacao_id(Long transacao_id) {
        this.transacao_id = transacao_id;
    }

    public PagamentoRecorrente getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoRecorrente pagamento) {
        this.pagamento = pagamento;
    }

    public Timestamp getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Timestamp data_transacao) {
        this.data_transacao = data_transacao;
    }

    public BigDecimal getValor_transacao() {
        return valor_transacao;
    }

    public void setValor_transacao(BigDecimal valor_transacao) {
        this.valor_transacao = valor_transacao;
    }

    public StatusTransacao getStatus_transacao() {
        return status_transacao;
    }

    public void setStatus_transacao(StatusTransacao status_transacao) {
        this.status_transacao = status_transacao;
    }
}