package com.sena.crudbasic.models;

public class Dueno {

    private int idDueno;
    private String nombre;
    private String telefono;
    private String direccion;

    public Dueno() {
    }

    public Dueno(int idDueno, String nombre, String telefono, String direccion) {
        this.idDueno = idDueno;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
