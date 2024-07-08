import java.io.Serializable;
public class Empleado implements Serializable{
    String dni;
    String nombre;
    double sueldo;

    public Empleado(String dni, String nombre, double sueldo){
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString(){
        return "Empleado{DNI: " + dni + ", Nombre: " + nombre + ", Sueldo: " + sueldo + " €}\n";
    }

    //método equals()
    @Override
    public boolean equals(Object otro) {
        Empleado otroEmp = (Empleado)otro; //conversión de estrechamiento de Object a Empleado
        boolean iguales;
        if(dni.equals(otroEmp.dni)){
            iguales = true;
        } else{
            iguales = false;
        }
        return iguales;
    }

    //Método sobrecargado de equals para buscar directamente por dni
    public boolean equals(String dniOtro) {
        boolean iguales;
        if(dni.equals(dniOtro)){
            iguales = true;
        } else{
            iguales = false;
        }
        return iguales;
    }
}
