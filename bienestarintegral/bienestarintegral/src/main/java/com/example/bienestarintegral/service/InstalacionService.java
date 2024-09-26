package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Instalacion;
import com.example.bienestarintegral.repository.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstalacionService {

    @Autowired
    private InstalacionRepository instalacionRepository;

    // Obtener todas las instalaciones
    public List<Instalacion> getAllInstalaciones() {
        return instalacionRepository.findAll();
    }

    // Obtener una instalación por su ID
    public Optional<Instalacion> getInstalacionById(String id) {
        return instalacionRepository.findById(id);
    }

    // Crear una nueva instalación
    public Instalacion createInstalacion(Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    // Actualizar una instalación existente
    public Optional<Instalacion> updateInstalacion(String id, Instalacion instalacionDetails) {
        return instalacionRepository.findById(id).map(instalacion -> {
            instalacion.setNombre(instalacionDetails.getNombre());
            instalacion.setTipo(instalacionDetails.getTipo());
            instalacion.setCapacidad(instalacionDetails.getCapacidad());
            instalacion.setDisponible(instalacionDetails.isDisponible());
            return instalacionRepository.save(instalacion);
        });
    }

    // Eliminar una instalación por su ID
    public boolean deleteInstalacion(String id) {
        Optional<Instalacion> instalacion = instalacionRepository.findById(id);
        if (instalacion.isPresent()) {
            instalacionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
