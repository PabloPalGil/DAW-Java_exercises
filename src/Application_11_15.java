import java.io.*;
import java.util.Scanner;

public class Application_11_15 {
    /*
    Crea un programa que lea números enteros desde el fichero
    numeros.dat y los vaya guardando en los ficheros
    pares.dat e impares.dat según su paridad.
     */
    public static void main(String[] args){
        //Primero escribimos los números en el archivo numeros.dat:
        try (ObjectOutputStream salida = new ObjectOutputStream((new FileOutputStream("numeros.dat")))){
            System.out.println("Introduce entero:");
            Scanner s = new Scanner(System.in);
            int numero = s.nextInt();
            while(numero != -1){
                salida.writeInt(numero);
                System.out.println("Introduce entero (-1 para terminar):");
                s = new Scanner(System.in);
                numero = s.nextInt();
            }
        } catch (IOException ex){
            System.out.println(ex);
        }

        //Ahora leeremos los numeros de numeros.dat y los escribiremos en pares.dat e impares.dat
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("numeros.dat"));
             ObjectOutputStream outPares = new ObjectOutputStream(new FileOutputStream("pares.dat"));
             ObjectOutputStream outImpares = new ObjectOutputStream(new FileOutputStream("impares.dat"))){
            System.out.println("Se leen los siguientes números:");
            //Como no tenemos porqué conocer cuántos números hay en numeros.dat, leemos hasta EOFException:
            while(true){
                int numero = in.readInt();
                //Según sea par o impar, lo guardamos en su fichero correspondiente:
                if(numero % 2 == 0){//Si es par:
                    System.out.println(numero + " --> par");
                    outPares.writeInt(numero);
                } else {//Si es impar:
                    System.out.println(numero + " --> impar");
                    outImpares.writeInt(numero);
                }
            }
        } catch (EOFException ex){
            System.out.println("\nYa no hay más números.");
        } catch (IOException ex){
            System.out.println(ex);
        }
    }
}
