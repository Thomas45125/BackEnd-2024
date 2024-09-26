package com.example.aprender.repository;

import com.example.aprender.model.Evaluacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends MongoRepository<Evaluacion, String> {
    
}
