package com.example.bienestarintegral.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "pagos")
public class Pago {

    @Id
    private String id;
    private String usuarioId; // ID del usuario que realiza el pago
    private String subscripcionId; // ID de la subscripción a la que corresponde el pago
    private double monto; // Monto del pago
    private Date fechaPago; // Fecha en la que se realiza el pago
    private String metodoPago; // Método de pago utilizado (Tarjeta, PayPal, etc.)
    private boolean completado; // Estado del pago

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getSubscripcionId() {
        return subscripcionId;
    }

    public void setSubscripcionId(String subscripcionId) {
        this.subscripcionId = subscripcionId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
