import java.util.Scanner;
public class Application_7_15 {
    /*
    Diseña la clase Calendario que representa una fecha concreta (año,mes y día). La clase debe disponer de los métodos:

    Calendario(int año, int mes, int dia): crea un objeto con los datos pasados como parámetros, siempre y cuando,
     la fecha que representen sea correcta
    void incrementarDia(): incrementa en un día la fecha del calendario
    void incrementarMes(): incrementa en un mes la fecha del calendario
    void incrementarAño(): incrementa la fecha del calendario en el número de años especificados. Ten en cuenta que
    el año 0 no existió.
    void mostrar(): muestra la fecha por consola
    boolean iguales(Calendario otraFecha): determina si la fecha invocante y la que se pasa como parámetro son iguales
     o distintas

Por simplicidad, solo tendremos en consideración que existen meses con distintos número de días, pero no tendremos en
cuenta los años bisiestos

Además de la clase, crea un programa que cree la clase y ejecute los métodos para comprobar que la Clase es correcta.
     */

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int dia, mes, año;

        //Creamos un objeto calendario
        System.out.println("inicializamos una clase Calendario en el día 30/11/2023");
        Calendario cal1 = new Calendario(30, 11, 2023);

        cal1.mostrar();//Mostramos la fecha introducida

        //Incrementamos un mes:
        System.out.println("\nIncrementamos 1 mes");
        cal1.incrementarMes();
        cal1.mostrar();

        //Incrementamos un día
        System.out.println("\nIncrementamos 1 día");
        cal1.incrementarDia();
        cal1.mostrar();

        //Incrementamos un mes:
        System.out.println("\nIncrementamos 1 mes");
        cal1.incrementarMes();
        cal1.mostrar();

        //Incrementamos un mes:
        System.out.println("\nIncrementamos 1 mes");
        cal1.incrementarMes();
        cal1.mostrar();

        //Incrementamos un día
        System.out.println("\nIncrementamos 1 día");
        cal1.incrementarDia();
        cal1.mostrar();

        //Incrementamos 10 años:
        System.out.println("\nIncrementamos 10 años");
        cal1.incrementarAño(10);
        cal1.mostrar();

        //Creamos otra fecha:
        System.out.println("\nInicializamos otro objeto Calendario en el 12/02/-2");
        Calendario cal2 = new Calendario(12, 2, -2);

        System.out.println("\nIncrementamos 2 años");
        cal2.incrementarAño(2);
        cal2.mostrar();

        System.out.println("\nInicializamos otro objeto Calendario en el 12/02/1");
        Calendario cal3 = new Calendario(12, 2, 1);
        //Comparamos cal1 con cal2
        System.out.println("\nComparamos las dos primeras fechas:");
        System.out.println("cal1 es igual a cal2? " + cal1.iguales(cal2));

        //Comparamos cal2 con cal3
        System.out.println("\nComparamos las dos últimas fechas:");
        System.out.println("cal2 es igual a cal3? " + cal2.iguales(cal3));

        System.out.println("\nAhora crea tú otra fecha.\nIntroduce el día:");
        dia = sc.nextInt();
        System.out.println("\nIntroduce el mes:");
        mes = sc.nextInt();
        System.out.println("\nIntroduce el año:");
        año = sc.nextInt();
        Calendario cal4 = new Calendario(dia, mes, año);
        cal4.mostrar();
    }
}
