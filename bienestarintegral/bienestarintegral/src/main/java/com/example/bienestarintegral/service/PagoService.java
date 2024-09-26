package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Pago;
import com.example.bienestarintegral.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Obtener todos los pagos
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    // Obtener un pago por su ID
    public Optional<Pago> getPagoById(String id) {
        return pagoRepository.findById(id);
    }

    // Crear un nuevo pago
    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    // Actualizar un pago existente
    public Optional<Pago> updatePago(String id, Pago pagoDetails) {
        return pagoRepository.findById(id).map(pago -> {
            pago.setUsuarioId(pagoDetails.getUsuarioId());
            pago.setSubscripcionId(pagoDetails.getSubscripcionId());
            pago.setMonto(pagoDetails.getMonto());
            pago.setFechaPago(pagoDetails.getFechaPago());
            pago.setMetodoPago(pagoDetails.getMetodoPago());
            pago.setCompletado(pagoDetails.isCompletado());
            return pagoRepository.save(pago);
        });
    }

    // Eliminar un pago por su ID
    public boolean deletePago(String id) {
        Optional<Pago> pago = pagoRepository.findById(id);
        if (pago.isPresent()) {
            pagoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
