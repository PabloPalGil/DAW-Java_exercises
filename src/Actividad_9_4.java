import java.util.Arrays;

public class Actividad_9_4 {
    /* Crea e inicializa una tabla de socios, ordénala por orden alfabético de
    nombres y múestrala por pantalla. Utiliza la interfaz Comparable

    Crea un programa que la utilice. Sube las clases y el programa. */

    public static void main(String[] args){
        //Creamos e inicializamos una tabla de Socios:
        Socio[] tabla = new Socio[]{
                new Socio(1, "Pablo", "05-01-1991"),
                new Socio(3, "Jaime", "05-08-1999"),
                new Socio(7, "Jessica", "07-02-1987"),
                new Socio(5, "Laia", "15-11-2001")
        };

        //Ordenamos alfabéticamente por nombres:
        Arrays.sort(tabla);

        //Mostramos la tabla de Socios ordenada:
        System.out.println(Arrays.deepToString(tabla));
    }
}
