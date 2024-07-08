import java.sql.*;

public class Application_14_11 {
    //Crea un programa que muestre todos los empleados de la BD Empresa.
    public static void main(String[] args) {
        Connection con;
        Statement sentencia;
        ResultSet rs;
        String sql = "SELECT * FROM Empleados";

        String url = "jdbc:sqlite:C:/sqlite/db/Empresa.db";//sqlite
        //String url = "jdbc:mysql://localhost:3306/empresa";//mySQL

        try{
            con = DriverManager.getConnection(url);//sqlite
            //con = DriverManager.getConnection(url, "Pepe", "12345");//mySQL
            sentencia = con.createStatement();
            rs = sentencia.executeQuery(sql);

            System.out.println("Lista de empleados:");

            while(rs.next()){
                int numemp = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int oficina = rs.getInt("oficina");
                String puesto = rs.getString("puesto");
                String contrato = rs.getString("contrato");
                System.out.println("Numemp: " + numemp + "\t" + "Nombre: " + nombre +
                        "\t" + "Edad: " + edad + "\t" + "Oficina: " + oficina + "\t" +
                        "Puesto: " + puesto + "\t\t" + "Contrato: " + contrato);
            }
            con.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
