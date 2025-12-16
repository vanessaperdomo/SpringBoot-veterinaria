package com.sena.crudbasic.model;

import java.io.Serializable;
import java.util.Objects;

public class MascotaServicioId implements Serializable {

    private int mascota;
    private int servicio;

    public MascotaServicioId() {
    }

    public MascotaServicioId(int mascota, int servicio) {
        this.mascota = mascota;
        this.servicio = servicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MascotaServicioId))
            return false;
        MascotaServicioId that = (MascotaServicioId) o;
        return mascota == that.mascota && servicio == that.servicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mascota, servicio);
    }
}
