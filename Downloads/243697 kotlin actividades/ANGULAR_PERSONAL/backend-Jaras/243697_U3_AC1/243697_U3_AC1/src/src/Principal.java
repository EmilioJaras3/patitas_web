package src;

import src.ArbolBinario;

import java.util.Scanner;

public class Principal {
    private ArbolBinario arbolB;

    public Principal() {
        this.arbolB = new ArbolBinario();
    }

    public static void main(String[] args) {
        Principal miApp = new Principal();
        miApp.visualizarMenuOperaciones(); // Llama al menú
    }

    public void visualizarMenuOperaciones() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("MENÚ ÁRBOL BINARIO DE ESTUDIANTES ");
            System.out.println("1. Crear árbol");
            System.out.println("2. Recorrer en Preorden (solo matrícula)");
            System.out.println("3. Recorrer en Inorden (datos completos)");
            System.out.println("4. Recorrer en Postorden (datos completos)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    arbolB.crearArbol();
                    break;
                case 2:
                    System.out.println("\n--- Recorrido Preorden ---");
                    arbolB.recorrerPreorden();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        entrada.close();
    }
}