package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
}

