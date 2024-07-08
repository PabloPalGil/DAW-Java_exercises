import java.util.Scanner;
import java.util.Locale;
public class Application_3_20 {
/*Escribe un programa que solicite al usuario las distintas cantidades de dinero de las que dispone.
Por ejemplo: la cantidad de dinero que tiene en el banco, en una caja fuerte, en un cajón y en los bolsillos...
La aplicación mostrará la suma total de dinero de la que dispone el usuario.
La manera de especificar que no se desea introducir más cantidades es mediante el cero.*/

    public static void main(String[] args){
        //Declaramos las variables:
        double ahorros = 0;//Dinero acumulado de todas las fuentes de ahorro
        double dinero;//Cantidad de dinero en una fuente de ahorro dada
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);//Utilizamos punto para los decimales, en lugar de coma

        //Dado que vamos a solicitar al usuario de 1 a infinitas cantidades de dinero, usamos un do-while
        do{
            //Pedimos al usuario que introduzca una cantidad de dinero:
            System.out.println("Introduce una cantidad de dinero:");
            dinero = sc.nextDouble();
            ahorros += dinero;
        } while (dinero != 0);//Seguimos iterando mientras no se haya introducido un 0

        //Finalmente mostramos el sumatorio de los ahorros:
        System.out.println("La suma total disponible asciende a: " + ahorros + " €");
    }
}
