import java.util.Arrays;
import java.util.Scanner;

public class Ej2_Eurocopa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String[] resultados = new String[0];
        Equipo[] equipos = new Equipo[0];

        do{
            //Mostramos el menú:
            System.out.println("\nElige una opción:\n" +
                    "Introduce \"1\" para crear un equipo.\n" +
                    "Introduce \"2\" para simular un partido.\n" +
                    "Introduce \"3\" para mostrar los resultados de la Eurocopa.\n" +
                    "Introduce \"-1\" para salir.\n");

            input = sc.next();

            switch (input){
                case "1":
                    crearEquipo(equipos);
                    break;
                case "2":
                    System.out.println("Introduce el nombre del equipo local:");
                    String local = sc.nextLine();
                    System.out.println("Introduce el nombre del equipo visitante:");
                    String visitante = sc.nextLine();

                    Equipo eqLocal = getEquipo(local, equipos);
                    Equipo eqVisitante = getEquipo(visitante, equipos);

                    Partido partido = new Partido(eqLocal, eqVisitante);
                    String resultado = partido.simularPartido(eqLocal, eqVisitante);
                    //Falta terminar de implementar el array de resultados para mostrarlo
                    break;
                case "3":

                    break;
                case "-1":
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Introduce una de las opciones del menú.\n");
                    break;
            }
        } while(!input.equals("-1"));
    }

    public static void crearEquipo(Equipo[] equipos){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del equipo: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la fuerza del equipo: ");
        int fuerza = sc.nextInt();

        Equipo equipo = new Equipo(nombre, fuerza);
        //Insertamos el equipo nuevo en nuestra Array
        equipos = Arrays.copyOf(equipos, equipos.length + 1);
        equipos[equipos.length - 1] = equipo;

        System.out.println("Se ha creado el " + equipo.nombre + " con éxito.");
    }


    public static Equipo getEquipo(String nombre, Equipo[] equipos){
        Equipo equipo = null;
        for(int i = 0; i < equipos.length; i++){
            if(nombre.equals(equipos[i].nombre)){
                equipo = equipos[i];
            }
        }
        return equipo;
    }
}
