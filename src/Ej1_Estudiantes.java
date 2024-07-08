import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej1_Estudiantes {
    public static void main(String[] args){
        //Inicializamos la Lista de Objects "estudiantes", definida en la clase ListaObjects
        ListaObjects estudiantes = new ListaObjects();

        //Leemos la lista de estudiantes del fichero estudiantes.dat
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("estudiantes.dat"))){
            estudiantes = (ListaObjects) in.readObject();
        } catch (FileNotFoundException ex){
            System.out.println("El fichero no existe.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }

        //La primera vez que arranca el programa, el fichero estudiantes.dat no existe,
        //por lo que saltará el catch y trabajaremos con la lista vacía.
        int opcion = 0;

        //Inicializamos el menú:
        do {
            System.out.println("1 - Añadir estudiante.\n" +
                    "2 - Mostrar estudiantes.\n" +
                    "3 - Guardar lista.\n" +
                    "4 - Cargar lista.\n" +
                    "5 - Salir.\n" +
                    "Introduce un número según la acción a realizar:");
            Scanner sc = new Scanner(System.in);
            try{
                opcion = sc.nextInt();
            } catch (InputMismatchException ex){
                System.out.println(ex);
            }

            switch (opcion) {
                case 1 -> {//AÑADIR
                    Estudiante est = DefineEstudiante();
                    //Añadimos el estudiante nuevo a nuestra Lista de estudiantes:
                    estudiantes.insertarFinal(est);
                }
                case 2 -> {//MOSTRAR
                    System.out.println("Mostramos la lista de estudiantes:");
                    System.out.println(estudiantes);
                }
                case 3 -> {//GUARDAR
                    GuardarFichero(estudiantes);//Guardamos/actualizamos el fichero "estudiantes.dat"
                }
                case 4 -> {//CARGAR
                    CargarFichero(estudiantes);
                }
                case 5 -> {//SALIR
                    System.out.println("Cerrando...");
                }
                default -> {
                    System.out.println("Por favor, introduce una de las opciones del menú.");
                }
            }
        }  while (opcion != 5);
    }

    private static Estudiante DefineEstudiante() {
        Scanner sc = new Scanner(System.in);
        String nombre = null;
        int edad = 0;
        int curso = 0;
        Estudiante est = null;

        try {
            System.out.println("Introduce el nombre del estudiante:");
            nombre = sc.nextLine();
            System.out.println("Introduce la edad del estudiante:");
            edad = sc.nextInt();
            System.out.println("Introduce el curso del estudiante:");
            curso = sc.nextInt();
            est = new Estudiante(nombre, edad, curso);
        } catch (InputMismatchException ex){
            System.out.println("Entrada incorrecta.");
        }
        return est;
    }

    static void GuardarFichero(ListaObjects estudiantes){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estudiantes.dat"))){
            out.writeObject(estudiantes);
            System.out.println("Fichero \"estudiantes.dat\" guardado correctamente");
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    static void CargarFichero(ListaObjects estudiantes){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("estudiantes.dat"))){

            estudiantes = (ListaObjects) in.readObject();

        } catch (IOException ex){
            System.out.println(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

