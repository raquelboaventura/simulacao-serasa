package com.simulacaoserasa.simulacaoserasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.simulacaoserasa.simulacaoserasa.repository")
public class SimulacaoserasaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimulacaoserasaApplication.class, args);
	}
	
}
