//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       System.out.println("matricula del alumno ");
       matricula=entrada.nexInt();
       entrada.nextline();
       System.out.println("ingrese valor del alumno");
       nombre=entrada.next();
       Nodo Izq= new Nodo(new Persona (nombre,matricula));
        }
    }
}