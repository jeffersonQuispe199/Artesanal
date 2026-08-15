package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {
public static void main(String[] args) {
	
	
	boolean resultado;
	Maquina rubia =new Maquina("5454","Pilsener","cerveza rubia",0.02,8000);
	rubia.imprimit();
	System.out.println("----estado inicial-----");
	rubia.imprimit();
	System.out.println("------recargar1----");
	resultado =rubia.recargarCerveza(3000);
	System.out.println("se racarga corectamente"+ resultado);
	rubia.imprimit();
	
	System.out.println("------recargar2----");
	resultado =rubia.recargarCerveza(2000);
	System.out.println("se racarga corectamente"+ resultado);
	rubia.imprimit();
	
	System.out.println("------recargar3----");
	resultado =rubia.recargarCerveza(39000);
	System.out.println("se racarga corectamente"+ resultado);
	rubia.imprimit();
}
}
