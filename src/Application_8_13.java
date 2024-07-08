import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;


public class Application_8_13 {
    /*
La empresa de mensajería BiciExpress, que reparte en bicicleta, para disminuir el peso que transportan sus empleados
solo utiliza cajas de cartón. El volumen de estas se calcula como el 80% del volumen real, con el fin de evitar que
se deformen y se rompan. Otra característica de las cajas de cartón es que sus medidas siempre están en centímetros.
Por último, la empresa para controlar costes, necesita saber cuál es la superficie total de cartón utilizado para
construir todas las cajas.

    Escribe la clase "CajaCarton" heredando de la clase "Caja" (que deberás crear del ejercicio 8.12) y el programa
    para probarlas.

Ayuda:

    La clase "CajaCarton":
        Utilizará el constructor de "Caja"
        Redefinirá el método getVolumen() de la superclase para ajustar  el volumen al 80%
        Redefinirá el método toString() para indicar el cartón total
 */
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        //Creamos una CajaCarton
        System.out.println("Creamos una caja de cartón de 100 cm de lado");
        CajaCarton cajaCarton = new CajaCarton(100, 100, 100);

        //Sacamos el volumen
        System.out.println("El volumen de la caja de cartón es: " + cajaCarton.getVolumen() + " m3");

        //Definimos la etiqueta de la Caja de cartón
        cajaCarton.setEtiqueta("CAJA-CARTÓN-LADO-100-cm");
        System.out.println("La etiqueta de la caja de cartón es: " + cajaCarton.etiq);

        //Sacamos la superficie y otros datos de la caja de cartón
        System.out.println(cajaCarton);


        //Ahora definimos una caja de 10 cm de lado
        System.out.println("\nCreamos una caja genérica de 10 cm de lado");
        Caja caja = new Caja(10, 10, 10, Caja.Unidad.cm);

        //Sacamos el volumen
        System.out.println("El volumen de la caja genérica es: " + caja.getVolumen() + " m3");

        //Definimos la etiqueta de la Caja genérica
        caja.setEtiqueta("CAJA-GENÉRICA-LADO-10-cm");
        System.out.println("La etiqueta de la caja genérica es: " + caja.etiq);

        //Sacamos la superficie y otros datos de la caja genérica
        System.out.println(caja);


        //Y ahora definimos una caja de 1 m de lado
        System.out.println("\nCreamos otra caja genérica de 1 m de lado");
        Caja caja2 = new Caja(1, 1, 1, Caja.Unidad.m);

        //Sacamos el volumen
        System.out.println("El volumen de esta otra caja genérica es: " + caja2.getVolumen() + " m3");

        //Definimos la etiqueta de la Caja genérica
        caja2.setEtiqueta("CAJA-GENÉRICA-LADO-1-m");
        System.out.println("La etiqueta de la nueva caja genérica es: " + caja2.etiq);

        //Sacamos la superficie y otros datos de la caja genérica
        System.out.println(caja2);


        //Finalmente creamos otra Caja de Cartón para comprobar la superficie total:
        System.out.println("Creamos otra caja de cartón de 200 cm de lado");
        CajaCarton cajaCarton2 = new CajaCarton(200, 200, 200);

        //Sacamos el volumen
        System.out.println("El volumen de la segunda caja de cartón es: " + cajaCarton2.getVolumen() + " m3");

        //Definimos la etiqueta de la Caja de cartón
        cajaCarton2.setEtiqueta("CAJA-CARTÓN-LADO-200-cm");
        System.out.println("La etiqueta de la segunda caja de cartón es: " + cajaCarton2.etiq);

        //Sacamos la superficie y otros datos de la caja de cartón
        System.out.println(cajaCarton2);
    }
}
