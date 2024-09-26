package com.example.aprender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "comunicaciones")
public class Comunicacion {

    @Id
    private String id;
    private String remitenteId;  // ID del remitente (puede ser un estudiante o un instructor)
    private String destinatarioId; // ID del destinatario
    private String mensaje;        // El contenido del mensaje
    private Date fechaEnvio;       // Fecha de envío del mensaje
    private boolean leido;         // Indicador de si el mensaje ha sido leído

    // Constructor
    public Comunicacion() {}

    public Comunicacion(String remitenteId, String destinatarioId, String mensaje, Date fechaEnvio, boolean leido) {
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(String remitenteId) {
        this.remitenteId = remitenteId;
    }

    public String getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(String destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
