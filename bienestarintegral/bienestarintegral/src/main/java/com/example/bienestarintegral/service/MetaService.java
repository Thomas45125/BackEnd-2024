package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.Meta;
import com.example.bienestarintegral.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    // Obtener todas las metas
    public List<Meta> getAllMetas() {
        return metaRepository.findAll();
    }

    // Obtener una meta por su ID
    public Optional<Meta> getMetaById(String id) {
        return metaRepository.findById(id);
    }

    // Crear una nueva meta
    public Meta createMeta(Meta meta) {
        return metaRepository.save(meta);
    }

    // Actualizar una meta existente
    public Optional<Meta> updateMeta(String id, Meta metaDetails) {
        return metaRepository.findById(id).map(meta -> {
            meta.setUsuarioId(metaDetails.getUsuarioId());
            meta.setDescripcion(metaDetails.getDescripcion());
            meta.setFechaInicio(metaDetails.getFechaInicio());
            meta.setFechaFin(metaDetails.getFechaFin());
            meta.setCompletada(metaDetails.isCompletada());
            return metaRepository.save(meta);
        });
    }

    // Eliminar una meta por su ID
    public boolean deleteMeta(String id) {
        Optional<Meta> meta = metaRepository.findById(id);
        if (meta.isPresent()) {
            metaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
