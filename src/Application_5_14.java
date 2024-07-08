import java.util.Scanner;
import java.util.Arrays;
public class Application_5_14 {
    /*El ayuntamiento de tu localidad te ha encargado una aplicación que ayude a realizar encuestas estadísticas
    para conocer el nivel adquisitivo de los habitantes del municipio. Para ello, tendrás que preguntar el sueldo
    a cada persona encuestada. No conoces el número de encuestados. Para finalizar la entrada de datos, introduce
    un sueldo con valor -1.

    Una vez terminada la entrada de datos, muestra la siguiente información:

    Todos los sueldos introducidos ordenados de forma decreciente
    El sueldo máximo y mínimo
    La media de los sueldos*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Se solicitarán los sueldos brutos anuales (número entero)
        int[] tSueldos = new int[0];//Inicializamos la tabla de sueldos vacía
        int i = 0;//i será el índice de nuestra tabla de sueldos
        int datoSueldo;//En esta variable guardaremos cada sueldo de forma temporal

        //Pedimos el primer sueldo (suponemos que se encuestará al menos a un habitante):
        System.out.println("Introduce el primer sueldo (euros brutos/año):");
        datoSueldo = sc.nextInt();//Guardamos el sueldo introducido

        //Como desconocemos el tamaño de la muestra, creamos un bucle while y vamos añadiendo sueldos hasta
        //que introduzcamos un -1:
        while(datoSueldo != -1){
            //Comprobamos que el sueldo es válido:
            if(datoSueldo < 0){
                System.out.println("Introduce un sueldo positivo:");
                datoSueldo = sc.nextInt();//Guardamos el sueldo introducido
                continue;
            }
            //Creamos una nueva tabla de sueldos con un tamaño +1 para almacenar el nuevo sueldo
            tSueldos = Arrays.copyOf(tSueldos, tSueldos.length + 1);
            //Almacenamos el nuevo sueldo en la última posición de tSueldos
            tSueldos[tSueldos.length - 1] = datoSueldo;
            System.out.println("Introduce un sueldo (-1 para salir):");
            datoSueldo = sc.nextInt();//Guardamos el sueldo introducido
        }
        //Una vez salimos del while, ordenamos la tabla para mostrar los resultados:
        Arrays.sort(tSueldos);

        //Mostramos los sueldos ordenados de forma decreciente:
        System.out.println("Listado de sueldos en orden decreciente:");
        //Dado que Arrays.sort() ordena de forma creciente, recorremos tSueldos del final al principio.
        //También creamos una nueva tabla para mostrar los resultados con Arrays.toString()
        int[] t = new int[tSueldos.length];
        int j = 0;
        for (i = tSueldos.length - 1; i >= 0; i--, j++){
            t[j] = tSueldos[i];//Llenamos la nueva tabla
            System.out.println(tSueldos[i]);//Vamos mostrando los sueldos línea a línea
        }
        //La nueva tabla t se ha creado simplemente para poder mostrar los sueldos con Arrays.toString()
        System.out.println(Arrays.toString(t));//Mostramos los contenidos de la tabla ordenada decrecientemente

        //El sueldo máximo y mínimo se corresponden con las posiciones última y primera en la tabla tSueldos:
        System.out.println("El sueldo máximo es: " + tSueldos[tSueldos.length - 1] + " €");
        System.out.println("El sueldo mínimo es: " + tSueldos[0] + " €");

        //Finalmente mostramos la media de los sueldos:
        System.out.println("La media de los sueldos es: " + mediaTablaNum(tSueldos) + "  €");
    }

    //Implementamos una pequeña función que devuleve la media de una tabla con valores numéricos:
    static double mediaTablaNum(int[] t){
        int sum = 0;
        //Calculamos el sumatorio de los valores de la tabla:
        for (int i = 0; i < t.length; i++){
            sum += t[i];
        }
        return ((double) sum/t.length);
    }
}
