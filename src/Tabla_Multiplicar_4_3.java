import java.util.Scanner;
public class Tabla_Multiplicar_4_3 {
    /*Escribe una función que reciba un número como parámetro y muestre la tabla de multiplicar de ese número del 1 al
    10 pero solo de los números impares . El número que recibe como parámetro se pedirá en el programa principal.*/

    //Programa principal:
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;

        //Pedimos el numero al usuario (asumimos que se requiere un número entero):
        System.out.println("Escribe un número entero:");
        n = sc.nextInt();

        //Llamamos a la función que muestra la tabla de multiplicar impar del 1 al 10 de dicho numero:
        TablaMultImpar(n);
    }

    //Función que muestra tabla multiplicar:
    static void TablaMultImpar(int n){
        for(int i = 1; i <= 10; i += 2){
            System.out.println(n + "x" + i + " = " + i * n);
        }
    }
}