package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
}

