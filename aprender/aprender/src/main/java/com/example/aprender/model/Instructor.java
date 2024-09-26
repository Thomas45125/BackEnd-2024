package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructores")
public class Instructor {

    @Id
    private String id;
    private String nombre;
    private String email;
    private String especialidad;  // Especialidad del instructor
    private int añosExperiencia;

    // Constructor
    public Instructor() {}

    public Instructor(String nombre, String email, String especialidad, int añosExperiencia) {
        this.nombre = nombre;
        this.email = email;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}
