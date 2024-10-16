package com.solozabal.pixautomatico.pix_automatico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solozabal.pixautomatico.pix_automatico.entity.Conta;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByUsuario(Usuario usuario);
}