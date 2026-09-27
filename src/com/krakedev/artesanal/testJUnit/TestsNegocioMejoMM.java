package com.krakedev.artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestsNegocioMejoMM {
	private NegocioMejorado negocio;

    @BeforeEach
    void setUp() {
        // Garantiza una instancia limpia antes de cada prueba
        negocio = new NegocioMejorado();
    }

    @Test
    @DisplayName("Debe agregar una máquina exitosamente y retornar true")
    void testAgregarMaquinaExitosa() {
        boolean resultado = negocio.agregarMaquina("IPA", "Cerveza artesanal amarga", 0.05);

        assertTrue(resultado, "El método debe retornar true cuando la máquina se agrega con éxito");
        assertEquals(1, negocio.getMaquinas().size(), "El tamaño de la lista debe ser 1");

        Maquina m = negocio.getMaquinas().get(0);
        assertNotNull(m.getCodigo(), "El código generado no debe ser null");
        assertTrue(m.getCodigo().startsWith("M-"), "El código debe empezar con el formato 'M-'");
    }

    @Test
    @DisplayName("Debe recuperar una máquina existente por su código")
    void testRecuperarMaquinaExistente() {
        negocio.agregarMaquina("Stout", "Cerveza negra", 0.06);

        // Obtenemos el código generado de la máquina agregada
        String codigoGenerado = negocio.getMaquinas().get(0).getCodigo();

        Maquina encontrada = negocio.recuperarMaquina(codigoGenerado);

        assertNotNull(encontrada, "Debe retornar un objeto Maquina");
        assertEquals(codigoGenerado, encontrada.getCodigo(), "Los códigos deben coincidir");
    }

    @Test
    @DisplayName("Debe retornar null al buscar una máquina con un código que no existe")
    void testRecuperarMaquinaInexistente() {
        negocio.agregarMaquina("Pilsner", "Cerveza rubia", 0.04);

        Maquina encontrada = negocio.recuperarMaquina("M-9999");

        assertNull(encontrada, "Debe retornar null si la máquina no existe en la lista");
    }

    @Test
    @DisplayName("Debe retornar false y no agregar si el código ya existe en la lista")
    void testAgregarMaquinaDuplicada() {
        // Agregamos una primera máquina
        negocio.agregarMaquina("Red Ale", "Cerveza roja", 0.05);
        String codigoExistente = negocio.getMaquinas().get(0).getCodigo();

        // Creamos una subclase anónima/sobrescritura para forzar la generación de un código duplicado en el test
        NegocioMejorado negocioConCodigoFijo = new NegocioMejorado() {
            @Override
            public String generarCodigo() {
                return codigoExistente;
            }
        };

        // Insertamos la primera máquina con el código fijo
        negocioConCodigoFijo.agregarMaquina("Red Ale", "Cerveza roja", 0.05);

        // Intentamos agregar otra máquina que generará el mismo código
        boolean resultadoDuplicado = negocioConCodigoFijo.agregarMaquina("Porter", "Cerveza negra", 0.05);

        assertFalse(resultadoDuplicado, "Debe retornar false al intentar agregar un código duplicado");
        assertEquals(1, negocioConCodigoFijo.getMaquinas().size(), "No debe aumentar el tamaño de la lista al haber duplicado");
    }

    @Test
    @DisplayName("Debe ejecutar cargarMaquinas en todas las máquinas de la lista")
    void testCargarMaquinas() {
        negocio.agregarMaquina("Porter", "Cerveza negra", 0.05);
        negocio.agregarMaquina("Wheat", "Cerveza de trigo", 0.04);

        // Verifica que la iteración por la lista se realice sin errores ni excepciones
        negocio.cargarMaquinas();

        assertEquals(2, negocio.getMaquinas().size(), "La lista debe mantener sus elementos tras cargar las máquinas");
    }

}
