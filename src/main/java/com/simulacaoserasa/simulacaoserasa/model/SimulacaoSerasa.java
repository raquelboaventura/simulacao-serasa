package com.simulacaoserasa.simulacaoserasa.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Data
@Document("simulacaoSerasa")
@NoArgsConstructor
@AllArgsConstructor
public class SimulacaoSerasa {
    @Id
    private String id;
    @Field("cpf")
    private String cpf;
    private int scoreCredito;
    private String situacao;
    private List<Divida> dividas;
    private List<Protesto> protestos;
    private List<HistoricoPagamento> historicoPagamentos;

public SimulacaoSerasa(String cpf){
    this.cpf = cpf;
    }
}