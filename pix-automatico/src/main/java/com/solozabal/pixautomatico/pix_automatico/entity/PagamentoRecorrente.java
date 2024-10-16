package com.solozabal.pixautomatico.pix_automatico.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "pagamentos_recorrentes")
public class PagamentoRecorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamento_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date data_vencimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Frequencia frequencia;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean autorizacao_previa;

    // Enums para frequência e status
    public enum Frequencia {
        DIARIA,
        SEMANAL,
        MENSAL
    }

    public enum Status {
        ATIVO,
        CANCELADO
    }

    // Getters e setters necessários
    public Long getPagamento_id() {
        return pagamento_id;
    }

    public void setPagamento_id(Long pagamento_id) {
        this.pagamento_id = pagamento_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getAutorizacao_previa() {
        return autorizacao_previa;
    }

    public void setAutorizacao_previa(Boolean autorizacao_previa) {
        this.autorizacao_previa = autorizacao_previa;
    }
}