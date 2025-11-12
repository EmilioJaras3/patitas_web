public class Estudiante {
    private String matricula;
    private String nombre;

    public Estudiante(String matricula, String nombre){
     this.matricula = matricula;
             this.nombre = nombre;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "matricula=" + matricula + ", nombre=" + nombre;
    }
}


