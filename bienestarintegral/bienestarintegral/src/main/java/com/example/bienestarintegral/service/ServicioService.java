package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Servicio;
import com.example.bienestarintegral.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    // Obtener todos los servicios
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    // Obtener un servicio por su ID
    public Optional<Servicio> getServicioById(String id) {
        return servicioRepository.findById(id);
    }

    // Crear un nuevo servicio
    public Servicio createServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    // Actualizar un servicio existente
    public Optional<Servicio> updateServicio(String id, Servicio servicioDetails) {
        return servicioRepository.findById(id).map(servicio -> {
            servicio.setNombre(servicioDetails.getNombre());
            servicio.setDescripcion(servicioDetails.getDescripcion());
            servicio.setTipo(servicioDetails.getTipo());
            servicio.setActivo(servicioDetails.isActivo());
            servicio.setPrecio(servicioDetails.getPrecio());
            return servicioRepository.save(servicio);
        });
    }

    // Eliminar un servicio por su ID
    public boolean deleteServicio(String id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);
        if (servicio.isPresent()) {
            servicioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
