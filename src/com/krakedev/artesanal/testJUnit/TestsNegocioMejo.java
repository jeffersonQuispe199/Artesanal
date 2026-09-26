package com.krakedev.artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

import java.util.ArrayList;
public class TestsNegocioMejo {
	  private NegocioMejorado negocio;

	    @BeforeEach
	    public void setUp() {
	        negocio = new NegocioMejorado();
	    }

	    @Test
	    public void testInicializacionArrayList() {
	        // Verifica que la lista de máquinas no sea nula al inicializar la clase
	        assertNotNull(negocio.getMaquinas());
	        assertTrue(negocio.getMaquinas().isEmpty());
	    }

	    @Test
	    public void testGenerarCodigoFormato() {
	        String codigo = negocio.generarCodigo();
	        
	        // Verifica que el código empiece con "M-"
	        assertTrue(codigo.startsWith("M-"));
	    }

	    @Test
	    public void testGenerarCodigoRango() {
	        // Ejecuta la prueba varias veces para validar el rango aleatorio (1 al 100)
	        for (int i = 0; i < 500; i++) {
	            String codigo = negocio.generarCodigo();
	            String numeroStr = codigo.substring(2); // Extrae el número después de "M-"
	            int numero = Integer.parseInt(numeroStr);
	            
	            assertTrue(numero >= 1 && numero <= 100, "El número " + numero + " está fuera del rango 1-100");
	        }
	    }

	    @Test
	    public void testGettersSetters() {
	        ArrayList<Maquina> nuevaLista = new ArrayList<>();
	        negocio.setMaquinas(nuevaLista);
	        
	        // Verifica que el setter y getter funcionen correctamente
	        assertSame(nuevaLista, negocio.getMaquinas());
	    }
}
