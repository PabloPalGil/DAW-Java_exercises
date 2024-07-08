import java.util.Scanner;
public class Application_4_14 {
/*Escribe una función a la que se pase como parámetros de entrada una cantidad de días, horas y minutos
(que se pedirán en el programa principal). La función calculará y devolverá el número de segundos que
existen en los datos de entrada. El programa principal mostrará por pantalla los datos devueltos por la función*/

    //PROGRAMA PRINCIPAL:
    public static void main(String[] args){
        //Declaramos las variables:
        Scanner sc = new Scanner(System.in);
        int dias, horas, minutos, segundos;

        //Pedimos al usuario las horas, minutos y segundos:
        System.out.println("Introduce los días:");
        dias = sc.nextInt();
        //Comprobamos que dias es un numero positivo ó 0:
        if(dias < 0) {
            while(dias < 0){
                System.out.println("¡Introduce un número de días positivo!");
                dias = sc.nextInt();
            }
        }

        System.out.println("Introduce las horas:");
        horas = sc.nextInt();
        //Controlamos que las horas introducidas estén entre 0 y 23:
        if(horas > 23 || horas < 0){
            while(horas > 23 || horas < 0){
                System.out.println("¡Introduce un número de horas entre 0 y 23!");
                horas = sc.nextInt();
            }
        }

        System.out.println("Introduce los minutos:");
        minutos = sc.nextInt();
        //Controlamos que los minutos estén entre 0 y 59:
        if(minutos > 59 || minutos < 0){
            while(minutos > 59 || minutos < 0){
                System.out.println("¡Introduce un número de minutos entre 0 y 59!");
                minutos = sc.nextInt();
            }
        }

        //Mostramos el resultado:
        segundos = ConversionSegundos(dias, horas, minutos);
        System.out.println(dias + " días, " + horas + " horas y " + minutos + " min equivalen a\n" + segundos + " segundos");
    }

    //FUNCION:
    static int ConversionSegundos(int d, int h, int m){
        int s = (((d * 24 + h) * 60) + m) * 60;
        return(s);
    }
}
