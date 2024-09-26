package com.example.bienestarintegral.repository;

import com.example.bienestarintegral.model.Meta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaRepository extends MongoRepository<Meta, String> {
}
