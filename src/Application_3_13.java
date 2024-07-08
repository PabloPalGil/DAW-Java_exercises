import java.util.Scanner;
public class Application_3_13 {
    /*Modificar la actividad resuelta 3.13 para que en lugar de pedir 6 notas, le pida al usuario que indique cuantas
    notas quiere introducir y una vez introducidas esas notas, muestre la cantidad de alumnos aprobados,condicionados
    y suspensos*/

    public static void main(String[] args){
        //Declaramos las variables necesarias:
        Scanner sc = new Scanner(System.in);
        int aprobados = 0, suspensos = 0, condicionados = 0;//Contadores
        int numNotas;//Cantidad de notas que se introducirán

        //Primero pedimos el numero de notas a introducir:
        System.out.println("¿Cuántas notas se van a introducir?");
        numNotas = sc.nextInt();

        //Como sabremos cuántas notas se van a introducir, usamos un bucle for
        for(int i = 1; i <= numNotas; i++){
            //Pedimos la nota i-ésima:
            System.out.println("Nota del alumno número " + i + " de " + numNotas);
            int nota = sc.nextInt();

            //Clasificamos al alumno según la nota:
            if(nota == 4)
                condicionados++;
            else if(nota < 4)
                suspensos++;
            else
                aprobados++;
        }

        //Mostramos los resultados:
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Condicionados: " + condicionados);
        System.out.println("Suspensos: " + suspensos);
    }
}
