package com.example.aprender.service;

import com.example.aprender.model.Curso;
import com.example.aprender.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Crear un nuevo curso
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Obtener todos los cursos
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    // Obtener un curso por id
    public Optional<Curso> obtenerCursoPorId(String id) {
        return cursoRepository.findById(id);
    }

    // Actualizar un curso
    public Curso actualizarCurso(String id, Curso cursoActualizado) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(cursoActualizado.getNombre());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setNivel(cursoActualizado.getNivel());
            curso.setInstructorId(cursoActualizado.getInstructorId());
            curso.setModulos(cursoActualizado.getModulos());
            return cursoRepository.save(curso);
        }).orElse(null);
    }

    // Eliminar un curso
    public void eliminarCurso(String id) {
        cursoRepository.deleteById(id);
    }
}
