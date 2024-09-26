package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "progresos")
public class Progreso {

    @Id
    private String id;
    private String estudianteId; // Relación con el estudiante
    private String cursoId;      // Relación con el curso
    private String moduloId;     // Relación con el módulo específico dentro del curso
    private int porcentajeCompletado; // Porcentaje de avance en el curso o módulo

    // Constructor
    public Progreso() {}

    public Progreso(String estudianteId, String cursoId, String moduloId, int porcentajeCompletado) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.moduloId = moduloId;
        this.porcentajeCompletado = porcentajeCompletado;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getModuloId() {
        return moduloId;
    }

    public void setModuloId(String moduloId) {
        this.moduloId = moduloId;
    }

    public int getPorcentajeCompletado() {
        return porcentajeCompletado;
    }

    public void setPorcentajeCompletado(int porcentajeCompletado) {
        this.porcentajeCompletado = porcentajeCompletado;
    }
}

