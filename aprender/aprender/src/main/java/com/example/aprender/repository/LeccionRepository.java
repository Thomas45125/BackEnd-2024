package com.example.aprender.repository;

import com.example.aprender.model.Leccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeccionRepository extends MongoRepository<Leccion, String> {
    
}
