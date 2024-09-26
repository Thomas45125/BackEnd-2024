package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface instructorRepository extends MongoRepository<instructor, String> { 
    Optional<instructor> findByEspecialidad(String especialidad);
}
