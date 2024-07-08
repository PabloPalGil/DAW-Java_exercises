import java.io.Serializable;

public class Estudiante implements Serializable {
    public String nombre;
    public int edad;
    public int curso;

    Estudiante(String nombre, int edad, int curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    //método toString()
    @Override
    public String toString() {//Siempre utilizamos public para toString() overriding
        String s;
        s = "Nombre: " + nombre + ". Edad: " + edad + ". Curso: " + curso + ".\n";
        return s;
    }

    //método equals()
    @Override
    public boolean equals(Object otro) {
        Estudiante otroEst = (Estudiante)otro; //conversión de estrechamiento de Object a Estudiante
        boolean iguales;
        if(nombre.equals(otroEst.nombre) && (edad == otroEst.edad)){
            iguales = true;
        } else{
            iguales = false;
        }
        return iguales;
    }
}
