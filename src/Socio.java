import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Socio implements Comparable {
    int id; //número identificativo del socio
    String nombre;
    LocalDate fechaNacimiento;

    public Socio(int id, String nombre, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        //Establecemos el formato español para las fechas:
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, f);
    }

    int edad() {
        return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    /* Hacemos un cast a (int) porque ningún Socio humano vivirá tantos años como
    para necesitar una variable long. */

    @Override
    //La implementación debe declararse public
    public int compareTo(Object ob) {
        //Para ordenar naturalmente por nombre:
        return nombre.compareTo(((Socio)ob).nombre);
        //se invoca compareTo() de la clase String

        //Para ordenar naturalmente por id:
        // return id - ((Socio)ob).id;
    }

    public String toString() {
        return "Id: " + id + ". Nombre: " + nombre + ". Edad: " + edad() + ".\n";
    }//Saltamos de línea al final para facilitar la lectura en caso de pedir varios Socios.
}