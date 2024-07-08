import java.util.Scanner;
public class Application_3_14 {
    /*Modificar la actividad resuelta 3.14 para que solo muestre las tablas de multiplicar
     del 1 al 10 de los número pares*/
    public static void main(String[] args){
        //Si incrementamos de 2 en 2 desde el 2 sólo obtendremos los números pares del 1 al 10
        for(int tabla = 2; tabla <= 10; tabla += 2){
            System.out.println("\n\nTabla del " + tabla);
            //Por cada iteración del bucle exterior, el interior se ejecuta 10 veces
            for(int i = 1; i <= 10; i++){
                System.out.println(tabla + " x " + i + " = " + tabla * i);
            }
        }
    }
}