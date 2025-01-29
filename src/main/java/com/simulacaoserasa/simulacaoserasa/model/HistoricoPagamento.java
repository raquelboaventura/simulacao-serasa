package com.simulacaoserasa.simulacaoserasa.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HistoricoPagamento {
    private LocalDate data;
    private String status;
}
