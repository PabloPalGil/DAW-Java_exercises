import java.sql.*;
import java.util.InputMismatchException;

public class EmpleadoT14_DAO {
    //Crea una conexión con el SGBD y la devuelve:
    private static Connection conectar() {
        Connection con = null;
        //String url = "jdbc:sqlite:C:/sqlite/db/Empresa.db";//sqlite
        String url = "jdbc:mysql://localhost:3306/empresa";//mySQL

        try {
            //con = DriverManager.getConnection(url);//sqlite
            con = DriverManager.getConnection(url, "Pepe", "12345");//mysql
        } catch (SQLException ex) {
            System.out.println("Error al conectar al SGBD.");
        }
        return con;
    }

    //Método que inserta el objeto EmpleadoT14 que se le pasa como parámetro en el SGBD
    public static void create(EmpleadoT14 emp) {
        //Comprobamos que el objeto emp no sea nulo
        if(emp != null) {
            Connection con = conectar();

            //Construimos la sentencia INSERT que creará el registro del nuevo empleado:
            String sql = "INSERT INTO Empleados (numemp, nombre, edad, oficina, puesto, contrato)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try {
                //Comprobamos que el campo clave no se repite:
                boolean repetido = false;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT numemp FROM Empleados");
                while(rs.next()) {
                    if(emp.getNumemp() == rs.getInt("numemp")) {
                        repetido = true;
                    }
                }

                //Si no se repite la clave principal, creamos el registro del nuevo empleado en la BBDD
                if(!repetido) {
                    //Introducimos los parámetros:
                    PreparedStatement sentencia = con.prepareStatement(sql);
                    sentencia.setInt(1, emp.getNumemp());
                    sentencia.setString(2, emp.getNombre());
                    sentencia.setInt(3, emp.getEdad());
                    sentencia.setInt(4, emp.getOficina());
                    sentencia.setString(5, emp.getPuesto());

                    //Cogemos la fecha del contrato de EmpleadoT14 que es java.util.Date y la convertimos a java.sql.Date
                    //antes de insertarla en la bbdd:
                    java.sql.Date fechaContrato = new java.sql.Date(emp.getContrato().getTime());
                    sentencia.setDate(6, fechaContrato);

                    //Ejecutamos la sentencia
                    sentencia.executeUpdate();

                    con.close();//Cerramos la conexión

                    System.out.println("Se ha insertado el nuevo empleado con fecha de contrato: " + fechaContrato + ".");
                }
                else{
                    System.out.println("El id del empleado ya existe");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Tipo de entrada incorrecto.");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
