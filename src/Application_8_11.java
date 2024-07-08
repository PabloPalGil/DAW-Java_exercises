import java.util.Arrays;
import java.util.Scanner;
public class Application_8_11 {
    /*    Crea la clase Campana que hereda de Instrumento (definida en la Actividad resuelta 8.4).

        El constructor de Campana será el mismo que el de Instrumento.
        La clase Campana redefinirá el método Interpretar()

    Crea  también un programa para probar la clase Campana*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Campana campana = new Campana();

        //Comprobamos que funciona con cada nota
        System.out.println("Probamos a tocar cada nota de una octava con una campana:");
        Nota[] cancion = {Nota.DO, Nota.RE, Nota.MI, Nota.FA, Nota.SOL, Nota.LA, Nota.SI};
        Tocar(campana, cancion);


        //Adicionalmente, pedimos una cancion al usuario y la tocaremos con la campana
        System.out.println("Ahora introduce nota a nota la canción que quieras tocar (-1 para salir):");
        cancion = new Nota[0];
        String notas = "";//Variable que almacenará las notas introducidas válidas
        String nota = "";//Aquí guardamos lo que introduce el usuario

        while(!nota.equals("-1")){//Mientras no se introduzca -1, vamos almacenando las notas válidas
            nota = sc.next();
            nota = nota.strip();//Eliminamos posibles caracteres en blanco
            nota = nota.toUpperCase();//Pasamos a mayúsculas para comprobar la validez de la nota

            switch (nota){
                case "DO":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.DO;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "RE":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.RE;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "MI":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.MI;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "FA":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.FA;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "SOL":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.SOL;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "LA":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.LA;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "SI":
                    notas += nota + " ";//Si es una nota válida, la guardamos en la melodía
                    cancion = Arrays.copyOf(cancion, cancion.length + 1);
                    cancion[cancion.length - 1] = Nota.SI;
                    System.out.println("Notas introducidas: " + notas);
                    break;
                case "-1":
                    break;
                default:
                   System.out.println("¡Introduce una nota válida (ó -1 para terminar)!");
            }
        }

        Tocar(campana, cancion);
    }

    //Método que interpreta la cancion especificada con el instrumento especificado como parámetros de entrada
    static void Tocar(Instrumento instrumento, Nota[] cancion){
        for(Nota nota:cancion){
            instrumento.add(nota);
        }
        instrumento.interpretar();
    }
}
