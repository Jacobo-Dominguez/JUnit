package org.example.controlgasto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan");
    }

    @Test
    void getNombre() {
        assertEquals("Juan", usuario.getNombre());
    }

    @Test
    void introducirIngreso() {
        // Simulamos un ingreso de 500
        Scanner scanner = new Scanner("500\n");  // Entrada simulada
        usuario.introducirIngreso(scanner);
        usuario.mostrarSaldo();
        assertEquals(500.0, usuario.getSaldo(), 0.001);
    }

    @Test
    void introducirGasto() {
        // Primero, introducimos un ingreso para tener saldo
        Scanner scannerIngreso = new Scanner("1000\n");
        usuario.introducirIngreso(scannerIngreso);

        // Simulamos un gasto válido
        Scanner scannerGasto = new Scanner("1\n200\n");  // Gasto de 200 para "Vacaciones"
        usuario.introducirGasto(scannerGasto);
        assertEquals(800.0, usuario.getSaldo(), 0.001);

        // Intentamos un gasto mayor al saldo
        Scanner scannerGastoExceso = new Scanner("1\n900\n");  // Gasto de 900 para "Vacaciones"
        usuario.introducirGasto(scannerGastoExceso);
        assertEquals(800.0, usuario.getSaldo(), 0.001);  // El saldo no debe cambiar
    }

    @Test
    void mostrarSaldo() {
        // Comprobamos que el saldo inicial sea 0
        assertEquals(0.0, usuario.getSaldo(), 0.001);

        // Realizamos un ingreso de 1000
        Scanner scannerIngreso = new Scanner("1000\n");
        usuario.introducirIngreso(scannerIngreso);
        assertEquals(1000.0, usuario.getSaldo(), 0.001);

        // Realizamos un gasto de 500
        Scanner scannerGasto = new Scanner("2\n500\n");  // Gasto de 500 para "Alquiler"
        usuario.introducirGasto(scannerGasto);
        assertEquals(500.0, usuario.getSaldo(), 0.001);
    }
}
