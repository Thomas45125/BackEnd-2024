package com.example.aprender.service;

import com.example.aprender.model.Evaluacion;
import com.example.aprender.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    // Crear una nueva evaluación
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    // Obtener todas las evaluaciones
    public List<Evaluacion> obtenerEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    // Obtener una evaluación por id
    public Optional<Evaluacion> obtenerEvaluacionPorId(String id) {
        return evaluacionRepository.findById(id);
    }

    // Actualizar una evaluación
    public Evaluacion actualizarEvaluacion(String id, Evaluacion evaluacionActualizada) {
        return evaluacionRepository.findById(id).map(evaluacion -> {
            evaluacion.setTitulo(evaluacionActualizada.getTitulo());
            evaluacion.setCursoId(evaluacionActualizada.getCursoId());
            evaluacion.setPreguntas(evaluacionActualizada.getPreguntas());
            evaluacion.setEstudianteId(evaluacionActualizada.getEstudianteId());
            return evaluacionRepository.save(evaluacion);
        }).orElse(null);
    }

    // Eliminar una evaluación
    public void eliminarEvaluacion(String id) {
        evaluacionRepository.deleteById(id);
    }
}
    