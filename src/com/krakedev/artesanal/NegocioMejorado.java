package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<>();
		// clientes se mantiene sin inicializar
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();

		if (this.recuperarMaquina(codigo) != null) {
			return false;
		}

		Maquina nuevaMaquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
		this.maquinas.add(nuevaMaquina);
		return true;
	}

	public void cargarMaquinas() {
		for (Maquina m : this.maquinas) {
			m.llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		for (Maquina m : this.maquinas) {
			if (m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;
	}

	public String ultimoCodigo() {
		int siguienteNumero = (this.clientes != null) ? this.clientes.size() + 1 : 1;
		return "C-" + siguienteNumero;
	}

	public void registrarCliente(String nombre, String cedula) {
		if (this.clientes == null) {
			this.clientes = new ArrayList<>();
		}

		String codigo = ultimoCodigo();
		Cliente nuevoCliente = new Cliente(codigo, nombre, cedula);
		this.clientes.add(nuevoCliente);
	}

	// 13. Método buscarClientePorCedula
	public Cliente buscarClientePorCedula(String cedula) {
		if (this.clientes != null) {
			for (int i = 0; i < this.clientes.size(); i++) {
				Cliente c = this.clientes.get(i);
				if (c.getCedula().equals(cedula)) {
					return c;
				}
			}
		}
		return null;
	}

	// 14. Método buscarClientePorCodigo
	public Cliente buscarClientePorCodigo(String codigo) {
		if (this.clientes != null) {
			for (int i = 0; i < this.clientes.size(); i++) {
				Cliente c = this.clientes.get(i);
				if (c.getCodigo().equals(codigo)) {
					return c;
				}
			}
		}
		return null;
	}

	// 16. Método registrarConsumo (Acumula el saldo consumido)
	public void registrarConsumo(Cliente cliente, double valorConsumido) {
		if (cliente != null) {
			double totalActual = cliente.getTotalConsumido();
			cliente.setTotalConsumido(totalActual + valorConsumido);
		}
	}

	// 15 y 17. Método consumirCerveza
	public void consumirCerveza(String codigoCliente, String codigoMaquina, int cantidad) {
		Maquina maquinaRecuperada = recuperarMaquina(codigoMaquina);
		Cliente clienteRecuperado = buscarClientePorCodigo(codigoCliente);

		if (maquinaRecuperada != null && clienteRecuperado != null) {
			double valorConsumido = maquinaRecuperada.servirCerveza(cantidad);
			registrarConsumo(clienteRecuperado, valorConsumido);
		}
	}
}