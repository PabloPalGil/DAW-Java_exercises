import java.util.Scanner;

public class Actividad_5_4 {
    /*Escribe una función llamada buscar: int buscar(int t[], int clave), que busque de forma secuencial en
     la tabla t el valor clave. En caso de encontralo, devuelve en qué posición lo encuentra y en caso contrario,
     devolverá -1, indicando que no lo encuentra. No se puede utilizar la función Arrays.binarySearch()*/


    //Función buscar:
    static int buscar(int[] t, int clave){
        int i = 0;//Controla el indice de la tabla t
        //El bucle while recorre la tabla:
        while (clave != t[i]){
            i++;
            if(i >= t.length){//Si i se sale del rango de la tabla, salimos del while
                i = -1;
                break;
            }
        }
        return i;
    }

    //Funcion main para probar el programa:
    public static void main(String[] args){
        //Para probar la función buscar, definimos una tabla de tamaño 100
        int[] tabla = new int[100];
        //Cuyos valores serán los números del 0 al 99, ordenadamente:
        for(int i = 0; i < tabla.length; i++){
            tabla[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        int clave;
        //Pedimos al usuario la clave, que será un entero del 0 al 99
        System.out.println("Introduce un número entero:");
        clave = sc.nextInt();
        //Finalmente llamamos a buscar, donde si se ha introducido un número del 0 al 99 nos devolverá su posición,
        //y si no, no lo encontrará y nos devolverá -1.
        System.out.println("El resultado es: " + buscar(tabla, clave));
    }
}
