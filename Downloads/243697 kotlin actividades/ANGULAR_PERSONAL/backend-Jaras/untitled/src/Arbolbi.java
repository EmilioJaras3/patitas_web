import java.util.Scanner;

public class Arbolbi {
    public static  void crearArbol (Nodo nodo){
        char r, resp;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿existe nodo por la izquierda:(1)si (2)No?");
        resp= (char) entrada.nextInt();

        if (resp==1){
            System.out.println("ingrese valor del nod");
            r= (char) entrada.nextInt();   
            Nodo subIzq=new Nodo (r);
            nodo.setIzq(subIzq);
            crearArbol(subIzq);
        }
        System.out.println("existe nodo por derecha :(1)Si (2)Noi");
        resp = (char) entrada.nextInt();
        if (resp==1){
            System.out.println("ingrese valor del nodo");
            r= (char) entrada.nextInt();
        }


        if (resp==1){
            System.out.println("ingrese valor del nod");
            r= (char) entrada.nextInt();
            Nodo subDer=new Nodo (r);
            nodo.setIzq(subDer);
            crearArbol(subDer);
        }
        System.out.println("existe nodo por derecha :(1)Si (2)Noi");
        resp = (char) entrada.nextInt();
        if (resp==1){
            System.out.println("ingrese valor del nodo");
            r= (char) entrada.nextInt();
        }
    }

    public static void eliminar (Nodo nodo){
        int r, resp;
        Scanner entrada = new Scanner(System.in);
    }
}

