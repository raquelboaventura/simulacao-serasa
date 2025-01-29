package com.simulacaoserasa.simulacaoserasa.dto;

import java.util.List;

import com.simulacaoserasa.simulacaoserasa.model.Divida;
import com.simulacaoserasa.simulacaoserasa.model.HistoricoPagamento;
import com.simulacaoserasa.simulacaoserasa.model.Protesto;

public record SimulacaoSerasaDto(
    String cpf,
    int scoreCredito,
    String situacao,
    List<Divida> dividas,
    List<Protesto> protestos,
    List<HistoricoPagamento> historicoPagamentos
){}
