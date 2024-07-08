import java.util.Scanner;
public class Application_1_18 {
/*Un biólogo está realizando un estudio de distintas especies de invertebrados y necesita una aplicación que le
ayude a contabilizar el número de patas que tienen en total todos los animales capturados durante una jornada de
trabajo. Para ello, te ha solicitado que escribas una aplicación a la que hay que proporcionar:

    El número de hormigas capturadas ( 6 patas )
    El número de arañas capturadas ( 8 patas )
    El número de cochinillas capturadas ( 14 patas )

La aplicación debe mostrar el número total de patas.*/

    public static void main(String[] args){
        //Creamos las variables necesarias:
        int hormigas;
        int arañas;
        int cochinillas;
        int totalPatas;
        Scanner sc = new Scanner(System.in);//Variable Scanner

        //Solicitamos y almacenamos los distintos bichos:
        System.out.println("Introduce el número de hormigas capturadas:");
        //Esperamos el input del usuario:
        hormigas = sc.nextInt();
        System.out.println("Introduce el número de arañas capturadas:");
        arañas = sc.nextInt();
        System.out.println("Introduce el número de arañas capturadas:");
        cochinillas = sc.nextInt();

        //Calculamos el total de patas:
        totalPatas = hormigas * 6 + arañas * 8 + cochinillas * 14;

        //Devolvemos el importe del IVA y el importe total:
        System.out.println("El número total de patas es: " + totalPatas + ".");
    }
}
