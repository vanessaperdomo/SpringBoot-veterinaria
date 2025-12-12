package com.sena.crudbasic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "mascota_servicio")
@IdClass(MascotaServicioId.class)
public class Mascota_Servicio {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Mascota_Servicio() {
    }

    public Mascota_Servicio(Mascota mascota, Servicio servicio) {
        this.mascota = mascota;
        this.servicio = servicio;
    }

    // Getters y Setters
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
