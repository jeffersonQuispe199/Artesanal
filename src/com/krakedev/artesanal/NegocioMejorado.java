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
	 // 7. Método agregarMaquina modificado con retorno boolean y validación
		public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
			String codigo = generarCodigo();

			if (this.recuperarMaquina(codigo) != null) {
				return false;
			}

			Maquina nuevaMaquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
			this.maquinas.add(nuevaMaquina);
			return true;
		}
	 // Metodo cargarMaquina
		public void cargarMaquinas() {
			for (int i = 0; i < this.maquinas.size(); i++) {
				Maquina m = this.maquinas.get(i);
				m.llenarMaquina();
			}
		}
		// 6. Método recuperarMaquina
		public Maquina recuperarMaquina(String codigo) {
			for (Maquina m : this.maquinas) {
				
				if (m.getCodigo().equals(codigo)) {
					return m; 
				}
			}
			return null; 
		}
}
