package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {
public static void main(String[] args) {
	Maquina rubia =new Maquina("2554","Pilsener","cerveza rubia",0.02,100000);
	rubia.imprimit();
	rubia.setNombreCerveza("clup");
	rubia.setDescripcion("cerbeza pasada");
	rubia.imprimit();
	
			
}
}
