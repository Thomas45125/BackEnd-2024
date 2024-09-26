package com.example.aprender.repository;

import com.example.aprender.model.Modulo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends MongoRepository<Modulo, String> {
    
}
