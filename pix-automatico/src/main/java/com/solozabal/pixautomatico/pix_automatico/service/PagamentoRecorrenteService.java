package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.PagamentoRecorrente;
import com.solozabal.pixautomatico.pix_automatico.entity.Usuario;
import com.solozabal.pixautomatico.pix_automatico.repository.PagamentoRecorrenteRepository;

@Service
public class PagamentoRecorrenteService {

    @Autowired
    private PagamentoRecorrenteRepository pagamentoRecorrenteRepository;

    public PagamentoRecorrente adicionarPagamentoRecorrente(PagamentoRecorrente pagamento) {
        return pagamentoRecorrenteRepository.save(pagamento);
    }

    public List<PagamentoRecorrente> buscarPagamentosPorUsuario(Usuario usuario) {
        return pagamentoRecorrenteRepository.findByUsuario(usuario);
    }
}