package com.krakedev.artesanal.testJUnit;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCliente {
	
	
		public static void main(String[] args) {
			NegocioMejorado negocio = new NegocioMejorado();

			System.out.println("--- Inicio del test ---");

			// Esta línea lanzará la excepción
			negocio.registrarCliente("Juan Pérez", "1712345678");

			System.out.println("--- Fin del test ---");
		}
}
