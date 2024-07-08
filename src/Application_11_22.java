import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Application_11_22 {
    /*
Crea una aplicación que gestione los empleados de un banco
(añadir, eliminar, mostrar, modificar). Para ello se definirá
la clase Empleado con los atributos dni, nombre y sueldo.
Los empleados se guardarán en un objeto de la clase Lista
para objetos de la clase Object y en el fichero empleados.dat.
La aplicación cargará en memoria, al arrancar, la lista de
empleados desde el archivo empleados.dat
 */
    public static void main(String[] args){
        //Inicializamos la Lista de Objects "empleados", definida en la clase ListaObjects
        ListaObjects empleados = new ListaObjects();

        //Leemos la lista de empleados del fichero empleados.dat
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("empleados.dat"))){
            empleados = (ListaObjects) in.readObject();
        } catch (FileNotFoundException ex){
            System.out.println("El fichero no existe.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }

        //La primera vez que arranca el programa, el fichero empleados.dat no existe,
        //por lo que saltará el catch y trabajaremos con la lista vacía.
        int opcion = 0;

        //Inicializamos el menú:
        do {
            System.out.println("1 - Añadir empleado.\n" +
                    "2 - Eliminar empleado.\n" +
                    "3 - Mostrar empleados.\n" +
                    "4 - Modificar empleado.\n" +
                    "5 - Guardar y salir.\n" +
                    "6 - Salir sin guardar cambios.\n" +
                    "Introduce un número según la acción a realizar:");
            Scanner sc = new Scanner(System.in);
            try{
                opcion = sc.nextInt();
            } catch (InputMismatchException ex){
                System.out.println(ex);
            }

            switch (opcion) {
                case 1 -> {//AÑADIR
                    Empleado emp = DefineEmpleado();
                    //Añadimos el empleado nuevo a nuestra Lista de empleados:
                    empleados.insertarFinal(emp);
                }
                case 2 -> {//ELIMINAR
                    //El nombre y el sueldo se pueden repetir, pero el dni es único:
                    System.out.println("Introduce el dni del empleado a eliminar:");
                    String dni = new Scanner(System.in).nextLine();
                    Empleado emp = null;//Referencia vacía al empleado a eliminar por si no se encuentra

                    //Buscamos al empleado del dni introducido
                    for(int i = 0; i < empleados.tabla.length; i++){
                        if(((Empleado)empleados.tabla[i]).equals(dni)){//Si encontramos al empleado del dni
                            emp = (Empleado) empleados.tabla[i];//Referenciamos al empleado a eliminar
                            empleados.eliminar(i);//Eliminamos de nuestra lista al empleado
                            break;//Salimos del for (en principio no pueden haber 2 empleados con el mismo dni
                        }
                    }

                    //Mostramos el resultado de la operación:
                    if(emp != null){
                        System.out.println("Se ha eliminado al empleado:\n" + emp);
                    } else{
                        System.out.println("No se ha encontrado ningún empleado con dni " + dni);
                    }
                }
                case 3 -> {//MOSTRAR
                    System.out.println("Mostramos la lista de empleados:");
                    System.out.println(empleados);
                }
                case 4 -> {//MODIFICAR
                    System.out.println("Introduce el dni del empleado a modificar:");
                    String dni = new Scanner(System.in).nextLine();
                    Empleado emp = null;//Referencia vacía al empleado a eliminar por si no se encuentra

                    //Buscamos al empleado del dni introducido
                    for(int i = 0; i < empleados.tabla.length; i++){
                        if(((Empleado)empleados.tabla[i]).equals(dni)){//Si encontramos al empleado del dni
                            emp = (Empleado) empleados.tabla[i];//Referenciamos al empleado a modificar

                            //Solicitamos los nuevos datos para el empleado
                            System.out.println("Introduce los nuevos datos para el empleado\n" + emp);
                            emp = DefineEmpleado();

                            //Y actualizamos la Lista:
                            empleados.insertar(i, emp);
                            empleados.eliminar(i + 1);
                            break;//Salimos del for (en principio no pueden haber 2 empleados con el mismo dni
                        }
                    }

                    //Mostramos el resultado de la operación:
                    if(emp != null){
                        System.out.println("Se han actualizado los datos del empleado:\n" + emp);
                    } else{
                        System.out.println("No se ha encontrado ningún empleado con dni " + dni);
                    }
                }
                case 5 -> {//GUARDAR Y SALIR
                    GuardarFichero(empleados);//Guardamos/actualizamos el fichero "empleados.dat"
                    System.out.println("Cerrando...");
                }
                case 6 -> {//CANCELAR CAMBIOS Y SALIR
                    System.out.println("Cerrando...");
                }
                default -> {
                    System.out.println("Por favor, introduce una de las opciones del menú.");
                }
            }
        }  while (opcion != 5 && opcion != 6);
    }

    private static Empleado DefineEmpleado() {
        Scanner sc = new Scanner(System.in);
        String dni = null;
        String nombre = null;
        double sueldo = 0;
        Empleado emp = null;

        try {
            System.out.println("Introduce el dni del empleado:");
            dni = sc.nextLine();
            System.out.println("Introduce el nombre del empleado:");
            nombre = sc.nextLine();
            System.out.println("Introduce el sueldo del empleado:");
            sueldo = sc.useLocale(Locale.US).nextDouble();
            emp = new Empleado(dni, nombre, sueldo);
        } catch (InputMismatchException ex){
            System.out.println("Entrada incorrecta.");
        }
        return emp;
    }

    static void GuardarFichero(ListaObjects empleados){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("empleados.dat"))){
            out.writeObject(empleados);
            System.out.println("Fichero \"empleados.dat\" guardado correctamente");
        } catch (IOException ex){
            System.out.println(ex);
        }
    }
}
