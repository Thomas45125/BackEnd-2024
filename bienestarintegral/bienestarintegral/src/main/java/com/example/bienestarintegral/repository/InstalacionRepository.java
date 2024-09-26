package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Instalacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstalacionRepository extends MongoRepository<Instalacion, String> {
}
