package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Recurso;
import com.example.bienestarintegral.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    // Obtener todos los recursos
    @GetMapping
    public List<Recurso> getAllRecursos() {
        return recursoService.getAllRecursos();
    }

    // Obtener un recurso por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable String id) {
        Optional<Recurso> recurso = recursoService.getRecursoById(id);
        return recurso.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo recurso
    @PostMapping
    public Recurso createRecurso(@RequestBody Recurso recurso) {
        return recursoService.createRecurso(recurso);
    }

    // Actualizar un recurso existente
    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable String id, @RequestBody Recurso recursoDetails) {
        Optional<Recurso> updatedRecurso = recursoService.updateRecurso(id, recursoDetails);
        return updatedRecurso.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un recurso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable String id) {
        if (recursoService.deleteRecurso(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
