import java.util.Scanner;
public class Application_3_3 {
    /*Diseña un programa que pida al usuario un número positivo y lo muestre guarismo por guarismo. Por ejemplo,
     para el número 123, debe mostrar primero el 3, a continuación el 2 y por último el 1*/
    public static void main(String[] args){
        //Declaramos las variables necesarias:
        int input;//variable que almacena el numero del usuario
        Scanner sc = new Scanner(System.in);
        String inputText;//Almacenamos el número como cadena de texto

        //Pedimos el número de entrada (suponemos sólo números enteros):
        System.out.println("Introduce un número entero positivo:");
        input = sc.nextInt();

        //Convertimos el número int a String:
        //inputText = Integer.toString(input);//Alternativa
        inputText = String.valueOf(input);

        //Ahora recorremos la String del número en orden inverso y sacamos por pantalla cada cifra (char):
        for (int i = inputText.length(); i > 0; i--){
            char output = inputText.charAt(i - 1);//como el índice empieza en 0, restamos 1 a los caracteres de length()
            System.out.println(output);
        }
    }
}
