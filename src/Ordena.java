import java.util.Scanner;

public class Ordena {
    /*Realiza un programa que lea dos valores y los ordene ascendente o descendentemente
según elija el usuario. Restricción: No se puede resolver tod0 en el programa principal.*/

    public static void main(String[] args){
        //Trabajaremos con valores enteros
        int n1, n2;
        int orden;//Variable para controlar tipo de orden

        Scanner sc = new Scanner(System.in);

        //Pedimos los 2 numeros:
        System.out.println("Introduce el primer número: ");
        n1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        n2 = sc.nextInt();

        //Preguntamos al usuario cómo quiere ordenarlos:
        System.out.println("Orden ascendente (introduce un 0)\nOrden descendente (introduce un 1)");
        orden = sc.nextInt();

        ordena(n1, n2, orden);
    }

    //Función que ordena 2 números según orden
    static void ordena(int n1, int n2, int orden){
        int mayor = 0, menor = 0;
        if(n1 >= n2){
            mayor = n1;
            menor = n2;
        }
        //Faltaba el siguiente else en la entrega
        else{
            mayor = n2;
            menor = n1;
        }
        //Facepalm...

        //mostramos resultado
        if(orden == 0){//Si orden Ascendente
            System.out.println("Resultado: " + menor + ", " + mayor);
        }
        else{//Si orden descendente
            System.out.println("Resultado: " + mayor + ", " + menor);
        }
    }
}