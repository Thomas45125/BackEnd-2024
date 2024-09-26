package com.example.aprender.controller;

import com.example.aprender.model.Modulo;
import com.example.aprender.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    // Crear un nuevo módulo
    @PostMapping
    public ResponseEntity<Modulo> crearModulo(@RequestBody Modulo modulo) {
        Modulo nuevoModulo = moduloService.crearModulo(modulo);
        return ResponseEntity.ok(nuevoModulo);
    }

    // Obtener todos los módulos
    @GetMapping
    public ResponseEntity<List<Modulo>> obtenerModulos() {
        List<Modulo> modulos = moduloService.obtenerModulos();
        return ResponseEntity.ok(modulos);
    }

    // Obtener un módulo por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Modulo>> obtenerModuloPorId(@PathVariable String id) {
        Optional<Modulo> modulo = moduloService.obtenerModuloPorId(id);
        if (modulo.isPresent()) {
            return ResponseEntity.ok(modulo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un módulo
    @PutMapping("/{id}")
    public ResponseEntity<Modulo> actualizarModulo(@PathVariable String id, @RequestBody Modulo modulo) {
        Modulo moduloActualizado = moduloService.actualizarModulo(id, modulo);
        if (moduloActualizado != null) {
            return ResponseEntity.ok(moduloActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un módulo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModulo(@PathVariable String id) {
        moduloService.eliminarModulo(id);
        return ResponseEntity.noContent().build();
    }
}
