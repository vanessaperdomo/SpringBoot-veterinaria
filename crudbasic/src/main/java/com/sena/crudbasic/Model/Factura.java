package com.sena.crudbasic.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    public Factura() {
    }

    public Factura(int id, LocalDate fecha, double total, Dueno dueno) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.dueno = dueno;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
