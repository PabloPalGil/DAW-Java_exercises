import java.util.Scanner;
public class Ejercicio_3_12 {
    /*Modifica la actividad de aplicación 3.11 para que el usuario pueda introducir un numero binario y se muestre su
    conversión a decimal.*/
    public static void main(String[] args){
        String num;
        Scanner sc = new Scanner(System.in);
        int numDecimal = 0;
        int j = 0;

        System.out.println("Introduce un número binario para convertir a decimal:");
        num = sc.next();

        for(int i = num.length() - 1; i > 0; i--){
            numDecimal += (int) num.charAt(i) * (2 ^ j);
            j++;
        }
        System.out.println(num + " en decimal es: " + numDecimal);
    }
}
