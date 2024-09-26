package com.example.aprender.controller;

import com.example.aprender.model.Estudiante;
import com.example.aprender.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    // Obtener todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    // Obtener un estudiante por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> obtenerEstudiantePorId(@PathVariable String id) {
        Optional<Estudiante> estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante.isPresent()) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
        if (estudianteActualizado != null) {
            return ResponseEntity.ok(estudianteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
