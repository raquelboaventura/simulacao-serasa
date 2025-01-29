package com.simulacaoserasa.simulacaoserasa.model;

import java.time.LocalDate;

import lombok.Data;


@Data
public class Protesto {
    private String cartorio;
    private double valor;
    private LocalDate dataProtesto;
}
