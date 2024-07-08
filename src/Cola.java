import java.util.Arrays;
public class Cola {
    /*
    Una cola es una estructura dinámica como la pila, donde los elementos, en vez de apilarse y desapilarse,
    se encolan y desencolan. La diferencia con las pilas es que se desencola el primer elemento encolado, ya
    que así es como funcionan las colas del autobús o del cine. El primero que llega es el primero que sale de
     la cola (FIFO, first in, first out), suponemos que nadie se cuela...Por tanto, los elementos se encolan
     y desencolan en extremos opuestos de la estructura, llamados primero (el que está primero y será el próximo
     en abandonar la cola) y último (el que llegó último).
Implementa la clase Cola donde los elementos Integer encolados se guardan en una tabla.
Crea también el programa que cree la Cola y llene dicha cola. Muestre el primer y último elemento de la cola y
muestra toda la cola.
     */
    private Integer[] cola;//Tabla donde encolaremos los datos

    public Cola(){
        cola = new Integer[0];
    }

    //Método para meter un elemento en la cola (al final de la tabla)
    public void encolar(Integer elemento){
        //Creamos una tabla igual a la cola actual pero con una unidad más de tamaño
        cola = Arrays.copyOf(cola, cola.length + 1);
        //Asignamos en la última posición el elemento nuevo:
        cola[cola.length - 1] = elemento;
        System.out.println("Entra en la cola: " + elemento);
    }

    //Método para sacar un elemento de la cola (el del principio de la tabla). Este método no se pide explícitamente
    //en el enunciado, pero parece necesario añadirlo:
    public Integer desencolar(){
        Integer elemento = null;//En principio ponemos el resultado a null por si la cola está vacía
        if(cola.length > 0){
            //Si la cola tiene al menos un elemento, referenciamos el primer elemento de la tabla:
            elemento = cola[0];
            System.out.println("Sale de la cola: " + elemento);
            //Y desplazamos sus elementos a una posición anterior (si tiene más de 1 elemento)
            for(int i = 1; i < cola.length; i++){
                cola[i - 1] = cola[i];
            }
            //Actualizamos la cola con una de igual tamaño -1
            cola = Arrays.copyOf(cola, cola.length - 1);
        }
        else{
            System.out.println("La cola está vacía, no se puede desencolar.");
        }
        return elemento;
    }

    //Método que muestra el primer elemento de la cola
    public Integer muestraPrimero(){
        Integer primero = null;
        if(cola.length > 0){
            primero = cola[0];
            System.out.println("El primer miembro de la cola es: " + primero);
        }
        return primero;
    }

    //Método que devuelve el último elemento de la cola
    public Integer muestraUltimo(){
        Integer ultimo = null;
        if(cola.length > 0){
            ultimo = cola[cola.length - 1];
            System.out.println("El último miembro de la cola es: " + ultimo);
        }
        return ultimo;
    }

    //Método que muestra toda la cola
    public void muestraCola(){
        System.out.println("Cola: " + Arrays.toString(cola));
    }
}
