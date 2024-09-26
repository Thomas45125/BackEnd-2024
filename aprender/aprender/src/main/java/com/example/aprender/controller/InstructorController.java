package com.example.aprender.controller;

import com.example.aprender.model.Instructor;
import com.example.aprender.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Crear un nuevo instructor
    @PostMapping
    public ResponseEntity<Instructor> crearInstructor(@RequestBody Instructor instructor) {
        Instructor nuevoInstructor = instructorService.crearInstructor(instructor);
        return ResponseEntity.ok(nuevoInstructor);
    }

    // Obtener todos los instructores
    @GetMapping
    public ResponseEntity<List<Instructor>> obtenerInstructores() {
        List<Instructor> instructores = instructorService.obtenerInstructores();
        return ResponseEntity.ok(instructores);
    }

    // Obtener un instructor por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Instructor>> obtenerInstructorPorId(@PathVariable String id) {
        Optional<Instructor> instructor = instructorService.obtenerInstructorPorId(id);
        if (instructor.isPresent()) {
            return ResponseEntity.ok(instructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un instructor
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable String id, @RequestBody Instructor instructor) {
        Instructor instructorActualizado = instructorService.actualizarInstructor(id, instructor);
        if (instructorActualizado != null) {
            return ResponseEntity.ok(instructorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstructor(@PathVariable String id) {
        instructorService.eliminarInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
