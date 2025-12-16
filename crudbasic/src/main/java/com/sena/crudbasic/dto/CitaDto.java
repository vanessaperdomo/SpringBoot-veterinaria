package com.sena.crudbasic.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDto {

    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private int mascotaId; // Para relacionar con Mascota
    private int veterinarioId; // Para relacionar con Veterinario

    public CitaDto() {
    }

    public CitaDto(int id, LocalDate fecha, LocalTime hora, String motivo, int mascotaId, int veterinarioId) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public int getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(int veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
}
