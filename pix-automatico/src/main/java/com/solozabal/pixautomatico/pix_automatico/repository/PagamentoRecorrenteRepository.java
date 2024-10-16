package com.solozabal.pixautomatico.pix_automatico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solozabal.pixautomatico.pix_automatico.entity.PagamentoRecorrente;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;

@Repository
public interface PagamentoRecorrenteRepository extends JpaRepository<PagamentoRecorrente, Long> {
    List<PagamentoRecorrente> findByUsuario(Usuario usuario);
}