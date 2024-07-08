import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application_14_14 {
    /*
    Utilizando la BD Empleados, crea un programa que muestre un listado con el nombre y la edad de los empleados,
     cuya edad se encuentra comprendida entre unos valores mínimo y máximo que introducirá el usuario.
     */
    public static void main(String[] args) {
        Connection con;
        PreparedStatement sentencia;//Por seguridad, utilizaremos parámetros
        ResultSet rs;
        String sql;

        //String url = "jdbc:sqlite:C:/sqlite/db/Empresa.db";//sqlite
        String url = "jdbc:mysql://localhost:3306/empresa";//mySQL

        try {
            //con = DriverManager.getConnection(url);//sqlite
            con = DriverManager.getConnection(url, "Pepe", "12345");//mySQL

            //Formamos la consulta:
            sql = "SELECT nombre, edad from Empleados where edad >= ? and edad <= ?";
            sentencia = con.prepareStatement(sql);//Sentencia parametrizada para evitar SQLinjection

            //Solicitamos la edad mínima:
            System.out.println("Introduce la edad mínima:");
            int edadMin = new Scanner(System.in).nextInt();
            //Solicitamos la edad máxima:
            System.out.println("Introduce la edad máxima:");
            int edadMax = new Scanner(System.in).nextInt();

            //Asignamos los parámetros:
            sentencia.setInt(1, edadMin);
            sentencia.setInt(2, edadMax);

            rs = sentencia.executeQuery();
            if(!rs.next()){
                System.out.println("Ningún empleado en el rango de edad seleccionado.");
            } else{
                System.out.println("Nombre: " + rs.getString("nombre") + " " + "\tEdad: " +  rs.getString("edad"));
                while (rs.next()) {
                    System.out.println("Nombre: " + rs.getString("nombre") + " " + "\tEdad: " +  rs.getString("edad"));
                }
            }

            con.close();//Cerramos la conexión con la bbdd
        } catch (InputMismatchException ex) {
            System.out.println("Tipo de entrada incorrecto.");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
