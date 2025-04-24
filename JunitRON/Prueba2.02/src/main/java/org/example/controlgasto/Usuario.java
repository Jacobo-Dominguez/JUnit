package org.example.controlgasto;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private double saldo;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.saldo = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void introducirIngreso(Scanner scanner) {
        System.out.println(nombre + ", introduzca su ingreso (concepto: Nómina): ");
        System.out.print("Cantidad a ingresar: ");
        double ingreso = scanner.nextDouble();
        scanner.nextLine();

        if (ingreso > 0) {
            saldo += ingreso;
            System.out.println("Ingreso registrado: " + ingreso + "€. Nuevo saldo: " + saldo + "€");
        } else {
            System.out.println("Cantidad inválida. Debe ser mayor a 0.");
        }
    }

    public void introducirGasto(Scanner scanner) {
        System.out.println(nombre + ", seleccione el tipo de gasto:");
        System.out.println("1. Vacaciones\n2. Alquiler\n3. Vicios variados");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Cantidad del gasto: ");
        double gasto = scanner.nextDouble();
        scanner.nextLine();

        if (gasto <= 0) {
            System.out.println("El gasto debe ser mayor que 0.");
        } else if (gasto > saldo) {
            System.out.println("No tienes suficiente saldo para realizar este gasto.");
        } else {
            String concepto = switch (tipo) {
                case 1 -> "Vacaciones";
                case 2 -> "Alquiler";
                case 3 -> "Vicios variados";
                default -> "Desconocido";
            };
            saldo -= gasto;
            System.out.println(nombre + ", su gasto de " + concepto + " ha sido de " + gasto + "€. Saldo restante: " + saldo + "€");
        }
    }

    public void mostrarSaldo() {
        System.out.println(nombre + ", su saldo actual es: " + saldo + "€");
    }
}

