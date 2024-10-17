package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.LogAtividade;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.repository.LogAtividadeRepository;

@Service
public class LogAtividadeService {

    @Autowired
    private LogAtividadeRepository logAtividadeRepository;

    public LogAtividade adicionarLogAtividade(LogAtividade log) {
        return logAtividadeRepository.save(log);
    }

    public List<LogAtividade> buscarLogsPorUsuario(Usuario usuario) {
        return logAtividadeRepository.findByUsuario(usuario);
    }

    // Implementação do método listarLogs
    public List<LogAtividade> listarLogs() {
        return logAtividadeRepository.findAll();
    }
}