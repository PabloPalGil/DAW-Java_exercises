public class Application_7_18 {
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
    public static void main(String[] args){
        //Probamos la clase Cola:
        Cola cola = new Cola();

        //Probamos a sacar de una cola vacía:
        System.out.println("Probamos a desencolar de una cola vacía:");
        cola.desencolar();

        //Llenamos la cola del 1 al 7:
        System.out.println("Llenamos la cola con los números del 1 al 7:");
        for(int i = 1; i <= 7; i++){
            cola.encolar(i);
        }

        //Mostramos la cola:
        System.out.println("Mostramos la cola:");
        cola.muestraCola();

        //Encolamos uno:
        System.out.println("Encolamos un 100:");
        cola.encolar(100);

        //Mostramos el primero:
        System.out.println("Mostramos el primero de la cola:");
        cola.muestraPrimero();

        //Mostramos el último de la cola:
        System.out.println("Mostramos el último de la cola:");
        cola.muestraUltimo();

        //Sacamos uno de la cola:
        System.out.println("Desencolamos uno:");
        cola.desencolar();

        //Mostramos la cola:
        System.out.println("Mostramos la cola:");
        cola.muestraCola();
    }
}
