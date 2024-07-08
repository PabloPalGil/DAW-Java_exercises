import java.util.Scanner;

public class Application_1_19 {
    /*Una empresa que gestiona un parque acuático te solicita una aplicación que les ayude a calcular el importe
    que hay que cobrar en la taquilla por la compra de una serie de entradas (cuyo número será introducido por el
    usuario). Existen dos tipos de entradas: infantiles, que cuestan 15.50 euros y de adultos que cuestan 20 euros.
    En el caso de que el importe total sea igual o superior a 100 euros, se aplicará automáticamente un bono descuento
    de 5 euros.*/
    public static void main(String[] args){
        //Creamos las variables necesarias:
        int infantiles;
        int adultos;
        int descuento;
        float importeTotal;
        Scanner sc = new Scanner(System.in);//Variable Scanner

        //Solicitamos las entradas infantiles:
        System.out.println("¿Cuántas entradas infantiles?");
        infantiles = sc.nextInt();
        //Solicitamos las entradas de adultos:
        System.out.println("¿Cuántas entradas para adultos?");
        adultos = sc.nextInt();
        //Calculamos el importe:
        importeTotal = infantiles * 15.50f + adultos * 20;

        //Comprobamos si el descuento aplica:
        descuento = importeTotal >= 100 ? 5 : 0;

        //Devolvemos el importe total:
        System.out.println("El importe total es " + (importeTotal - descuento) + "€");
    }
}
