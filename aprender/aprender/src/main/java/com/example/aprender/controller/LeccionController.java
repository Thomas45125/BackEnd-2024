package com.example.aprender.controller;

import com.example.aprender.model.Leccion;
import com.example.aprender.service.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecciones")
public class LeccionController {

    @Autowired
    private LeccionService leccionService;

    // Crear una nueva lección
    @PostMapping
    public ResponseEntity<Leccion> crearLeccion(@RequestBody Leccion leccion) {
        Leccion nuevaLeccion = leccionService.crearLeccion(leccion);
        return ResponseEntity.ok(nuevaLeccion);
    }

    // Obtener todas las lecciones
    @GetMapping
    public ResponseEntity<List<Leccion>> obtenerLecciones() {
        List<Leccion> lecciones = leccionService.obtenerLecciones();
        return ResponseEntity.ok(lecciones);
    }

    // Obtener una lección por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Leccion>> obtenerLeccionPorId(@PathVariable String id) {
        Optional<Leccion> leccion = leccionService.obtenerLeccionPorId(id);
        if (leccion.isPresent()) {
            return ResponseEntity.ok(leccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar una lección
    @PutMapping("/{id}")
    public ResponseEntity<Leccion> actualizarLeccion(@PathVariable String id, @RequestBody Leccion leccion) {
        Leccion leccionActualizada = leccionService.actualizarLeccion(id, leccion);
        if (leccionActualizada != null) {
            return ResponseEntity.ok(leccionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una lección
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLeccion(@PathVariable String id) {
        leccionService.eliminarLeccion(id);
        return ResponseEntity.noContent().build();
    }
}
