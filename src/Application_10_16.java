import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application_10_16 {
    /*Un libro de firmas es útil para recoger los nombres de todas las personas que han pasado por un
    determinado lugar. Crea una aplicación que permita insertar firmas (sin repetición) y mostrar el libro de firmas.
    Llamaremos al fichero firmas.txt.*/

    public static void main(String[] args) {
        /*
        Para poder firmar con nombres y apellidos, haremos que cada firma vaya en una línea distinta.
         */

        int input = 0;
        String[] libroFirmas;

        //Inicializamos el menú principal desde donde podremos elegir añadir una nueva firma, mostrar firmas o salir:
        while (input != -1){
            try{
                System.out.println("Introduce \"1\" para añadir una nueva firma.\n" +
                        "Introduce \"2\" para mostrar las firmas.\n" +
                        "Introduce \"-1\" para cerrar la aplicación.");

                //Introducimos la opción del menú:
                input = new Scanner (System.in).nextInt();

                if(input == 1){
                    AnadirFirma();
                }
                else if (input == 2){
                    if(AlgunaFirma()){
                        libroFirmas = LeerLibroFirmas();
                        System.out.println(Arrays.deepToString(libroFirmas));
                    } else{
                        System.out.println("El libro de firmas está vacío.");
                    }
                }
                else if (input == -1){
                    System.out.println("Cerrando...");
                }
                else{
                    System.out.println("Por favor, introduce una de las opciones sugeridas.");
                }
            } catch(InputMismatchException ex) {
                System.out.println(ex);
            }
        }
    }

    //Método que solicita una firma, comprueba que no está repetida, y la escribe en firmas.txt
    //Versión con APERTURA CON RECURSOS (para no tener que cerrar el bloque try-catch con finally)
    static void AnadirFirma() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("firmas.txt", true))){
            System.out.println("Introduce una nueva firma:");
            String firma = new Scanner(System.in).nextLine();

            //Comprobamos si el fichero ya existe
            if(AlgunaFirma()){
                //Comprobamos que la nueva firma no esté repetida:
                //(Búsqueda en tabla no ordenada)
                int indice = 0;
                String[] firmas = LeerLibroFirmas();
                while(indice < firmas.length && !firma.equalsIgnoreCase(firmas[indice])){
                    indice++;
                }
                if(indice < firmas.length){
                    //Si se ha encontrado la firma:
                    System.out.println("Lo siento, sólo puedes firmar una vez.");
                }
                else{
                    //Firma no encontrada, la añadimos al fichero:
                    out.write(firma);
                    out.newLine();
                }
            }
            else{//El fichero aun no existe
                //Añadimos la firma:
                out.write(firma);
                out.newLine();
            }
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    //Versión sin apertura de medios (requiere bloque try-catch-finally)
/*  static void AnadirFirma() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("firmas.txt", true));
            System.out.println("Introduce una nueva firma:");
            String firma = new Scanner(System.in).nextLine();

            //Comprobamos si el fichero ya existe
            if(AlgunaFirma()){
                //Comprobamos que la nueva firma no esté repetida:
                //(Búsqueda en tabla no ordenada)
                int indice = 0;
                String[] firmas = LeerLibroFirmas();
                while(indice < firmas.length && !firma.equalsIgnoreCase(firmas[indice])){
                    indice++;
                }
                if(indice < firmas.length){
                    //Si se ha encontrado la firma:
                    System.out.println("Lo siento, sólo puedes firmar una vez.");
                }
                else{
                    //Firma no encontrada, la añadimos al fichero:
                    out.write(firma);
                    out.newLine();
                }
            }
            else{//El fichero aun no existe
                //Añadimos la firma:
                out.write(firma);
                out.newLine();
            }
        } catch (IOException ex){
            System.out.println(ex);
        } finally{
            if(out != null){
                try{
                    out.close();
                } catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }*/



    //Método que lee el archivo firmas.txt, identifica sus firmas y las devuelve:
    static String[] LeerLibroFirmas(){
        String[] firmas = {};
        String firma = "";
        BufferedReader in = null;

        //Leemos del archivo firmas.txt, si existe:
        try {
            in = new BufferedReader(new FileReader("firmas.txt"));
            firma = in.readLine();
            while(firma != null){
                firmas = Arrays.copyOf(firmas, firmas.length + 1);
                firmas[firmas.length - 1] = firma;
                firma = in.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        finally{
            if(in != null){
                try{
                    in.close();
                } catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }
        return firmas;
    }

    static boolean AlgunaFirma() {
        boolean resultado = false;
        try{
            //Comprobamos si el fichero firmas.txt ya existe y tiene alguna firma
            FileReader in = new FileReader("firmas.txt");
            if(in.read() != -1) { //Si true, el fichero ya tenia contenido
                resultado = true;
            } else{
                resultado = false;
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
}
