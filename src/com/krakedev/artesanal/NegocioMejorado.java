package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas;
    
    // Punto 11: Se inicializa la lista para corregir el NullPointerException
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Constructor
    public NegocioMejorado() {
        this.maquinas = new ArrayList<>();
        // También puedes inicializarla aquí si lo prefieres:
        // this.clientes = new ArrayList<>();
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

    public String generarCodigo() {
        int numero = (int) (Math.random() * 100) + 1;
        return "M-" + numero;
    }

    public Maquina recuperarMaquina(String codigo) {
        for (Maquina m : this.maquinas) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();

        if (recuperarMaquina(codigo) != null) {
            return false;
        }

        Maquina nuevaMaquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
        this.maquinas.add(nuevaMaquina);
        return true;
    }

    public void cargarMaquinas() {
        for (int i = 0; i < this.maquinas.size(); i++) {
            Maquina m = this.maquinas.get(i);
            m.llenarMaquina();
        }
    }

    // ==========================================
    // PARTE 2: CLIENTES (CORREGIDO)
    // ==========================================

    private String ultimoCodigo() {
        int tamano = this.clientes.size() + 1;
        return "C-" + tamano;
    }

    // Al estar 'clientes' inicializado con 'new ArrayList<>()', .add() ya no dará error
    public void registrarCliente(String nombre, String cedula) {
        String codigo = ultimoCodigo();
        Cliente nuevoCliente = new Cliente(codigo, cedula, nombre);
        this.clientes.add(nuevoCliente);
    }
}