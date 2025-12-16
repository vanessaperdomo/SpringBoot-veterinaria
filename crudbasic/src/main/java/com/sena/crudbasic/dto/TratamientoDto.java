package com.sena.crudbasic.dto;

public class TratamientoDto {

    private int id;
    private String nombre;
    private int duracionDias;
    private int diagnosticoId; // Para relacionar con Diagnostico

    public TratamientoDto() {
    }

    public TratamientoDto(int id, String nombre, int duracionDias, int diagnosticoId) {
        this.id = id;
        this.nombre = nombre;
        this.duracionDias = duracionDias;
        this.diagnosticoId = diagnosticoId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getDiagnosticoId() {
        return diagnosticoId;
    }

    public void setDiagnosticoId(int diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }
}
