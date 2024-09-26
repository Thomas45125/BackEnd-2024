package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Subscripcion;
import com.example.bienestarintegral.repository.SubscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscripcionService {

    @Autowired
    private SubscripcionRepository subscripcionRepository;

    // Obtener todas las subscripciones
    public List<Subscripcion> getAllSubscripciones() {
        return subscripcionRepository.findAll();
    }

    // Obtener una subscripción por su ID
    public Optional<Subscripcion> getSubscripcionById(String id) {
        return subscripcionRepository.findById(id);
    }

    // Crear una nueva subscripción
    public Subscripcion createSubscripcion(Subscripcion subscripcion) {
        return subscripcionRepository.save(subscripcion);
    }

    // Actualizar una subscripción existente
    public Optional<Subscripcion> updateSubscripcion(String id, Subscripcion subscripcionDetails) {
        return subscripcionRepository.findById(id).map(subscripcion -> {
            subscripcion.setUsuarioId(subscripcionDetails.getUsuarioId());
            subscripcion.setPlan(subscripcionDetails.getPlan());
            subscripcion.setFechaInicio(subscripcionDetails.getFechaInicio());
            subscripcion.setFechaFin(subscripcionDetails.getFechaFin());
            subscripcion.setActiva(subscripcionDetails.isActiva());
            return subscripcionRepository.save(subscripcion);
        });
    }

    // Eliminar una subscripción por su ID
    public boolean deleteSubscripcion(String id) {
        Optional<Subscripcion> subscripcion = subscripcionRepository.findById(id);
        if (subscripcion.isPresent()) {
            subscripcionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
