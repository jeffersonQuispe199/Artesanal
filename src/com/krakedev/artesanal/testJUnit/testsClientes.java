package com.krakedev.artesanal.testJUnit;

import com.krakedev.artesanal.NegocioMejorado;

public class testsClientes {

    public static void main(String[] args) {
        // Instanciamos el negocio
        NegocioMejorado negocio = new NegocioMejorado();

        // Al llamar a registrarCliente, intentará hacer clientes.add(...)
        // Como 'clientes' no fue instanciado con 'new ArrayList<>()', lanzará NullPointerException
        negocio.registrarCliente("Jefferson Quispe", "1723456789");
    }
}