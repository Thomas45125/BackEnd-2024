package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Reserva;
import com.example.bienestarintegral.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Obtener una reserva por su ID
    public Optional<Reserva> getReservaById(String id) {
        return reservaRepository.findById(id);
    }

    // Crear una nueva reserva
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Actualizar una reserva existente
    public Optional<Reserva> updateReserva(String id, Reserva reservaDetails) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setUsuarioId(reservaDetails.getUsuarioId());
            reserva.setServicioId(reservaDetails.getServicioId());
            reserva.setFechaReserva(reservaDetails.getFechaReserva());
            reserva.setConfirmada(reservaDetails.isConfirmada());
            return reservaRepository.save(reserva);
        });
    }

    // Eliminar una reserva por su ID
    public boolean deleteReserva(String id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            reservaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
