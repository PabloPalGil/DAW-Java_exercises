import java.util.Scanner;
import java.util.Arrays;
public class Application_9_13 {
    /* Diseñar la clase "Futbolista" con los siguiente atributos: Dni, Nombre, Edad y Número de goles
Implementar:

    Un constructor y los métodos toString() y equals() (este último basado en el DNI)
    La interfaz "Comparable" con un criterio de ordenación basado también en el DNI
    Un comparador para hacer ordenaciones basados en el nombre y otro basado en la edad

Crea un programa con una tabla con 5 futbolistas y múestra un menú para poder ordenarlos por DNI,
 por nombre y por edad */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        //Creamos e inicializamos una tabla de 5 Futbolistas:
        Futbolista[] tabla = new Futbolista[]{
                new Futbolista("20776554Z", "Cthulu", 33, 5),
                new Futbolista("19854732X", "Ronaldete", 37, 3),
                new Futbolista("21465587F", "Maikel", 25, 9),
                new Futbolista("22896541P", "Marcadona", 21, 13),
                new Futbolista("19255854J", "Pelao", 27, 4)
        };

        //Instanciamos los criterios de ordenación según nombre y edad:
        ComparaNombreFutbolista criterioNom = new ComparaNombreFutbolista();
        ComparaEdadFutbolista criterioEdad = new ComparaEdadFutbolista();

        do{
            System.out.println(Arrays.deepToString(tabla));//Mostramos la tabla

            //Mostramos el menú:
            System.out.println("\n\nElige una opción:\n" +
                    "Introduce \"1\" para ordenar por DNI.\n" +
                    "Introduce \"2\" para ordenar por nombre.\n" +
                    "Introduce \"3\" para ordenar por edad.\n" +
                    "Introduce \"-1\" para salir.\n");

            input = sc.next();

            switch (input){
                case "1":
                    System.out.println("Ordenados por DNI:\n");
                    Arrays.sort(tabla);//Orden natural por DNI (método compareTo() de Futbolista)
                    break;
                case "2":
                    System.out.println("Ordenados por Nombre:\n");
                    Arrays.sort(tabla, criterioNom);
                    break;
                case "3":
                    System.out.println("Ordenados por Edad:\n");
                    Arrays.sort(tabla, criterioEdad);
                    break;
                case "-1":
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Introduce una de las opciones del menú.\n");
                    break;
            }
        } while(!input.equals("-1"));
    }
}
