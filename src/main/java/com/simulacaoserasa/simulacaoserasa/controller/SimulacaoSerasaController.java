package com.simulacaoserasa.simulacaoserasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulacaoserasa.simulacaoserasa.dto.SimulacaoSerasaDto;
import com.simulacaoserasa.simulacaoserasa.model.MongoConnectionTest;
import com.simulacaoserasa.simulacaoserasa.services.SimulacaoSerasaService;

import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
@RequestMapping("/consulta")
public class SimulacaoSerasaController {

    private final SimulacaoSerasaService simulacaoSerasaService;
    @Autowired
    private MongoConnectionTest mongodb;

    public SimulacaoSerasaController(SimulacaoSerasaService simulacaoSerasaService) {
        this.simulacaoSerasaService = simulacaoSerasaService;
    }

    @GetMapping("/{cpf}")
    // Endpoint para buscar os dados pelo CPF
    public ResponseEntity<SimulacaoSerasaDto> buscarPorCpf(@PathVariable String cpf) {
    try {
        log.info("Buscando informações no banco de dados.");
        mongodb.testConnection();
        SimulacaoSerasaDto simulacaoDto = simulacaoSerasaService.buscarPorCpf(cpf);
        
        // Verifica se o valor está presente
        if (simulacaoDto != null) {
            return ResponseEntity.ok(simulacaoDto);
        } else {
            // Retorna 404 se não encontrado
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        log.error("Erro ao buscar CPF: {}", e.getMessage(), e);
        // Retorna 500 em caso de erro
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}
