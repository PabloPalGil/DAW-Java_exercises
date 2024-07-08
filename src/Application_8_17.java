public class Application_8_17 {
    /*
    Crea la clase Cola heredando de Lista (ver la Actividad de Aplicación 7.18). Escribe un programa que la utilice.
     */
    public static void main (String[] args){
        //Probamos la clase ColaHeredada (cuyo nombre sirve para diferenciarse de la clase Cola que no hereda de Lista,
        // del tema 7):
        ColaHeredada cola = new ColaHeredada();

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
        System.out.println("Encolamos un 200:");
        cola.encolar(200);

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
