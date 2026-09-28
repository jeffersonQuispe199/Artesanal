package com.krakedev.artesanal;

public class Cliente {
    private String codigo;
    private String cedula;
    private String nombre;
    private double totalConsumido;

    public Cliente() {
    }

    // Constructor: asegúrate de asignarlos al atributo correcto
    public Cliente(String codigo, String cedula, String nombre) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.totalConsumido = 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(double totalConsumido) {
        this.totalConsumido = totalConsumido;
    }
}