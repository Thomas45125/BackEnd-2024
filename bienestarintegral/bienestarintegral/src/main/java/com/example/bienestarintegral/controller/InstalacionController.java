package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Instalacion;
import com.example.bienestarintegral.service.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionService instalacionService;

    // Obtener todas las instalaciones
    @GetMapping
    public List<Instalacion> getAllInstalaciones() {
        return instalacionService.getAllInstalaciones();
    }

    // Obtener una instalación por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> getInstalacionById(@PathVariable String id) {
        Optional<Instalacion> instalacion = instalacionService.getInstalacionById(id);
        return instalacion.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva instalación
    @PostMapping
    public Instalacion createInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionService.createInstalacion(instalacion);
    }

    // Actualizar una instalación existente
    @PutMapping("/{id}")
    public ResponseEntity<Instalacion> updateInstalacion(@PathVariable String id, @RequestBody Instalacion instalacionDetails) {
        Optional<Instalacion> updatedInstalacion = instalacionService.updateInstalacion(id, instalacionDetails);
        return updatedInstalacion.map(ResponseEntity::ok)
                                 .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una instalación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacion(@PathVariable String id) {
        if (instalacionService.deleteInstalacion(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
