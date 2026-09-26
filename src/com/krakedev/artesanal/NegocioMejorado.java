package com.krakedev.artesanal;

import java.util.ArrayList;
import java.util.Random;

public class NegocioMejorado {

	   private ArrayList<Maquina> maquinas;

	    // Se inicializa al momento de crear el objeto NegocioMejorado
	    public NegocioMejorado() {
	        this.maquinas = new ArrayList<>();
	    }

	    public ArrayList<Maquina> getMaquinas() {
	        return maquinas;
	    }

	    public void setMaquinas(ArrayList<Maquina> maquinas) {
	        this.maquinas = maquinas;
	    }
	    
	    // Genera un código con el formato "M-X" o "M-XX" usando Math.random() del 1 al 100
	    public String generarCodigo() {
	        int numero = (int) (Math.random() * 100) + 1;
	        return "M-" + numero;
	    }
}
