package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lecciones")
public class Leccion {

    @Id
    private String id;
    private String titulo;
    private String contenido;
    private String moduloId; // Relación con el módulo al que pertenece

    // Constructor
    public Leccion() {}

    public Leccion(String titulo, String contenido, String moduloId) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.moduloId = moduloId;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getModuloId() {
        return moduloId;
    }

    public void setModuloId(String moduloId) {
        this.moduloId = moduloId;
    }
}
