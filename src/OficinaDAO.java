import java.sql.*;
import java.util.InputMismatchException;

public class OficinaDAO {
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

    //Método que muestra por pantalla todas las oficinas:
    public static void MostrarOficinas(){
        Connection con = conectar();
        String sql = "select * from oficinas";

        try {
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            System.out.println("Lista de oficinas:");

            while(rs.next()){
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                int superficie = rs.getInt("superficie");
                double ventas = rs.getDouble("ventas");
                System.out.println("oficina: " + oficina + "\t" + "ciudad: " + ciudad + "\t" +
                        "superficie: " + superficie + "\t" + "ventas: " + ventas);
            }
            con.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }

//    //Método que busca una oficina a partir de su clave primaria y devuelve true si la encuentra o false si no:
    public static boolean BuscaOficina(int claveBusqueda){
        boolean resultado = false;
        Connection con = conectar();
        String sql = "select * from oficinas where oficina = ?";
        ResultSet rs;

        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, claveBusqueda);
            rs = sentencia.executeQuery();

            if(rs.next()){
                resultado = true;
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return resultado;
    }

    //Permite modificar la ciudad:
    public static void UpdateCiudad(int id, String ciudadNueva){
        Connection con = conectar();
        String sql = "update oficinas set ciudad = ? where oficina = ?";

        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, ciudadNueva.substring(0, Math.min(30, ciudadNueva.length())));//VARCHAR(30)
            sentencia.setInt(2, id);
            sentencia.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        }
    }

    //Permite modificar las ventas:
    public static void UpdateVentas(int id, double incrementoVentas){
        Connection con = conectar();
        String sql = "update oficinas set ventas = ventas + ? where oficina = ?";

        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setDouble(1, incrementoVentas);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
