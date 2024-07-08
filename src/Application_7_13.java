import java.util.Scanner;
import java.util.Arrays;
public class Application_7_13 {
    /*Actividad de aplicación 7.13:

En el momento de decorar una casa, una habitación o cualquier objeto, se plantea el problema de
elegir la paleta de colores que vamos a utilizar en nuestra decoración. Existe una solución, algo
atrevida, que consiste en utilizar colores al azar. Diseña la clase Colores, que alberga por defecto
 una serie de colores (mediante una cadena), aunque es posible añadir tantos como necesitemos. La
 clase tendrá un método que devuelve una tabla con los n colores que necesitemos elegidos al azar sin
 repeticiones.

Ademas de diseñar la clase tendrás que hacer el programa en java que la utilice para crearla, añadir
colores y mostrar los n colores solicitados por el decorador.
 */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        String[] colores;

        //Creamos un objeto Colores (por defecto tiene 8 colores)
        Colores c = new Colores();

        //Pedimos más colores de los disponibles para probar que la clase funciona bien:
        System.out.println("\nSolicitamos más colores de los disponibles:");
        colores = c.coloresAlAzar(9);

        //Añadimos más colores:
        System.out.println("\nA continuación vamos a añadir más colores:");
        c.añadirColor("marrón");
        c.añadirColor("morado turquesa");//Podemos añadir varios a la vez separando mediante espacios " ".

        //Solicitamos n colores:
        System.out.println("\n¿Cuántos colores distintos necesitas?");
        n = sc.nextInt();
        colores = c.coloresAlAzar(n);
        System.out.println("Los " + n + " colores obtenidos son:\n" + Arrays.toString(colores));
    }
}
