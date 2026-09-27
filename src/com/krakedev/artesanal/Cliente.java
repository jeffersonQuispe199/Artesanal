package com.krakedev.artesanal;



public class Cliente {

	private String codigo;
	private String nombre;
	private String cedula;

	// Constructor por defecto
	public Cliente() {
	}

	// Constructor con parámetros
	public Cliente(String codigo, String nombre, String cedula) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cedula = cedula;
	}

	// Getters y Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public double getTotalConsumido() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTotalConsumido(double d) {
		// TODO Auto-generated method stub
		
	}
}