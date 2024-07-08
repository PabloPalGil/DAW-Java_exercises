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
import java.util.Arrays;

public class Colores {
    //Por defecto, colores contendrá los colores primarios, secundarios, blanco y negro:
    String colores;

    Colores(){
        colores = "azul amarillo rojo verde naranja violeta blanco negro";
        System.out.println("Los colores disponibles por defecto son:\n" + colores);
    }

    //Método para añadir colores
    public void añadirColor(String color){
        //Comprobamos que el color a añadir no se encuentra ya en colores:
        if(!colores.contains(color)){
            colores = colores + " " + color;
        }
        System.out.println("Los colores disponibles son:\n" + colores);
    }

    //Método que devuelve n colores al azar
    public String[] coloresAlAzar(int n){
        //Creamos una tabla con los colores existentes:
        String[] colors = colores.split(" ");
        String[] coloresAleatorios = new String[n];//En esta tabla pondremos los colores a devolver

        //Comprobamos que tengamos colores suficientes:
        if(n > colors.length){
            System.out.println("Se han pedido más colores que los disponibles. ¡Añade más colores!");
            coloresAleatorios = null;//Ponemos a null para que no devuelva nada
        }
        else{//Si tenemos colores suficientes procedemos a seleccionarlos al azar:
            for(int i = 0; i < n; i++){
                //Elegimos un color de los disponibles (aleatoriamente, del 0 a colors.length - 1)
                int indice = (int) (Math.random() * colors.length);
                coloresAleatorios[i] = colors[indice];

                //Y eliminamos el color elegido aleatoriamente para que no vuelva a salir:
                colors[indice] = colors[colors.length - 1];
                colors = Arrays.copyOf(colors, colors.length - 1);
            }
        }
        //Devolvemos los colores escogidos
        return coloresAleatorios;
    }
}
