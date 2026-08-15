package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {
public static void main(String[] args) {
	Maquina rubia=new Maquina("565","pilsener","cerveza fria",0.2,8000);
	System.out.println("------estado inicial----");
	rubia.imprimit();
	
	System.out.println("---------llenando maquina----------");
	rubia.llenarMaquina();
	rubia.imprimit();
	
	System.out.println("---------servir 1000 ML------");
	double valor;
	valor =rubia.servirCerveza(1000);
	System.out.println("valor a pagar"+ valor);
	
	System.out.println("---------servir 2000 ML------");

	valor =rubia.servirCerveza(2000);
	System.out.println("valor a pagar"+ valor);
	rubia.imprimit();
	System.out.println("---------servir 6000 ML------");

	valor =rubia.servirCerveza(6000);
	System.out.println("valor a pagar"+ valor);
	rubia.imprimit();
	
	
}
}
