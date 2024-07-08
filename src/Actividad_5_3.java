import java.util.Scanner;
import java.util.Arrays;

public class Actividad_5_3 {
    /*Introduce por teclado un número n y a continuación solicita al usuario que introduzca n números.
    (Por ejemplo, si introduce el 5, luego se pedirán 5 números). Una vez introducidos los n números se
    mostrará la media de los números positivos, la media de los negativos y el número de ceros introducidos.
    Hay que utilizar arrays.*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;

        //Solicitamos un número al usuario:
        System.out.println("Introduce un número entero:");
        n = sc.nextInt();//Ahora ya sabemos cuántos números se deben introducir:

        //Creamos la variable tabla del tamaño indicado:
        int[] tabla = new int[n];
        //Definimos unas variables para contar los números positivos, negativos y ceros:
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        //Pedimos n números al usuario:
        System.out.println("Ahora introduce " + n + " números enteros:");
        for(int i = 0; i < tabla.length; i++){
            System.out.println("Nº" + (i + 1));//Mostramos la cuenta al usuario desde el 1, no el 0.
            tabla[i] = sc.nextInt();
            //Incrementamos el contador correspondiente según sea nº positivo, negativo ó 0:
            if(tabla[i] > 0){
                positivos++;
            }
            else if (tabla[i] < 0){
                negativos++;
            }
            else{
                ceros++;
            }
        }

        //Creamos variables para el cálculo de las medias
        double mediaPos = 0, mediaNeg = 0;

        for(int valor : tabla){//Recorremos cada elemento de tabla con for extendido/for-each porque no tenemos que modificarla
            if(valor > 0){
                mediaPos += valor;
            }
            else if(valor < 0){
                mediaNeg += valor;
            }
        }
        //Terminamos de calcular las medias y mostramos los resultados:
        if(positivos > 0)
            mediaPos /= positivos;
        if(negativos > 0)
            mediaNeg /= negativos;

        System.out.println("Media de números positivos: " + mediaPos + "\nMedia de números negativos:" + mediaNeg +
                "\nNúmero de ceros:" + ceros);
    }
}
