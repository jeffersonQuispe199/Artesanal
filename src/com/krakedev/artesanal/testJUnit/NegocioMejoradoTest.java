package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class NegocioMejoradoTest {

    @Test
    public void testBuscarClientePorCedula() {
        NegocioMejorado negocio = new NegocioMejorado();
        // registrarCliente recibe (nombre, cedula) según el Punto 9
        negocio.registrarCliente("Jefferson", "1723456789");

        Cliente c = negocio.buscarClientePorCedula("1723456789");
        assertNotNull(c);
        assertEquals("Jefferson", c.getNombre());
    }

    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.registrarCliente("Jefferson", "1723456789");

        // Obtenemos el cliente registrado buscando por su cédula para asegurarnos de que no sea null
        Cliente c = negocio.buscarClientePorCedula("1723456789");
        assertNotNull(c);

        negocio.registrarConsumo(c, 15.50);
        negocio.registrarConsumo(c, 4.50);

        assertEquals(20.00, negocio.consultarValorVendido(), 0.01);
    }
}