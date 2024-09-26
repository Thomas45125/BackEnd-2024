package com.example.aprender.controller;

import com.example.aprender.model.Progreso;
import com.example.aprender.service.ProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/progresos")
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    // Crear un nuevo progreso
    @PostMapping
    public ResponseEntity<Progreso> crearProgreso(@RequestBody Progreso progreso) {
        Progreso nuevoProgreso = progresoService.crearProgreso(progreso);
        return ResponseEntity.ok(nuevoProgreso);
    }

    // Obtener todos los progresos
    @GetMapping
    public ResponseEntity<List<Progreso>> obtenerProgresos() {
        List<Progreso> progresos = progresoService.obtenerProgresos();
        return ResponseEntity.ok(progresos);
    }

    // Obtener un progreso por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Progreso>> obtenerProgresoPorId(@PathVariable String id) {
        Optional<Progreso> progreso = progresoService.obtenerProgresoPorId(id);
        if (progreso.isPresent()) {
            return ResponseEntity.ok(progreso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un progreso
    @PutMapping("/{id}")
    public ResponseEntity<Progreso> actualizarProgreso(@PathVariable String id, @RequestBody Progreso progreso) {
        Progreso progresoActualizado = progresoService.actualizarProgreso(id, progreso);
        if (progresoActualizado != null) {
            return ResponseEntity.ok(progresoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un progreso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProgreso(@PathVariable String id) {
        progresoService.eliminarProgreso(id);
        return ResponseEntity.noContent().build();
    }
}
