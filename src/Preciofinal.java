import java.util.Scanner;
import java.util.Locale;
public class Preciofinal {
    /*Una tienda hace un descuento dependiendo del precio de cada producto. Si el precio es
inferior a 10 euros no hay descuento. Si es menor de 50 €, se aplica un 5% de descuento.
En otro caso, aplica un 20% de descuento.
Realiza un programa que introduzca n productos con su precio y calcule el precio final de la
compra (solo compramos una unidad de cada producto). También deberá mostrar el
descuento si se aplica, en el caso de que no haya descuento, mostrar un mensaje que lo
indique. Utiliza mínimo una función.*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n;//Número de productos a comprar

        //Solicitamos al usuario cuántos productos va a comprar:
        System.out.println("¿Cuántos productos compras?");
        n = sc.nextInt();
        //Inicializamos una tabla que almacenará n precios
        float[] precios = new float[n];

        //Introducimos los precios de cada producto:
        for (int i = 0; i < n; i++){
            System.out.println("Introduce el precio del producto nº " + (i + 1) + ":");
            precios[i] = sc.nextFloat();
        }

        //Llamamos a la funcion que calcula precios y aplica descuentos
        calculaPrecio(precios);
    }

    //Funcion que calcula el precio aplicando los descuentos
    static void calculaPrecio(float[] precios){
        float precioFinal = 0;
        //Calculamos precio final, indicando el descuento de cada producto en su caso:
        for(int i = 0; i < precios.length; i++){
            if(precios[i] < 10.0f){
                System.out.println("El producto nº " + (i + 1) + " vale " + precios[i] + " € y no tiene descuento.");
                precioFinal += precios[i];
            }
            else if(precios[i] < 50.0f){
                System.out.println("El producto nº " + (i + 1) + " vale " + precios[i] + " € y tiene un descuento del 5% (" +
                        + (precios[i] * 0.05f) + " €)\nSu precio se queda en: " + (precios[i] * 0.95f) + " €");
                precioFinal += precios[i] * 0.95f;
            }
            else{
                System.out.println("El producto nº " + (i + 1) + " vale " + precios[i] + " € y tiene un descuento del 20% (" +
                        + (precios[i] * 0.20f) + " €)\nSu precio se queda en: " + (precios[i] * 0.80f) + " €");
                precioFinal += precios[i] * 0.80f;
            }
        }

        //Mostramos el precio final:
        System.out.print("\nEl total de la compra asciende a " + precioFinal + " €");
    }
}
