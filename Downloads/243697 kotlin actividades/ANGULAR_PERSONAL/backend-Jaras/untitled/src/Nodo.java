public class Nodo {
    private char dato;
    private Nodo Izq;
    private Nodo Der;


    public Nodo(char dato) {
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

}

