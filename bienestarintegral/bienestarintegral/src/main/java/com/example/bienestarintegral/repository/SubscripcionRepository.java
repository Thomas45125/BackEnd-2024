package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Subscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscripcionRepository extends MongoRepository<Subscripcion, String> {
}
