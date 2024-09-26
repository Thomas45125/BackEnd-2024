package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Recurso;
import com.example.bienestarintegral.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    // Obtener todos los recursos
    public List<Recurso> getAllRecursos() {
        return recursoRepository.findAll();
    }

    // Obtener un recurso por su ID
    public Optional<Recurso> getRecursoById(String id) {
        return recursoRepository.findById(id);
    }

    // Crear un nuevo recurso
    public Recurso createRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    // Actualizar un recurso existente
    public Optional<Recurso> updateRecurso(String id, Recurso recursoDetails) {
        return recursoRepository.findById(id).map(recurso -> {
            recurso.setNombre(recursoDetails.getNombre());
            recurso.setTipo(recursoDetails.getTipo());
            recurso.setDisponible(recursoDetails.isDisponible());
            return recursoRepository.save(recurso);
        });
    }

    // Eliminar un recurso por su ID
    public boolean deleteRecurso(String id) {
        Optional<Recurso> recurso = recursoRepository.findById(id);
        if (recurso.isPresent()) {
            recursoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
