import java.util.Scanner;

public class ArbolBinario {
    private Nodo raizActual;


    public ArbolBinario() {
        this.raizActual = null;
    }

    public void crearArbol() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Creando Nodo Raíz ");
        raizActual = crearNodoRecursivo(entrada);
    }

    private Nodo crearNodoRecursivo(Scanner entrada) {
        System.out.println("Matrícula del alumno:");
        int matricula = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Nombre del alumno:");
        String nombre = entrada.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(nombre, matricula);
        Nodo nuevoNodo = new Nodo(nuevoEstudiante);

        System.out.println("¿El nodo (" + nombre + ") tiene hijo izquierdo? 1=Sí, 2=No:");
        int respIzq = entrada.nextInt();
        if (respIzq == 1) {
            System.out.println("--- Creando Hijo Izquierdo de " + nombre + " ---");
            nuevoNodo.setIzq(crearNodoRecursivo(entrada));
        }

        System.out.println("¿El nodo (" + nombre + ") tiene hijo derecho? 1=Sí, 2=No:");
        int respDer = entrada.nextInt();
        if (respDer == 1) {
            System.out.println("--- Creando Hijo Derecho de " + nombre + " ---");
            nuevoNodo.setDer(crearNodoRecursivo(entrada));
        }

        return nuevoNodo;
    }


    public void recorrerPreorden() {
        if (raizActual == null) {
            System.out.println("El árbol está vacío.");
        } else {
            recorrerPreorden(raizActual);
        }
    }

    private void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println("Matrícula: " + nodo.getDato().getMatricula());
            recorrerPreorden(nodo.getIzq());
            recorrerPreorden(nodo.getDer());
        }
    }
}

