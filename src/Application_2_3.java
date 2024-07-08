import java.util.Scanner;
public class Application_2_3 {
    /*Escribe un programa que pida al usuario dos números enteros y muestre: true, si ambos número
    son distintos entre sí o alguno de ellos es cero; y false en caso contrario.*/

    public static void main(String[] args){
        //Definimos las variables necesarias:
        int num1, num2;
        Scanner sc = new Scanner(System.in);

        //Pedimos los números:
        System.out.println("Introduce el primer número entero:");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo número entero:");
        num2 = sc.nextInt();

        //Comparamos los números y devolvemos el resultado:
        System.out.println(num1 == 0 || num1 != num2);
    }
}