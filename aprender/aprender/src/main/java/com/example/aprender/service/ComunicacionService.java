package com.example.aprender.service;

import com.example.aprender.model.Comunicacion;
import com.example.aprender.repository.ComunicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunicacionService {

    @Autowired
    private ComunicacionRepository comunicacionRepository;

    // Crear una nueva comunicación
    public Comunicacion crearComunicacion(Comunicacion comunicacion) {
        return comunicacionRepository.save(comunicacion);
    }

    // Obtener todas las comunicaciones
    public List<Comunicacion> obtenerComunicaciones() {
        return comunicacionRepository.findAll();
    }

    // Obtener una comunicación por ID
    public Optional<Comunicacion> obtenerComunicacionPorId(String id) {
        return comunicacionRepository.findById(id);
    }

    // Actualizar una comunicación
    public Comunicacion actualizarComunicacion(String id, Comunicacion comunicacionActualizada) {
        return comunicacionRepository.findById(id).map(comunicacion -> {
            comunicacion.setMensaje(comunicacionActualizada.getMensaje());
            comunicacion.setLeido(comunicacionActualizada.isLeido());
            return comunicacionRepository.save(comunicacion);
        }).orElse(null);
    }

    // Eliminar una comunicación
    public void eliminarComunicacion(String id) {
        comunicacionRepository.deleteById(id);
    }
}
    