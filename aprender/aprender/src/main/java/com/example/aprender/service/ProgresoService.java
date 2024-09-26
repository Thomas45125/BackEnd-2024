package com.example.aprender.service;

import com.example.aprender.model.Progreso;
import com.example.aprender.repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    // Crear un nuevo progreso
    public Progreso crearProgreso(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    // Obtener todos los progresos
    public List<Progreso> obtenerProgresos() {
        return progresoRepository.findAll();
    }

    // Obtener progreso por id
    public Optional<Progreso> obtenerProgresoPorId(String id) {
        return progresoRepository.findById(id);
    }

    // Actualizar un progreso
    public Progreso actualizarProgreso(String id, Progreso progresoActualizado) {
        return progresoRepository.findById(id).map(progreso -> {
            progreso.setCursoId(progresoActualizado.getCursoId());
            progreso.setModuloId(progresoActualizado.getModuloId());
            progreso.setPorcentajeCompletado(progresoActualizado.getPorcentajeCompletado());
            return progresoRepository.save(progreso);
        }).orElse(null);
    }

    // Eliminar un progreso
    public void eliminarProgreso(String id) {
        progresoRepository.deleteById(id);
    }
}
