package com.solozabal.pixautomatico.pix_automatico.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(nullable = false)
    private String senha_hash;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data_cadastro;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean autenticacao_2f;

    // Getters e setters necessários
    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    // New method to set usuario_id
    public void setUsuarioId(Long usuarioId) {
        this.usuario_id = usuarioId;
    }
}