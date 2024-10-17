package com.solozabal.pixautomatico.pix_automatico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solozabal.pixautomatico.pix_automatico.entity.LogAtividade;
import com.solozabal.pixautomatico.pix_automatico.service.LogAtividadeService;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogAtividadeController {

    @Autowired
    private LogAtividadeService logAtividadeService;

    @GetMapping
    public ResponseEntity<List<LogAtividade>> listarLogs() {
        List<LogAtividade> logs = logAtividadeService.listarLogs();
        return ResponseEntity.ok(logs);
    }
}