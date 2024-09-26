package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.instructor;
import com.example.bienestarintegral.repository.instructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class instructorService {

    @Autowired
    private instructorRepository instructorRepository;

    // Obtener todos los instructores
    public List<instructor> getAllInstructores() {
        return instructorRepository.findAll();
    }

    // Obtener un instructor por su ID
    public Optional<instructor> getInstructorById(String id) {
        return instructorRepository.findById(id);
    }

    // Crear un nuevo instructor
    public instructor createInstructor(instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Actualizar un instructor existente
    public Optional<instructor> updateInstructor(String id, instructor instructorDetails) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setNombre(instructorDetails.getNombre());
            instructor.setEspecialidad(instructorDetails.getEspecialidad());
            instructor.setEmail(instructorDetails.getEmail());
            instructor.setActivo(instructorDetails.isActivo());
            return instructorRepository.save(instructor);
        });
    }

    // Eliminar un instructor por su ID
    public boolean deleteInstructor(String id) {
        Optional<instructor> instructor = instructorRepository.findById(id);
        if (instructor.isPresent()) {
            instructorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
