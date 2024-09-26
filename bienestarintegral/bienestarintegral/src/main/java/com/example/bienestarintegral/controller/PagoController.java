package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.Pago;
import com.example.bienestarintegral.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Obtener todos los pagos
    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    // Obtener un pago por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable String id) {
        Optional<Pago> pago = pagoService.getPagoById(id);
        return pago.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo pago
    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoService.createPago(pago);
    }

    // Actualizar un pago existente
    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable String id, @RequestBody Pago pagoDetails) {
        Optional<Pago> updatedPago = pagoService.updatePago(id, pagoDetails);
        return updatedPago.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable String id) {
        if (pagoService.deletePago(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
