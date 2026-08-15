package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {
public static void main(String[] args) {
	Maquina rubia=new Maquina("545","pilsener","cerveza fria",0.2,8000);
	
	
	rubia.imprimit();
	
	rubia.llenarMaquina();
	rubia.imprimit();
	Maquina negra =new Maquina("5445","pony","cebeza buena",0.36);
	negra.imprimit();
	negra.llenarMaquina();
	negra.imprimit();
}

}
