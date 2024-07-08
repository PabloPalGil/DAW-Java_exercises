import java.util.Scanner;
import java.util.Arrays;
public class Application_6_14 {
    /*Diseña una aplicación que se comporte como una pequeña agenda. Mediante un menú el usuario podrá elegir entre:

a) Añadir un nuevo contacto (nombre y teléfono)
b) Buscar el teléfono de un contacto a partir del nombre
c) Mostrar la información de todos los contactos ordenados alfabéticamente mediante el nombre.

Pista: El nombre y el teléfono se pueden codificar como una única cadena con la forma "nombre:telefono". */

    public static void main(String[] args){
        String[] agenda = {};//Inicializamos la tabla agenda vacía aquí y la pasaremos como parámetro en adelante

        inicio(agenda);//Función que muestra el menú principal de la agenda
    }

    static void inicio(String[] agenda){
        Scanner sc = new Scanner(System.in);
        int i = 0;//Variable para seleccionar una opción del menú


        //Mostramos el menú principal:
        System.out.println("\n\nAGENDA - Menú principal:\nIntroduce 1 para añadir un nuevo contacto.\n" +
                "Introduce 2 para buscar el teléfono de un contacto a partir del nombre.\n" +
                "Introduce 3 para mostrar todos los contactos de la agenda.");
        i = sc.nextInt();

        switch (i){
            case 1:
                nuevoContacto(agenda);
                break;
            case 2:
                buscarContacto(agenda);
                break;
            case 3:
                mostrarContactos(agenda);
                break;
        }
    }

    static void nuevoContacto(String[] agenda){
        Scanner sc = new Scanner(System.in);
        String nombre, telefono;

        do{
            System.out.println("Introduce el nombre del nuevo contacto (-1 para salir):");
            nombre = sc.nextLine();
            nombre = nombre.strip();//Si se han introducido espacios en blanco al inicio/final, los eliminamos

            if(!nombre.equals("-1")){
                System.out.println("Introduce el teléfono de " + nombre + ":");
                telefono = sc.nextLine();
                telefono = telefono.strip();//Si se han introducido espacios en blanco, los eliminamos

                //Guardamos el contacto con el formato nombre:telefono:
                agenda = Arrays.copyOf(agenda, agenda.length + 1);
                agenda[agenda.length - 1] = nombre + ":" + telefono;
            }

        } while(!nombre.equals("-1"));

        inicio(agenda);//Volvemos al menú principal:
    }

    static void buscarContacto(String[] agenda){
        Scanner sc = new Scanner(System.in);
        String busqueda;
        boolean match = false;

        //Si la agenda está vacía, redirigimos al usuario al menú para añadir contactos:
        if(agenda.length == 0){
            System.out.println("Todavía no hay contactos en la agenda. Añade a alguien primero.");
            nuevoContacto(agenda);
            return;
        }

        do{
            //Solicitamos un término de búsqueda para algún contacto:
            System.out.println("Buscar contacto (-1 para volver):");
            busqueda = sc.next();
            busqueda = busqueda.toLowerCase();//Pasamos a minúsculas

            //Utilizamos el término de búsqueda para encontrar nombres en nuestra agenda:
            for(int i = 0; i < agenda.length; i++){
                //Buscamos en minúsculas para no tener problemas
                if(agenda[i].toLowerCase().contains(busqueda)){
                    match = true;
                    String[] contacto = agenda[i].split(":");
                    System.out.println(contacto[0] + "\t" + contacto[1]);
                }
            }
            if(!match){
                System.out.println("No se encontraron resultados.");
            }
        } while(!busqueda.equals("-1"));//Cuando se introduzca "-1" volvemos al menu principal
        inicio(agenda);
    }

    //Función para mostrar todos los contactos de la agenda ordenador alfabéticamente
    static void mostrarContactos(String[] agenda){
        String[] agendaOrdenada = Arrays.copyOf(agenda, agenda.length);//Copiamos nuestra agenda para hacer modificaciones
        String[] nombres = new String[agenda.length];//Tabla de sólo el nombre (sin el telefono).
        String[][] contactos = new String[agenda.length][2];//Tabla bidimensional de contactos[nombre][telefono].

        //Llenamos la tabla nombres para poder ordenar sólo por el nombre
        for(int i = 0; i < agenda.length; i++){
            String[] contacto = agenda[i].split(":");
            contactos[i] = contacto;
            nombres[i] = contacto[0].toLowerCase();
        }

        Arrays.sort(nombres);//Ordenamos la tabla nombres

        //Ahora vamos completando agendaOrdenada según el orden de la tabla nombres (ordenada) con los datos de agenda,
        //de esta forma devolvemos las mayúsculas a los nombres y sus teléfonos
        for(int i = 0; i < nombres.length; i++){
            for(int j = 0; j < contactos.length; j++){
                if(nombres[i].equalsIgnoreCase(contactos[j][0])){
                    agendaOrdenada[i] = agenda[j];
                }
            }
        }

        System.out.println("\nEntradas de la agenda:");
        for(int i = 0; i < agendaOrdenada.length; i++){
            String[] contacto = agendaOrdenada[i].split(":");
            System.out.println(contacto[0] + "\t\t" + contacto[1]);
        }

        //Volvemos al menú principal:
        inicio(agenda);
    }
}
