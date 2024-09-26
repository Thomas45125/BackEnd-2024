package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Horario;
import com.example.bienestarintegral.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    // Obtener todos los horarios
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    // Obtener un horario por su ID
    public Optional<Horario> getHorarioById(String id) {
        return horarioRepository.findById(id);
    }

    // Crear un nuevo horario
    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    // Actualizar un horario existente
    public Optional<Horario> updateHorario(String id, Horario horarioDetails) {
        return horarioRepository.findById(id).map(horario -> {
            horario.setServicioId(horarioDetails.getServicioId());
            horario.setInstalacionId(horarioDetails.getInstalacionId());
            horario.setFechaInicio(horarioDetails.getFechaInicio());
            horario.setFechaFin(horarioDetails.getFechaFin());
            return horarioRepository.save(horario);
        });
    }

    // Eliminar un horario por su ID
    public boolean deleteHorario(String id) {
        Optional<Horario> horario = horarioRepository.findById(id);
        if (horario.isPresent()) {
            horarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
