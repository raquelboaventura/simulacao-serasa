package com.simulacaoserasa.simulacaoserasa.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.simulacaoserasa.simulacaoserasa.model.SimulacaoSerasa;

@Repository
public interface SimulacaoSerasaRepository extends MongoRepository<SimulacaoSerasa, String> {
    Optional<SimulacaoSerasa> findByCpf(String cpf); 
}
