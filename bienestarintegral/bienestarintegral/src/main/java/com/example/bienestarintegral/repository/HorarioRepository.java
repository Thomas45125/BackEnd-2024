package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, String> {
}
