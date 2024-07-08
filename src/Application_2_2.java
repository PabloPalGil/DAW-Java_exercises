import java.util.Scanner;
public class Application_2_2 {
/*Solicita por teclado un número de tipo int al usuario y escribe un programa que
muestre true o false, dependiendo de si el número es positivo.*/
    public static void main(String[] args){
        //Creamos las variables necesarias:
        int num;
        Scanner sc = new Scanner(System.in);//Variable Scanner

        //Solicitamos el número por teclado:
        System.out.println("Introduce un número entero:");
        num = sc.nextInt();

        //Comprobamos si el número es positivo (true) o no (false) y devolvemos el resultado:
        System.out.println(num >= 0);
        //Hemos asumido que el 0 es positivo (true), en su caso lo indicamos:
        if(num == 0){
            System.out.println("Asumimos que 0 es positivo.");
        }
    }
}