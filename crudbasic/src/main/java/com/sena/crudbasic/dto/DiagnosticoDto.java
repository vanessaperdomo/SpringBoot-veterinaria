package com.sena.crudbasic.dto;

import com.sena.crudbasic.Model.Cita;

public class DiagnosticoDto {

    private int id;
    private String descripcion;
    private Cita cita;

    public DiagnosticoDto(int id, String descripcion, Cita cita) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.cita = cita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
