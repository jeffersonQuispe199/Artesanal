package com.krakedev.artesanal.testJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {
	
	@Test
public void testLlenarMaquina() {
		Maquina rubia =new Maquina("5454","pilsener","cerveza",0.02,100);
	rubia.llenarMaquina();
	assertEquals(100,rubia.getCantidadActual(),0.001);
	
}
}
