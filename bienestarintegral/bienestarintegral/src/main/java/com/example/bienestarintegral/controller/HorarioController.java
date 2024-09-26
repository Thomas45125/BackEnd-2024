package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Horario;
import com.example.bienestarintegral.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    // Obtener todos los horarios
    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    // Obtener un horario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable String id) {
        Optional<Horario> horario = horarioService.getHorarioById(id);
        return horario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo horario
    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.createHorario(horario);
    }

    // Actualizar un horario existente
    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable String id, @RequestBody Horario horarioDetails) {
        Optional<Horario> updatedHorario = horarioService.updateHorario(id, horarioDetails);
        return updatedHorario.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un horario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable String id) {
        if (horarioService.deleteHorario(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
