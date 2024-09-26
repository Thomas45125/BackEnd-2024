package com.example.aprender.repository;

import com.example.aprender.model.InformeRendimiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRendimientoRepository extends MongoRepository<InformeRendimiento, String> {
    
}
