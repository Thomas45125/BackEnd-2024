package com.example.aprender.service;

import com.example.aprender.model.Instructor;
import com.example.aprender.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    // Crear un nuevo instructor
    public Instructor crearInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Obtener todos los instructores
    public List<Instructor> obtenerInstructores() {
        return instructorRepository.findAll();
    }

    // Obtener un instructor por id
    public Optional<Instructor> obtenerInstructorPorId(String id) {
        return instructorRepository.findById(id);
    }

    // Actualizar un instructor
    public Instructor actualizarInstructor(String id, Instructor instructorActualizado) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setNombre(instructorActualizado.getNombre());
            instructor.setEmail(instructorActualizado.getEmail());
            instructor.setEspecialidad(instructorActualizado.getEspecialidad());
            instructor.setAñosExperiencia(instructorActualizado.getAñosExperiencia());
            return instructorRepository.save(instructor);
        }).orElse(null);
    }

    // Eliminar un instructor
    public void eliminarInstructor(String id) {
        instructorRepository.deleteById(id);
    }
}
