package com.example.aprender.controller;

import com.example.aprender.model.Comunicacion;
import com.example.aprender.service.ComunicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comunicaciones")
public class ComunicacionController {

    @Autowired
    private ComunicacionService comunicacionService;

    // Crear una nueva comunicación
    @PostMapping
    public ResponseEntity<Comunicacion> crearComunicacion(@RequestBody Comunicacion comunicacion) {
        Comunicacion nuevaComunicacion = comunicacionService.crearComunicacion(comunicacion);
        return ResponseEntity.ok(nuevaComunicacion);
    }

    // Obtener todas las comunicaciones
    @GetMapping
    public ResponseEntity<List<Comunicacion>> obtenerComunicaciones() {
        List<Comunicacion> comunicaciones = comunicacionService.obtenerComunicaciones();
        return ResponseEntity.ok(comunicaciones);
    }

    // Obtener una comunicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comunicacion>> obtenerComunicacionPorId(@PathVariable String id) {
        Optional<Comunicacion> comunicacion = comunicacionService.obtenerComunicacionPorId(id);
        if (comunicacion.isPresent()) {
            return ResponseEntity.ok(comunicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar una comunicación
    @PutMapping("/{id}")
    public ResponseEntity<Comunicacion> actualizarComunicacion(@PathVariable String id, @RequestBody Comunicacion comunicacion) {
        Comunicacion comunicacionActualizada = comunicacionService.actualizarComunicacion(id, comunicacion);
        if (comunicacionActualizada != null) {
            return ResponseEntity.ok(comunicacionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una comunicación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComunicacion(@PathVariable String id) {
        comunicacionService.eliminarComunicacion(id);
        return ResponseEntity.noContent().build();
    }
}
