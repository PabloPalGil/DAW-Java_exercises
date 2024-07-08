import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.time.LocalDate.now;


public class Application_14_15 {
    /*
    Utilizando la BD Empleados, crea un programa que pida al usuario los datos de un empleado,
     excepto la fecha de contratación que la generará el sistema (con la fecha de introducción
      de datos) y los inserte en la BD
     */
    public static void main(String[] args) {
        Connection con;
        PreparedStatement sentencia;
        String sql;

        final int TAM_NOMBRE = 30, TAM_PUESTO = 30;//Nombre y puesto de la tabla Empleados son VARCHAR(30)

        //Establecemos la Uniform Resource Locator a la bbdd
        //String url = "jdbc:sqlite:C:/sqlite/db/Empresa.db";//sqlite
        String url = "jdbc:mysql://localhost:3306/empresa";//mySQL

        try {
            //Abrimos la conexión a la bbdd e inicializamos la sentencia:
            //con = DriverManager.getConnection(url);//sqlite
            con = DriverManager.getConnection(url, "Pepe", "12345");//mySQL


            //Solicitamos los datos necesarios del nuevo empleado:
            System.out.println("Numero de empleado:");
            int numemp = new Scanner(System.in).nextInt();

            System.out.println("Nombre del empleado:");
            //En la bbdd, el nombre es de tipo VARCHAR(30), por lo que limitamos a 30 caracteres:
            String nombre = new Scanner(System.in).nextLine();
            nombre = nombre.substring(0, Math.min(TAM_NOMBRE, nombre.length()));

            System.out.println("Edad del empleado:");
            int edad = new Scanner(System.in).nextInt();

            System.out.println("Oficina del empleado:");
            int oficina = new Scanner(System.in).nextInt();

            System.out.println("Puesto del empleado:");
            //En la bbdd, el puesto es de tipo VARCHAR(30), por lo que limitamos a 30 caracteres:
            String puesto = new Scanner(System.in).nextLine();
            puesto = puesto.substring(0, Math.min(TAM_PUESTO, puesto.length()));

            //Definimos la fecha del contrato:
            java.util.Date aux = new java.util.Date();
            java.sql.Date fechaHoy = new java.sql.Date(aux.getTime());

            //Otra opción:
            //java.sql.Date fechaHoy = new java.sql.Date(System.currentTimeMillis());

            //Construimos la sentencia INSERT que creará el registro del nuevo empleado:
            sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            //Introducimos los parámetros:
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, numemp);
            sentencia.setString(2, nombre);
            sentencia.setInt(3, edad);
            sentencia.setInt(4, oficina);
            sentencia.setString(5, puesto);
            sentencia.setDate(6, fechaHoy);

            //Ejecutamos la sentencia
            sentencia.executeUpdate();

            con.close();//Cerramos la conexión

            System.out.println("Se ha insertado el nuevo empleado con fecha de contrato: " + fechaHoy + ".");
        } catch (InputMismatchException ex) {
            System.out.println("Tipo de entrada incorrecto.");
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
