import java.util.Scanner;
public class Aplication_1_11 {
    /*Un economista te ha encargado un programa para realizar cálculos con el IVA.
    La aplicación debe solicitar la base imponible y el IVA que se debe aplicar.
    Muestra por pantalla el importe correspondiente al IVA y al total.*/
    public static void main(String[] args){
        //Creamos las variables necesarias:
        float baseImp;
        int iva;
        float importeIva;
        float importeTotal;
        Scanner sc = new Scanner(System.in);//Variable Scanner

        //Solicitamos la base imponible:
        System.out.println("Introduce la base imponible:");
        //Esperamos el input del usuario:
        baseImp = sc.nextFloat();
        //Solicitamos el IVA aplicable:
        System.out.println("Introduce el iva aplicable (%):");
        //Esperamos el input del usuario:
        iva = sc.nextInt();
        //Calculamos los importes solicitados:
        importeIva = baseImp * (float)iva/100;
        importeTotal = baseImp * (1 + (float)iva/100);

        //Devolvemos el importe del IVA y el importe total:
        System.out.println("El importe correspondiente al IVA es: " + importeIva + "€");
        System.out.println("El importe total es " + importeTotal + "€");
    }
}
