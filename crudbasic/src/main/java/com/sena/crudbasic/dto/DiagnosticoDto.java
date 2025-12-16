package com.sena.crudbasic.dto;

public class DiagnosticoDto {

    private int id;
    private String descripcion;
    private int citaId; // Para relacionar con Cita

    public DiagnosticoDto() {
    }

    public DiagnosticoDto(int id, String descripcion, int citaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.citaId = citaId;
    }

    // Getters y Setters
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

    public int getCitaId() {
        return citaId;
    }

    public void setCitaId(int citaId) {
        this.citaId = citaId;
    }
}
