package com.simulacaoserasa.simulacaoserasa.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Divida {
    private String credor;
        private double valor;
        private LocalDate dataVencimento;
        private String status;
}
