package com.example.aprender.service;

import com.example.aprender.model.InformeRendimiento;
import com.example.aprender.repository.InformeRendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformeRendimientoService {

    @Autowired
    private InformeRendimientoRepository informeRendimientoRepository;

    // Crear un nuevo informe de rendimiento
    public InformeRendimiento crearInforme(InformeRendimiento informe) {
        return informeRendimientoRepository.save(informe);
    }

    // Obtener todos los informes
    public List<InformeRendimiento> obtenerInformes() {
        return informeRendimientoRepository.findAll();
    }

    // Obtener un informe por ID
    public Optional<InformeRendimiento> obtenerInformePorId(String id) {
        return informeRendimientoRepository.findById(id);
    }

    // Actualizar un informe de rendimiento
    public InformeRendimiento actualizarInforme(String id, InformeRendimiento informeActualizado) {
        return informeRendimientoRepository.findById(id).map(informe -> {
            informe.setComentarios(informeActualizado.getComentarios());
            informe.setPuntaje(informeActualizado.getPuntaje());
            informe.setEstado(informeActualizado.getEstado());
            return informeRendimientoRepository.save(informe);
        }).orElse(null);
    }

    // Eliminar un informe de rendimiento
    public void eliminarInforme(String id) {
        informeRendimientoRepository.deleteById(id);
    }
}

