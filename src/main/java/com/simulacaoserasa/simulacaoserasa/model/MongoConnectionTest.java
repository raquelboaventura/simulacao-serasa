package com.simulacaoserasa.simulacaoserasa.model;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MongoConnectionTest {

    private final MongoTemplate mongoTemplate;

    public MongoConnectionTest(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void testConnection() {
        try {
            log.info("Testando conexão com o MongoDB...");
            FindIterable<Document> collections = mongoTemplate.getDb().getCollection("simulacaoSerasa").find();
            log.info(collections);
            log.info("Conexão com o MongoDB bem-sucedida!");
        } catch (Exception e) {
            log.error("Erro ao conectar com o MongoDB: {}", e.getMessage(), e);
        }
    }
}
