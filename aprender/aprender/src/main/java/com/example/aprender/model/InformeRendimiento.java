package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "informes_rendimiento")
public class InformeRendimiento {

    @Id
    private String id;
    private String estudianteId;  // ID del estudiante al que pertenece el informe
    private String cursoId;       // ID del curso
    private String evaluacionId;  // ID de la evaluación o módulo evaluado
    private Date fechaGeneracion; // Fecha en la que se generó el informe
    private String comentarios;   // Comentarios o recomendaciones
    private Double puntaje;       // Puntaje obtenido
    private String estado;        // Estado del estudiante (e.g., "Aprobado", "Reprobado")

    // Constructor vacío
    public InformeRendimiento() {}

    public InformeRendimiento(String estudianteId, String cursoId, String evaluacionId, Date fechaGeneracion, String comentarios, Double puntaje, String estado) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.evaluacionId = evaluacionId;
        this.fechaGeneracion = fechaGeneracion;
        this.comentarios = comentarios;
        this.puntaje = puntaje;
        this.estado = estado;
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

    public String getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(String evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
