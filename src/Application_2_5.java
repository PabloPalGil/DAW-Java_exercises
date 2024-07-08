import java.util.Scanner;
public class Application_2_5 {
    /*Escribe un programa que calcule el dinero recaudado en un concierto. La aplicación solicitará
    el aforo máximo del local, el precio por entrada (suponemos que todas las entradas tienen el mismo precio)
    y el número de entradas vendidas. Hay que tener en cuenta que si el número de entradas vendidas no supera
    el 20% del aforo del local, se cancela el concierto. Si el número de entradas vendidas no supera el 50%
    del aforo del local, se realiza una rebaja del 25% del precio de la entrada.*/
    public static void main(String[] args){
        //Definimos las variables necesarias:
        int aforoMax;
        double precioEntrada;
        int entradasVendidas;
        double aforo;
        double recaudacion;
        Scanner sc = new Scanner(System.in);

        //Pedimos y almacenamos los datos de entrada:
        System.out.println("Introduce el aforo total:");
        aforoMax = sc.nextInt();
        System.out.println("Introduce el importe de cada entrada:");
        precioEntrada = sc.nextDouble();
        System.out.println("¿Cuántas entradas se han vendido?");
        entradasVendidas = sc.nextInt();

        //Calculamos el aforo y la recaudación:
        aforo = entradasVendidas * 100.0d / aforoMax;
        recaudacion = entradasVendidas * precioEntrada;
        if(aforo < 20){
            System.out.println("Se cancela el concierto con un aforo del " + aforo + "% y " + recaudacion + " € " +
                    "recaudados hasta el momento. Se procederá a devolver a los clientes el importe íntegro de su entrada." +
                    "Recaudación final: 0 €.");
        }
        else if(aforo < 50){
            System.out.println("Con un aforo del " + aforo + "% se devolverá a los clientes un 25% del importe de su entrada." +
                    "Recaudación final: " + recaudacion * 0.75d + " €.");
        }
        else{
            System.out.println("Con un aforo del " + aforo + "% se han recaudado un total de: " + recaudacion + " €.");
        }
    }
}
