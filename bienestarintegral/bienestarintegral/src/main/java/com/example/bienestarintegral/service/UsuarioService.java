package com.example.bienestarintegral.service;

import com.example.bienestarintegral.model.usuario;
import com.example.bienestarintegral.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por su ID
    public Optional<usuario> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    // Crear un nuevo usuario
    public usuario createUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public Optional<usuario> updateUsuario(String id, usuario usuarioDetails) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setPassword(usuarioDetails.getPassword());
            usuario.setSuscripcionActiva(usuarioDetails.isSuscripcionActiva());
            return usuarioRepository.save(usuario);
        });
    }

    // Eliminar un usuario por su ID
    public boolean deleteUsuario(String id) {
        Optional<usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
