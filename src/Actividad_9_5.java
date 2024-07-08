import java.util.Arrays;

public class Actividad_9_5 {
    /* Define una clase comparadora que ordene los socios por orden
    alfabético por nombres. Utiliza la interfaz Comparator.

    Crea un programa que la utilice. Sube las clases y el programa.
    */

    public static void main(String[] args){
        //Creamos e inicializamos una tabla de Socios:
        Socio[] tabla = new Socio[]{
                new Socio(1, "Pablo", "05-01-1991"),
                new Socio(3, "Jaime", "05-08-1999"),
                new Socio(7, "Jessica", "07-02-1987"),
                new Socio(5, "Laia", "15-11-2001")
        };

        //Instanciamos la clase comparadora por el criterio de ordenación solicitado
        ComparaNombreSocio criterioNombre = new ComparaNombreSocio();

        //Ordenamos la tabla utilizando sort() sobrecargado con nuestro criterio:
        Arrays.sort(tabla, criterioNombre);

        //Mostramos la tabla ordenada según nuestro criterio, por nombres alfabéticamente:
        System.out.println(Arrays.deepToString(tabla));
    }
}
