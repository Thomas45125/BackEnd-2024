package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "modulos")
public class Modulo {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String cursoId;  // Relación con Curso (ID del curso al que pertenece)
    private List<String> lecciones;  // Lista de IDs de las lecciones pertenecientes al módulo

    // Constructor
    public Modulo() {}

    public Modulo(String titulo, String descripcion, String cursoId, List<String> lecciones) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cursoId = cursoId;
        this.lecciones = lecciones;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public List<String> getLecciones() {
        return lecciones;
    }

    public void setLecciones(List<String> lecciones) {
        this.lecciones = lecciones;
    }
}
