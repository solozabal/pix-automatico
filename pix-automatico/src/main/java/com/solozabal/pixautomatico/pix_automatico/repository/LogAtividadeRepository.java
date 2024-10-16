package com.solozabal.pixautomatico.pix_automatico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solozabal.pixautomatico.pix_automatico.entity.LogAtividade;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;

@Repository
public interface LogAtividadeRepository extends JpaRepository<LogAtividade, Long> {
    List<LogAtividade> findByUsuario(Usuario usuario);
}