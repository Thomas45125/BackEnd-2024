package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<usuario, String> {
    
    Optional<usuario> findByEmail(String email);

}
