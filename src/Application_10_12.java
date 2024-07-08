import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application_10_12 {
    /*Diseña una aplicación que pida al usuario su nombre y su edad. Estos datos deben guardarse en el fichero datos.txt.
     Si este fichero existe, deben añadirse al final en una nueva línea, y en caso de no existir, debe crearse.*/

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;

        System.out.println("Introduce tu nombre:");
        nombre = sc.nextLine();

        //Comprobaremos que la edad no es un número negativo ni tipo incompatible mediante un try-catch
        //y no seguiremos a menos que sea un dato válido mediante un bucle while:
        while(true){
            try {
                System.out.println("Introduce tu edad:");
                edad = new Scanner (System.in).nextInt();
                if(edad < 0) {
                    throw new ExcepcionEdadNegativa();
                }
                else{
                    break;//Sólo llegaremos a este punto si el dato introducido es válido
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Tipo erróneo");
            }
            catch (ExcepcionEdadNegativa ex){
                System.out.println(ex);
            }
        }


        //Implementamos la creación del archivo datos.txt:
        //Primero definimos el buffer de escritura/salida
        BufferedWriter out = null;
        boolean append = true;//Para añadir al final del fichero en caso de que ya exista

        //Abrimos el bloque try-catch por si hay una excepción de Entrada-Salida
        try {
            //Asignamos el BufferedWriter con el FileWriter al archivo datos.txt de salida:
            out = new BufferedWriter(new FileWriter("datos.txt", true));

            /* Opción 1: leyendo del archivo para insertar o no salto de línea
            //Si el fichero existía podremos leer algo
            FileReader in = new FileReader("datos.txt");
            if(in.read() != -1){ //Si true, el fichero ya tenia contenido
                out.newLine();//Añadimos un salto de línea al final
            }
            out.write(nombre + " " + edad);//Escribimos "nombre edad"
             */

            //Opción 2: insertando línea al final para que no haya que leer del archivo:
            out.write(nombre + " " + edad);//Escribimos "nombre edad"
            out.newLine();//Añadimos un salto de línea al final

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //Nos aseguramos de cerrar el búfer con la clausula finally del bloque try-catch:
        finally {
            if (out != null){
                try{
                    out.close();//vaciamos el búfer y escribimos en datos.txt
                } catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }

    }

    //Definimos nuestra propia excepción para el caso de una edad negativa:
    public static class ExcepcionEdadNegativa extends Exception {
        public String toString(){
            return "Edad negativa";
        }
    }
}
