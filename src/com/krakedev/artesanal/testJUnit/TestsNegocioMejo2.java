package com.krakedev.artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;
public class TestsNegocioMejo2 {
	private NegocioMejorado negocio;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada test para garantizar un estado limpio
        negocio = new NegocioMejorado();
    }

    @Test
    @DisplayName("Debe agregar correctamente una máquina a la lista")
    void testAgregarMaquina() {
        assertEquals(0, negocio.getMaquinas().size(), "La lista debería iniciar vacía");

        negocio.agregarMaquina("IPA", "Cerveza artesanal amarga", 0.05);

        assertEquals(1, negocio.getMaquinas().size(), "La lista debería contener 1 máquina");
        Maquina m = negocio.getMaquinas().get(0);
        
        assertNotNull(m.getCodigo(), "El código generado no debe ser nulo");
        assertTrue(m.getCodigo().startsWith("M-"), "El código debe iniciar con M-");
    }

    @Test
    @DisplayName("Debe recuperar una máquina existente por su código")
    void testRecuperarMaquinaExitosa() {
        negocio.agregarMaquina("Stout", "Cerveza negra", 0.06);
        
        // Obtenemos el código generado automáticamente
        String codigoGenerado = negocio.getMaquinas().get(0).getCodigo();

        Maquina encontrada = negocio.recuperarMaquina(codigoGenerado);

        assertNotNull(encontrada, "Debe retornar el objeto Maquina");
        assertEquals(codigoGenerado, encontrada.getCodigo(), "Los códigos deben coincidir");
    }

    @Test
    @DisplayName("Debe retornar null al buscar un código inexistente")
    void testRecuperarMaquinaNoExistente() {
        negocio.agregarMaquina("Pilsner", "Cerveza rubia", 0.04);

        Maquina encontrada = negocio.recuperarMaquina("CODIGO_INEXISTENTE");

        assertNull(encontrada, "Debe retornar null cuando el código no existe");
    }

    @Test
    @DisplayName("Debe ejecutar cargarMaquinas sin lanzar excepciones")
    void testCargarMaquinas() {
        negocio.agregarMaquina("Red Ale", "Cerveza roja", 0.05);
        negocio.agregarMaquina("Porter", "Cerveza tostada", 0.05);

        // Verifica que el recorrido del bucle no genere errores
        negocio.cargarMaquinas();
        assertEquals(2, negocio.getMaquinas().size());
    }

}
