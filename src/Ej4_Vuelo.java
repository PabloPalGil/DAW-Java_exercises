import java.util.Scanner;

public class Ej4_Vuelo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Creamos un avion Boeing 747 con capacidad para 414 pasajeros y depósito" +
                " para 2000 uds de combustible:\n");
        //Probamos la clase Avion:
        Avion avion = new Avion("Boeing 747", 416, 2000f);

        System.out.println(avion);

        System.out.println("\nIntentamos volar con el depósito vacío:\n");
        avion.volar();

        System.out.println("\nRepostamos:\n");
        avion.repostar();

        System.out.println("\nIntentamos repostar con el depósito lleno:\n");
        avion.repostar();

        System.out.println("\nVolamos:\n");
        avion.volar();

        System.out.println("\nDespués del vuelo:\n");
        System.out.println(avion);
    }
}
