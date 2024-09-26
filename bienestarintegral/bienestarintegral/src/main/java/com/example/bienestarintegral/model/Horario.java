package com.example.bienestarintegral.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "horarios")
public class Horario {

    @Id
    private String id;
    private String servicioId; // ID del servicio asociado al horario
    private String instalacionId; // ID de la instalación en la que se lleva a cabo el servicio
    private Date fechaInicio; // Fecha y hora de inicio del servicio
    private Date fechaFin; // Fecha y hora de finalización del servicio

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public String getInstalacionId() {
        return instalacionId;
    }

    public void setInstalacionId(String instalacionId) {
        this.instalacionId = instalacionId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
