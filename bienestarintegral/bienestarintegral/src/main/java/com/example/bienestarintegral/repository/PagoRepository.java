package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoRepository extends MongoRepository<Pago, String> {
}
