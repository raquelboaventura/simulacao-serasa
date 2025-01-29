package com.simulacaoserasa.simulacaoserasa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulacaoserasa.simulacaoserasa.dto.SimulacaoSerasaDto;
import com.simulacaoserasa.simulacaoserasa.model.SimulacaoSerasa;
import com.simulacaoserasa.simulacaoserasa.repository.SimulacaoSerasaRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SimulacaoSerasaService {
    @Autowired
    SimulacaoSerasaRepository simulacaoSerasaRepository;

    // Método para buscar os dados pelo CPF
    public SimulacaoSerasaDto buscarPorCpf(String cpf) {
        try {
            log.info("Realizando consulta no banco de dados.");
            Optional<SimulacaoSerasa> retorno = simulacaoSerasaRepository.findByCpf(cpf);
            log.info("Retorno db: {}", retorno);
            SimulacaoSerasaDto retornoDto =retorno.stream()
            .map(simulacao -> new SimulacaoSerasaDto(
                simulacao.getCpf(),
                simulacao.getScoreCredito(),
                simulacao.getSituacao(),
                simulacao.getDividas(),
                simulacao.getProtestos(),
                simulacao.getHistoricoPagamentos()
            )).findFirst()
            .orElse(null);
            log.info("retorno do banco de dados: {}", retornoDto);
            // Recupera o Optional<SimulacaoSerasa> e converte para Optional<SimulacaoSerasaDTO>
            return retornoDto;
        } catch (Exception e) {
            log.error("Não foi possível buscar CPF: {}", e.getMessage(), e);
            throw e;
        }
    }
    
}
