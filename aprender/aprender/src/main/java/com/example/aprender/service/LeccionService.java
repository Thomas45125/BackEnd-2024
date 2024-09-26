package com.example.aprender.service;

import com.example.aprender.model.Leccion;
import com.example.aprender.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeccionService {

    @Autowired
    private LeccionRepository leccionRepository;

    // Crear una nueva lección
    public Leccion crearLeccion(Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    // Obtener todas las lecciones
    public List<Leccion> obtenerLecciones() {
        return leccionRepository.findAll();
    }

    // Obtener una lección por id
    public Optional<Leccion> obtenerLeccionPorId(String id) {
        return leccionRepository.findById(id);
    }

    // Actualizar una lección
    public Leccion actualizarLeccion(String id, Leccion leccionActualizada) {
        return leccionRepository.findById(id).map(leccion -> {
            leccion.setTitulo(leccionActualizada.getTitulo());
            leccion.setContenido(leccionActualizada.getContenido());
            leccion.setModuloId(leccionActualizada.getModuloId());
            return leccionRepository.save(leccion);
        }).orElse(null);
    }

    // Eliminar una lección
    public void eliminarLeccion(String id) {
        leccionRepository.deleteById(id);
    }
}
