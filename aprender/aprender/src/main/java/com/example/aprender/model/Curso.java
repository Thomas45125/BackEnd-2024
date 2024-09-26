package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "cursos")
public class Curso {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String nivel;  // Nivel del curso: básico, intermedio, avanzado
    private String instructorId;  // Relación con Instructor (ID del instructor)
    private List<String> modulos;  // Lista de IDs de los módulos pertenecientes al curso

    // Constructor
    public Curso() {}

    public Curso(String nombre, String descripcion, String nivel, String instructorId, List<String> modulos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.instructorId = instructorId;
        this.modulos = modulos;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public List<String> getModulos() {
        return modulos;
    }

    public void setModulos(List<String> modulos) {
        this.modulos = modulos;
    }
}
