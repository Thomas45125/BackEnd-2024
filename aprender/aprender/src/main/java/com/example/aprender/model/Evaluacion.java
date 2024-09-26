package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "evaluaciones")
public class Evaluacion {

    @Id
    private String id;
    private String titulo;
    private String cursoId; // Relación con el curso
    private List<Pregunta> preguntas; // Lista de preguntas de la evaluación
    private String estudianteId; // Relación con el estudiante que la toma

    // Constructor
    public Evaluacion() {}

    public Evaluacion(String titulo, String cursoId, List<Pregunta> preguntas, String estudianteId) {
        this.titulo = titulo;
        this.cursoId = cursoId;
        this.preguntas = preguntas;
        this.estudianteId = estudianteId;
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

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }
}