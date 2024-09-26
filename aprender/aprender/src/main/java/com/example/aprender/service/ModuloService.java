package com.example.aprender.service;

import com.example.aprender.model.Modulo;
import com.example.aprender.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    // Crear un nuevo módulo
    public Modulo crearModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    // Obtener todos los módulos
    public List<Modulo> obtenerModulos() {
        return moduloRepository.findAll();
    }

    // Obtener un módulo por id
    public Optional<Modulo> obtenerModuloPorId(String id) {
        return moduloRepository.findById(id);
    }

    // Actualizar un módulo
    public Modulo actualizarModulo(String id, Modulo moduloActualizado) {
        return moduloRepository.findById(id).map(modulo -> {
            modulo.setTitulo(moduloActualizado.getTitulo());
            modulo.setDescripcion(moduloActualizado.getDescripcion());
            modulo.setCursoId(moduloActualizado.getCursoId());
            modulo.setLecciones(moduloActualizado.getLecciones());
            return moduloRepository.save(modulo);
        }).orElse(null);
    }

    // Eliminar un módulo
    public void eliminarModulo(String id) {
        moduloRepository.deleteById(id);
    }
}
