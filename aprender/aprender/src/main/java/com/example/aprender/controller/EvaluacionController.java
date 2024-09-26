package com.example.aprender.controller;

import com.example.aprender.model.Evaluacion;
import com.example.aprender.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    // Crear una nueva evaluación
    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        Evaluacion nuevaEvaluacion = evaluacionService.crearEvaluacion(evaluacion);
        return ResponseEntity.ok(nuevaEvaluacion);
    }

    // Obtener todas las evaluaciones
    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerEvaluaciones() {
        List<Evaluacion> evaluaciones = evaluacionService.obtenerEvaluaciones();
        return ResponseEntity.ok(evaluaciones);
    }

    // Obtener una evaluación por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evaluacion>> obtenerEvaluacionPorId(@PathVariable String id) {
        Optional<Evaluacion> evaluacion = evaluacionService.obtenerEvaluacionPorId(id);
        if (evaluacion.isPresent()) {
            return ResponseEntity.ok(evaluacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar una evaluación
    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@PathVariable String id, @RequestBody Evaluacion evaluacion) {
        Evaluacion evaluacionActualizada = evaluacionService.actualizarEvaluacion(id, evaluacion);
        if (evaluacionActualizada != null) {
            return ResponseEntity.ok(evaluacionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una evaluación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable String id) {
        evaluacionService.eliminarEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}
