package com.solozabal.pixautomatico.pix_automatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solozabal.pixautomatico.pix_automatico.entity.PagamentoRecorrente;
import com.solozabal.pixautomatico.pix_automatico.entity.Transacao;
import com.solozabal.pixautomatico.pix_automatico.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao adicionarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> buscarTransacoesPorPagamento(PagamentoRecorrente pagamento) {
        return transacaoRepository.findByPagamento(pagamento);
    }
}