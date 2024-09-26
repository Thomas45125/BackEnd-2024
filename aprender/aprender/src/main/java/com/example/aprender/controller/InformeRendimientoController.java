package com.example.aprender.controller;

import com.example.aprender.model.InformeRendimiento;
import com.example.aprender.service.InformeRendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informes")
public class InformeRendimientoController {

    @Autowired
    private InformeRendimientoService informeRendimientoService;

    // Crear un nuevo informe de rendimiento
    @PostMapping
    public ResponseEntity<InformeRendimiento> crearInforme(@RequestBody InformeRendimiento informe) {
        InformeRendimiento nuevoInforme = informeRendimientoService.crearInforme(informe);
        return ResponseEntity.ok(nuevoInforme);
    }

    // Obtener todos los informes
    @GetMapping
    public ResponseEntity<List<InformeRendimiento>> obtenerInformes() {
        List<InformeRendimiento> informes = informeRendimientoService.obtenerInformes();
        return ResponseEntity.ok(informes);
    }

    // Obtener un informe por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<InformeRendimiento>> obtenerInformePorId(@PathVariable String id) {
        Optional<InformeRendimiento> informe = informeRendimientoService.obtenerInformePorId(id);
        if (informe.isPresent()) {
            return ResponseEntity.ok(informe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un informe de rendimiento
    @PutMapping("/{id}")
    public ResponseEntity<InformeRendimiento> actualizarInforme(@PathVariable String id, @RequestBody InformeRendimiento informe) {
        InformeRendimiento informeActualizado = informeRendimientoService.actualizarInforme(id, informe);
        if (informeActualizado != null) {
            return ResponseEntity.ok(informeActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un informe de rendimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInforme(@PathVariable String id) {
        informeRendimientoService.eliminarInforme(id);
        return ResponseEntity.noContent().build();
    }
}
