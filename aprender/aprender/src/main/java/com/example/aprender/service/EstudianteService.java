package com.example.aprender.service;

import com.example.aprender.model.Estudiante;
import com.example.aprender.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Crear un nuevo estudiante
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Obtener todos los estudiantes
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Obtener un estudiante por id
    public Optional<Estudiante> obtenerEstudiantePorId(String id) {
        return estudianteRepository.findById(id);
    }

    // Actualizar un estudiante
    public Estudiante actualizarEstudiante(String id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setEmail(estudianteActualizado.getEmail());
            estudiante.setNivelConocimiento(estudianteActualizado.getNivelConocimiento());
            estudiante.setEstiloAprendizaje(estudianteActualizado.getEstiloAprendizaje());
            return estudianteRepository.save(estudiante);
        }).orElse(null);
    }

    // Eliminar un estudiante
    public void eliminarEstudiante(String id) {
        estudianteRepository.deleteById(id);
    }
}
