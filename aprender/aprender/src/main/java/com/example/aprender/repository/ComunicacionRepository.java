package com.example.aprender.repository;

import com.example.aprender.model.Comunicacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicacionRepository extends MongoRepository<Comunicacion, String> {
    
}
