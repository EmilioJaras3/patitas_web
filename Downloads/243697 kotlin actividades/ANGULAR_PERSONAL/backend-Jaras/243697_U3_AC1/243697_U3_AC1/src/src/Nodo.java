package src;

public class Nodo {
    private Estudiante dato;
    private Nodo Izq;
    private Nodo Der;

    public Estudiante getDato(){
         return dato;
  }
    public Nodo(Estudiante dato) {
        this.dato = dato;
    }


    public Nodo getIzq() {
        return Izq;
    }
    public void setIzq(Nodo nodo) {
        Izq = nodo ;
    }
    public Nodo getDer() {
        return Der;
    }
    public void setDer(Nodo nodo) {
        Der = nodo;
    }
    public void imprimirDatos (){
        System.out.println (this.getDato());
    }

}

