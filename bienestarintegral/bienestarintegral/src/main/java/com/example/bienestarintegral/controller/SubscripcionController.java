package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Subscripcion;
import com.example.bienestarintegral.service.SubscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscripciones")
public class SubscripcionController {

    @Autowired
    private SubscripcionService subscripcionService;

    // Obtener todas las subscripciones
    @GetMapping
    public List<Subscripcion> getAllSubscripciones() {
        return subscripcionService.getAllSubscripciones();
    }

    // Obtener una subscripción por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Subscripcion> getSubscripcionById(@PathVariable String id) {
        Optional<Subscripcion> subscripcion = subscripcionService.getSubscripcionById(id);
        return subscripcion.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva subscripción
    @PostMapping
    public Subscripcion createSubscripcion(@RequestBody Subscripcion subscripcion) {
        return subscripcionService.createSubscripcion(subscripcion);
    }

    // Actualizar una subscripción existente
    @PutMapping("/{id}")
    public ResponseEntity<Subscripcion> updateSubscripcion(@PathVariable String id, @RequestBody Subscripcion subscripcionDetails) {
        Optional<Subscripcion> updatedSubscripcion = subscripcionService.updateSubscripcion(id, subscripcionDetails);
        return updatedSubscripcion.map(ResponseEntity::ok)
                                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una subscripción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscripcion(@PathVariable String id) {
        if (subscripcionService.deleteSubscripcion(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
