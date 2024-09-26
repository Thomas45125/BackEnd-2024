package com.example.aprender.repository;

import com.example.aprender.model.Progreso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoRepository extends MongoRepository<Progreso, String> {
    
}
