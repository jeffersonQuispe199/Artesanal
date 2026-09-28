package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas;
    private ArrayList<Cliente> clientes = new ArrayList<>(); // Punto 11: corregido

    // Constructor
    public NegocioMejorado() {
        this.maquinas = new ArrayList<>();
    }

    // Getters y Setters
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

    // ==========================================
    // PARTE 1: GESTIÓN DE MÁQUINAS
    // ==========================================

    // 3. Método generarCodigo
    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
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

    // 4 y 7. Método agregarMaquina con validación de duplicados
    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();

        if (recuperarMaquina(codigo) != null) {
            return false;
        }

        Maquina nuevaMaquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
        this.maquinas.add(nuevaMaquina);
        return true;
    }

    // 5. Método cargarMaquinas
    public void cargarMaquinas() {
        for (int i = 0; i < this.maquinas.size(); i++) {
            Maquina m = this.maquinas.get(i);
            m.llenarMaquina();
        }
    }

    // ==========================================
    // PARTE 2: CLIENTES
    // ==========================================

    private String ultimoCodigo() {
        int tamano = this.clientes.size() + 1;
        return "C-" + tamano;
    }

    // 9. Punto 9 según PDF: recibe nombre y cédula
    public void registrarCliente(String nombre, String cedula) {
        String codigo = ultimoCodigo();
        Cliente nuevoCliente = new Cliente(codigo, cedula, nombre);
        this.clientes.add(nuevoCliente);
    }

    // 13. Método buscarClientePorCedula
    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : this.clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    // 14. Método buscarClientePorCodigo
    public Cliente buscarClientePorCodigo(String codigo) {
        for (Cliente c : this.clientes) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    // ==========================================
    // PARTE 3: CONSUMO
    // ==========================================

    // 16. Método registrarConsumo en NegocioMejorado
    public void registrarConsumo(Cliente cliente, double valor) {
        double nuevoTotal = cliente.getTotalConsumido() + valor;
        cliente.setTotalConsumido(nuevoTotal);
    }

    // 15 y 17. Método consumirCerveza
    public void consumirCerveza(String codigoCliente, String codigoMaquina, int cantidad) {
        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);

        if (maquina != null && cliente != null) {
            double valorConsumido = maquina.servirCerveza(cantidad);
            registrarConsumo(cliente, valorConsumido); // Integración (Punto 17)
        }
    }

    // 19. Método consultarValorVendido
    public double consultarValorVendido() {
        double totalVendido = 0.0;
        for (Cliente c : this.clientes) {
            totalVendido += c.getTotalConsumido();
        }
        return totalVendido;
    }
}