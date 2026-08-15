package com.krakedev.artesanal;

public class Maquina {

	// Nuevo atributo agregado
	private String codigo;
	
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;

	// Constructor 1: Recibe el código como parámetro
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}

	// Constructor 2: Recibe el código como parámetro
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;
	}

	public double servirCerveza(double cantidad) {
		if (cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			double valor;
			valor = cantidad * precioPorMl;
			return valor;
		} else {
			return 0;
		}
	}

	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMaxima - 100;
		if (cantidadActual + cantidad <= limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 100;
	}

	public void imprimit() {
		String mensaje;
		mensaje = "código: " + codigo + " | nombre cerveza: " + nombreCerveza + " | descripcion: " + descripcion + " | precio por ml: " + precioPorMl
				+ " | cantidad maxima: " + capacidadMaxima + " | cantidad actual: " + cantidadActual;
		System.out.println(mensaje);
	}

	// Únicamente método Getter para código (Inmutable desde fuera)
	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}
}
