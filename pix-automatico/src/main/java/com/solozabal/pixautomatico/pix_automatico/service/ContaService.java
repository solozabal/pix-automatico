package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.Conta;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta adicionarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> buscarContasPorUsuario(Usuario usuario) {
        return contaRepository.findByUsuario(usuario);
    }
}