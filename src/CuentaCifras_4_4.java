import java.util.Scanner;
public class CuentaCifras_4_4 {
    /*Crea un programa que pida un número entero positivo  pedido por teclado (controlar que la entrada sea correcta)
     y se lo pase a una función que devuelva cuantas cifras tiene dicho número.*/

    //Programa principal:
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;

        //Pedimos el número al usuario:
        System.out.println("Introduce un número entero positivo:");
        n = sc.nextInt();
        while(n <= 0){
            System.out.println("El número debe ser entero positivo:");
            n = sc.nextInt();
        }

        //Llamamos a las funciones que cuentan las cifras de un número y mostramos el resultado:
        System.out.println(n + " tiene " + CuentaCifras(n) + " cifras (algoritmo por bucle).");
        System.out.println(n + " tiene " + CuentaCifrasRecursiva(n) + " cifras (algoritmo recursivo).");
    }

    //Función que cuenta cifras de un número mediante un bucle:
    static int CuentaCifras(int n){
        int res = 0;
        do{
            res++;
            n /= 10;
        } while(n >= 1);
        return(res);
    }

    //Función recursiva que cuenta cifras de un número:
    static int CuentaCifrasRecursiva(int n){
    int resultado;
        //Condición base:
        if(n < 1){
            resultado = 0;
        }
        else{
            //Llamada recursiva:
            resultado = 1 + CuentaCifrasRecursiva(n / 10);
        }
        return(resultado);
    }
}
