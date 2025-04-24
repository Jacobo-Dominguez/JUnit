package org.example.controlgasto;

import java.util.Scanner;


public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuario = null;

    public static void main(String[] args) {
        int opcion;

        do {
            Menu.mostrar();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce tu nombre de usuario: ");
                    String nombre = scanner.nextLine();
                    usuario = new Usuario(nombre);
                    System.out.println("Bienvenido/a, " + usuario.getNombre() + ". Puedes comenzar a gestionar tus finanzas.");
                    break;
                case 2:
                    if (verificarUsuario()) usuario.introducirIngreso(scanner);
                    break;
                case 3:
                    if (verificarUsuario()) usuario.introducirGasto(scanner);
                    break;
                case 4:
                    if (verificarUsuario()) usuario.mostrarSaldo();
                    break;
                case 5:
                    System.out.println("Programa finalizado. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static boolean verificarUsuario() {
        if (usuario == null) {
            System.out.println("Primero debes introducir el nombre de usuario (opción 1).\n");
            return false;
        }
        return true;
    }
}