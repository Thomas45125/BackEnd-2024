package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Meta;
import com.example.bienestarintegral.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    // Obtener todas las metas
    @GetMapping
    public List<Meta> getAllMetas() {
        return metaService.getAllMetas();
    }

    // Obtener una meta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable String id) {
        Optional<Meta> meta = metaService.getMetaById(id);
        return meta.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva meta
    @PostMapping
    public Meta createMeta(@RequestBody Meta meta) {
        return metaService.createMeta(meta);
    }

    // Actualizar una meta existente
    @PutMapping("/{id}")
    public ResponseEntity<Meta> updateMeta(@PathVariable String id, @RequestBody Meta metaDetails) {
        Optional<Meta> updatedMeta = metaService.updateMeta(id, metaDetails);
        return updatedMeta.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una meta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable String id) {
        if (metaService.deleteMeta(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
