package com.krakedev.artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
public class MaquinaTest {
	// Tolerancia para las comparaciones entre valores double (delta)
    private static final double DELTA = 0.0001;

    private Maquina maquinaConstructor1;
    private Maquina maquinaConstructor2;

    @BeforeEach
    public void setUp() {
        // Uso del Constructor 1: Maquina(nombre, descripcion, precioPorMl, capacidadMaxima)
        // Capacidad Máxima explícita: 5000 ml
        maquinaConstructor1 = new Maquina("5455","Ipa Artesanal", "Cerveza amarga", 0.05, 5000.0);

        // Uso del Constructor 2: Maquina(nombre, descripcion, precioPorMl)
        // Capacidad Máxima por defecto: 10000 ml
        maquinaConstructor2 = new Maquina("56566","Stout Negra", "Cerveza oscura", 0.08);
    }

    @Test
    public void testServirCervezaConSuficienteStockConstructor1() {
        // VALIDACIÓN: Servir cerveza en una máquina creada con el Constructor 1.
        // Se llena la máquina para que tenga saldo/stock disponible.
        maquinaConstructor1.llenarMaquina(); // Carga la máquina con cerveza
        double stockInicial = maquinaConstructor1.getCantidadActual();
        double cantidadAServir = 500.0;
        double precioPorMl = maquinaConstructor1.getPrecioPorMl(); // 0.05
        double valorEsperado = cantidadAServir * precioPorMl; // 25.0

        double valorCobrado = maquinaConstructor1.servirCerveza(cantidadAServir);

        // Verifica que retorne el valor correcto a pagar
        assertEquals(valorEsperado, valorCobrado, DELTA, "El valor retornado a pagar no es correcto.");
        // Verifica que se haya restado la cerveza del stock disponible
        assertEquals(stockInicial - cantidadAServir, maquinaConstructor1.getCantidadActual(), DELTA, "La cantidad actual de cerveza no se redujo correctamente.");
    }

    @Test
    public void testServirCervezaConSuficienteStockConstructor2() {
        // VALIDACIÓN: Servir cerveza en una máquina creada con el Constructor 2.
        // Carga cerveza mediante recargarCerveza
        maquinaConstructor2.recargarCerveza(1000.0);
        double stockInicial = maquinaConstructor2.getCantidadActual();
        double cantidadAServir = 300.0;
        double valorEsperado = cantidadAServir * maquinaConstructor2.getPrecioPorMl(); // 300 * 0.08 = 24.0

        double valorCobrado = maquinaConstructor2.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorCobrado, DELTA, "El valor a pagar retornado debe ser la cantidad por el precio por ml.");
        assertEquals(stockInicial - cantidadAServir, maquinaConstructor2.getCantidadActual(), DELTA, "El stock disponible debió disminuir la cantidad servida.");
    }

    @Test
    public void testServirCervezaSinSuficienteStock() {
        // VALIDACIÓN: Intentar servir cerveza cuando la máquina no tiene suficiente cantidad.
        // La máquina recién instanciada inicia con cantidadActual = 0.
        double stockInicial = maquinaConstructor1.getCantidadActual();
        double cantidadAServir = 100.0; // Mayor a la cantidad actual (0)

        double valorCobrado = maquinaConstructor1.servirCerveza(cantidadAServir);

        // Debe retornar 0 cuando no hay suficiente cerveza
        assertEquals(0.0, valorCobrado, DELTA, "Debe retornar 0 si no hay suficiente cerveza disponible.");
        // El stock no debe modificarse
        assertEquals(stockInicial, maquinaConstructor1.getCantidadActual(), DELTA, "El stock no debe modificarse si no se sirvió cerveza.");
    }

    @Test
    public void testServirExactamenteTodaLaCervezaDisponible() {
        // VALIDACIÓN: Caso límite en el que se pide servir exactamente la cantidad disponible en la máquina.
        maquinaConstructor1.recargarCerveza(500.0);
        double cantidadAServir = maquinaConstructor1.getCantidadActual(); // Exactamente 500.0
        double valorEsperado = cantidadAServir * maquinaConstructor1.getPrecioPorMl();

        double valorCobrado = maquinaConstructor1.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorCobrado, DELTA, "Debe servir correctamente si la cantidad solicitada es igual a la disponible.");
        assertEquals(0.0, maquinaConstructor1.getCantidadActual(), DELTA, "La máquina debe quedar con 0 ml tras servir todo el stock.");
    }

    @Test
    public void testServirMasCervezaDeLaDisponibleTrasServicioPrevio() {
        // VALIDACIÓN: Servir cerveza una primera vez exitosamente y luego intentar pedir más de lo que queda.
        maquinaConstructor2.recargarCerveza(400.0);
        
        // Primer servicio exitoso
        maquinaConstructor2.servirCerveza(300.0);
        double stockRestante = maquinaConstructor2.getCantidadActual(); // Quedan 100 ml

        // Intentar servir 200 ml habiendo solo 100 ml
        double valorCobradoFrenado = maquinaConstructor2.servirCerveza(200.0);

        assertEquals(0.0, valorCobradoFrenado, DELTA, "Debe retornar 0 si la cantidad solicitada supera el stock restante.");
        assertEquals(stockRestante, maquinaConstructor2.getCantidadActual(), DELTA, "El stock no debe alterarse al fallar el intento de servir.");
    }
}

