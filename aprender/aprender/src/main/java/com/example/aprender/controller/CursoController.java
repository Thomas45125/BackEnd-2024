package com.example.aprender.controller;

import com.example.aprender.model.Curso;
import com.example.aprender.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Crear un nuevo curso
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    // Obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerCursos() {
        List<Curso> cursos = cursoService.obtenerCursos();
        return ResponseEntity.ok(cursos);
    }

    // Obtener un curso por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> obtenerCursoPorId(@PathVariable String id) {
        Optional<Curso> curso = cursoService.obtenerCursoPorId(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable String id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizarCurso(id, curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable String id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
