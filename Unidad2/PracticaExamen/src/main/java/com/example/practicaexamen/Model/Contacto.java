package com.example.practicaexamen.Model;

public class Contacto {
    private String nombre;
    private String telefono;
    private String parentesco;

    public Contacto(String nombre, String telefono, String parentesco) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getParentesco() { return parentesco; }

    @Override
    public String toString() {
        return String.format("%-15s | %-10s | %s", nombre, telefono, parentesco);
    }


    public void setTelefono(String text) {
    }

    public void setParentesco(String value) {
    }
}
