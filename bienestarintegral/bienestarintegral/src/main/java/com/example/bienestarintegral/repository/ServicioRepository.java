package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
}
