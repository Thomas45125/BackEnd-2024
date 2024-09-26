package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private String nombre;
    private String email;
    private String nivelConocimiento;  // Básico, Intermedio, Avanzado
    private String estiloAprendizaje;  // Visual, Auditivo, Kinestésico

    // Constructor
    public Estudiante() {}

    public Estudiante(String nombre, String email, String nivelConocimiento, String estiloAprendizaje) {
        this.nombre = nombre;
        this.email = email;
        this.nivelConocimiento = nivelConocimiento;
        this.estiloAprendizaje = estiloAprendizaje;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivelConocimiento() {
        return nivelConocimiento;
    }

    public void setNivelConocimiento(String nivelConocimiento) {
        this.nivelConocimiento = nivelConocimiento;
    }

    public String getEstiloAprendizaje() {
        return estiloAprendizaje;
    }

    public void setEstiloAprendizaje(String estiloAprendizaje) {
        this.estiloAprendizaje = estiloAprendizaje;
    }
}
