import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application_14_23 {
    /*
    Utilizando la BD Empleados, crea un programa que permita modificar la ciudad e incrementar las ventas de distintas
     oficinas. Utiliza una clase DAO para la oficina. Muestra los datos antes y después de la modificación.
     */
    public static void main(String[] args) {
        /*
        Entendemos que el objeto DAO sólo debe ocuparse de la comunicación con el SGBD,
        por lo que implementamos el resto de la lógica del programa en esta clase.
         */

        //Declaramos variables:
        int oficina = -1;//Inicializamos a -1
        String ciudad = "";
        double ventas = 0;
        boolean existe = false;//Variable para comprobar si existe la oficina a modificar

        //Mostramos las oficinas:
        OficinaDAO.MostrarOficinas();

        //Solicitamos la oficina a modificar:
        System.out.println("Introduce el número de la oficina a modificar:");

        try{
            oficina = new Scanner (System.in).nextInt();
            existe = OficinaDAO.BuscaOficina(oficina);

            //Comprobamos que la oficina existe:
            if(existe){
                System.out.println("Introduce la nueva ciudad de la oficina " + oficina + " (dejar en blanco para no modificar la ciudad):");
                ciudad = new Scanner(System.in).nextLine();

                if(!ciudad.equals("")){
                    //Modificamos la ciudad de la oficina en cuestión mediante el objeto DAO:
                    OficinaDAO.UpdateCiudad(oficina, ciudad);
                }

                System.out.println("Introduce la cantidad de ventas a incrementar en la oficina " + oficina + ":");
                ventas = new Scanner(System.in).nextDouble();

                //Incrementamos las ventas de la oficina en cuestión mediante el objeto DAO:
                OficinaDAO.UpdateVentas(oficina, ventas);

                //Finalmente, mostramos los datos actualizados:
                OficinaDAO.MostrarOficinas();
            } else{
                System.out.println("La oficina no existe");
            }
        } catch (InputMismatchException ex){
            System.out.println("Tipo de entrada incorrecto.");
        }
    }
}
