package com.krakedev.artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestsNegocioMejorado3 {
	private NegocioMejorado negocio;

    @BeforeEach
    void setUp() {
        negocio = new NegocioMejorado();
        
        // 1. Registrar un cliente para las pruebas
        negocio.registrarCliente("Jefferson Quispe", "1723456789");
        
        // 2. Agregar una máquina con datos conocidos (ej: 0.05 por ML)
        negocio.agregarMaquina("IPA", "Cerveza artesanal", 0.05);
        
        // 3. Llenar la máquina para tener capacidad de servir
        negocio.cargarMaquinas();
    }

    @Test
    @DisplayName("Debe actualizar el consumo del cliente, afectar la capacidad de la máquina y calcular valores correctos")
    void testConsumirCervezaExitoso() {
        // Obtener códigos generados
        Cliente cliente = negocio.getClientes().get(0);
        Maquina maquina = negocio.getMaquinas().get(0);

        String codigoCliente = cliente.getCodigo();
        String codigoMaquina = maquina.getCodigo();
        
        int capacidadInicialMaquina = (int) maquina.getCantidadActual(); // Ejemplo: 5000 ML
        double consumoInicialCliente = cliente.getTotalConsumido(); // 0.0

        int cantidadAServir = 500; // 500 ML
        double precioEsperado = cantidadAServir * maquina.getPrecioPorMl(); // 500 * 0.05 = 25.0

        // Invocación del método a probar
        negocio.consumirCerveza(codigoCliente, codigoMaquina, cantidadAServir);

        // 1. Validar que la máquina fue afectada (su capacidad disminuyó)
        int capacidadEsperadaMaquina = capacidadInicialMaquina - cantidadAServir;
        assertEquals(capacidadEsperadaMaquina, maquina.getCantidadActual(), 
                "La capacidad de la máquina debió disminuir en " + cantidadAServir + " ML");

        // 2. Validar que el cliente fue actualizado y los valores son correctos
        double consumoEsperadoCliente = consumoInicialCliente + precioEsperado;
        assertEquals(consumoEsperadoCliente, cliente.getTotalConsumido(), 0.001, 
                "El total consumido del cliente debió actualizarse a " + consumoEsperadoCliente);
    }

    @Test
    @DisplayName("Debe acumular correctamente múltiples consumos en el mismo cliente")
    void testAcumularConsumosCliente() {
        Cliente cliente = negocio.getClientes().get(0);
        Maquina maquina = negocio.getMaquinas().get(0);

        String codigoCliente = cliente.getCodigo();
        String codigoMaquina = maquina.getCodigo();

        // Primer consumo: 200 ML * 0.05 = 10.0
        negocio.consumirCerveza(codigoCliente, codigoMaquina, 200);
        
        // Segundo consumo: 300 ML * 0.05 = 15.0
        negocio.consumirCerveza(codigoCliente, codigoMaquina, 300);

        // Total acumulado esperado = 10.0 + 15.0 = 25.0
        assertEquals(25.0, cliente.getTotalConsumido(), 0.001, 
                "El valor acumulado consumido por el cliente debe ser la suma de ambos consumos");
    }

    @Test
    @DisplayName("Debe buscar cliente por cédula y por código correctamente")
    void testBusquedasCliente() {
        Cliente cliente = negocio.getClientes().get(0);

        Cliente encontradoPorCedula = negocio.buscarClientePorCedula("1723456789");
        assertNotNull(encontradoPorCedula, "Debe retornar el cliente buscado por cédula");
        assertEquals(cliente.getCodigo(), encontradoPorCedula.getCodigo());

        Cliente encontradoPorCodigo = negocio.buscarClientePorCodigo(cliente.getCodigo());
        assertNotNull(encontradoPorCodigo, "Debe retornar el cliente buscado por código");
        assertEquals("1723456789", encontradoPorCodigo.getCedula());
    }

}
