import java.util.Arrays;

public class ColaHeredada extends Lista{
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

    public ColaHeredada(){
        super();
    }

    //Método para meter un elemento en la cola (al final de la tabla)
    public void encolar(Integer elemento){
        insertarFinal(elemento);
        System.out.println("Entra en la cola: " + elemento);
    }

    //Método para sacar un elemento de la cola (el del principio de la tabla). Este método no se pide explícitamente
    //en el enunciado, pero vemos necesario añadirlo (no devuelve nada, el elemento que sale de la cola desaparece):
    public void desencolar(){
        if(tabla.length > 0){
            Integer eliminado = tabla[0];
            //Comprobamos que la cola tenga al menos un elemento
            eliminar(0);
            System.out.println("Sale de la cola: " + eliminado);
        }
        else{
            System.out.println("La cola está vacía, no se puede desencolar.");
        }
    }

    //Método que muestra el primer elemento de la cola
    public Integer muestraPrimero(){
        Integer primero = null;
        if(tabla.length > 0){
            primero = tabla[0];
            System.out.println("El primer miembro de la cola es: " + primero);
        }
        return primero;
    }

    //Método que devuelve el último elemento de la cola
    public Integer muestraUltimo(){
        Integer ultimo = null;
        if(tabla.length > 0){
            ultimo = tabla[tabla.length - 1];
            System.out.println("El último miembro de la cola es: " + ultimo);
        }
        return ultimo;
    }

    //Método que muestra toda la cola
    public void muestraCola(){
        System.out.println("Cola: " + Arrays.toString(tabla));
    }
}
