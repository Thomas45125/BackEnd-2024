package com.example.bienestarintegral.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "usuarios")
public class usuario {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String password;
    private boolean suscripcionActiva;
    private List<Meta> metas;
    private List<Reserva> reservas;

    

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }

    public class Meta {
        private String descripcion;
        private boolean completada;
        private String fechaObjetivo;
        
        // Constructor vacío
        public Meta() {}
    
        // Constructor con parámetros
        public Meta(String descripcion, boolean completada, String fechaObjetivo) {
            this.descripcion = descripcion;
            this.completada = completada;
            this.fechaObjetivo = fechaObjetivo;
        }
    
        // Getters y Setters
        public String getDescripcion() {
            return descripcion;
        }
    
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    
        public boolean isCompletada() {
            return completada;
        }
    
        public void setCompletada(boolean completada) {
            this.completada = completada;
        }
    
        public String getFechaObjetivo() {
            return fechaObjetivo;
        }
    
        public void setFechaObjetivo(String fechaObjetivo) {
            this.fechaObjetivo = fechaObjetivo;
        }
    }

    public class Reserva {
        private String id;  // Identificador único de la reserva
        private String usuarioId;  // Referencia al usuario que realiza la reserva
        private String servicioId;  // Referencia al servicio o actividad reservada
        private LocalDateTime fechaHora;  // Fecha y hora de la reserva
        private boolean confirmada;  // Estado de confirmación de la reserva
    
        // Constructor vacío
        public Reserva() {}
    
        // Constructor con parámetros
        public Reserva(String id, String usuarioId, String servicioId, LocalDateTime fechaHora, boolean confirmada) {
            this.id = id;
            this.usuarioId = usuarioId;
            this.servicioId = servicioId;
            this.fechaHora = fechaHora;
            this.confirmada = confirmada;
        }
    
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
    
        public String getServicioId() {
            return servicioId;
        }
    
        public void setServicioId(String servicioId) {
            this.servicioId = servicioId;
        }
    
        public LocalDateTime getFechaHora() {
            return fechaHora;
        }
    
        public void setFechaHora(LocalDateTime fechaHora) {
            this.fechaHora = fechaHora;
        }
    
        public boolean isConfirmada() {
            return confirmada;
        }
    
        public void setConfirmada(boolean confirmada) {
            this.confirmada = confirmada;
        }
    }

}

