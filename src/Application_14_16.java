import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.time.LocalDate.now;

public class Application_14_16 {
    /*
    Utilizando la BD Empleados, modifica la actividad 14.15 para que el programa utilice mapeo objeto-relacional,
     para insertar los datos de un empleado, creando previamente un objeto de tipo Empleado. Utiliza un objeto
      tipo DAO para la inserción, no hace falta implementar otros métodos DAO. El programa controlará si el
       empleado a insertar ya existe en la BD, (campo a controlar "numemp")
     */
    public static void main(String[] args) {
        try {
            //Solicitamos los datos necesarios del nuevo empleado:
            System.out.println("Numero de empleado:");
            int numemp = new Scanner(System.in).nextInt();

            System.out.println("Nombre del empleado:");
            String nombre = new Scanner(System.in).nextLine();

            System.out.println("Edad del empleado:");
            int edad = new Scanner(System.in).nextInt();

            System.out.println("Oficina del empleado:");
            int oficina = new Scanner(System.in).nextInt();

            System.out.println("Puesto del empleado:");
            String puesto = new Scanner(System.in).nextLine();

            //Definimos la fecha del contrato:
            java.util.Date fechaHoyAux = new java.util.Date();
            //java.sql.Date fechaHoy = new java.sql.Date(aux.getTime());

            //Creamos el objeto EmpleadoT14 a partir de los datos introducidos:
            EmpleadoT14 emp = new EmpleadoT14(numemp, nombre, edad, oficina, puesto, fechaHoyAux);

            //Una vez creado el objeto EmpleadoT14, lo introducimos en la BBDD mediante el EmpleadoT14_DAO:
            EmpleadoT14_DAO.create(emp);

        } catch (InputMismatchException ex){
            System.out.println("Tipo de entrada incorrecto.");
        }
    }
}
