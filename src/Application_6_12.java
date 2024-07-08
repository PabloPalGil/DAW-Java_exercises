import java.util.Scanner;
import java.util.Arrays;
public class Application_6_12 {
    /*Realiza el juego del ahorcado. Las reglas del juego son las siguientes:

    El jugador A teclea una palabra, sin que el jugador B la vea.
    Ahora se le muestra al jugador B tantos guiones como letras tenga la palabra secreta. Por ejemplo, para hola
    sería "_ _ _ _"
    El jugador B intentará acertar, letra a letra, la palabra secreta
    Cada acierto muestra la letra en su lugar y las letras no acertadas seguirán ocultas como guiones. Siguiendo con
    el ejemplo anterior, y suponiendo que se ha introducido: la 'o', la 'j' y la 'a', se mostrará: "_ o _ a"
    En cada intento se mostrará además de como va el juego (punto anterior), las letras que ya ha intentado y han
    sido incorrectas.
    El jugador B solo tiene 7 intentos
    La partida terminará al acertar todas las letras que forman la palabra secreta (gana el jugador B) o cuando
    se agoten todos los intentos (gana el jugador A)*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String secreta;//La palabra secreta
        String pista = "";//La cadena a mostrar al jugador 2
        char[] letras = {};//Tabla de chars donde almacenamos las letras que no están en la palabra secreta
        int intentos = 7;//Contamos los intentos restantes para adivinar letras (sólo descuenta si no está la letra propuesta)

        //Pedimos la palabra al jugador1, comprobando que no es una cadena vacía:
        do {
            System.out.println("Jugador 1, escribe la palabra secreta:");
            secreta = sc.nextLine();
        } while(secreta.isEmpty());
        //Ponemos la palabra introducida en minúsculas por si se ha introducido en mayúsculas:
        secreta = secreta.toLowerCase();

        //Definimos la variable char[] con el estado del juego:
        char[] estado = new char[secreta.length()];

        //Inicializamos la palabra con los guiones bajos:
        Arrays.fill(estado, '_');

        //Ahora mostramos el estado del juego y pedimos una letra al jugador 2
        do{
            //Mostramos el estado del juego:
            System.out.println("\n\n\n\nAdivina la palabra:\n " + String.valueOf(estado));

            //Mostramos las letras introducidas anteriormente:
            System.out.println("Intentos previos: " + Arrays.toString(letras));
            System.out.println(MostrarAhorcado(intentos));//"Dibujamos" al ahorcado

            //Solicitamos una letra al jugador2:
            System.out.println("Jugador 2, introduce una nueva letra:\nIntentos restantes: " + intentos);
            String input = sc.next();

            //Comprobamos que se ha introducido 1 letra:
            while(input.length() > 1 || !Character.isLetter(input.charAt(0))){
                System.out.println("Introduce una letra:");
                input = sc.next();
            }
            //Ponemos la letra en minúscula:
            input.toLowerCase();
            //Convertimos a tipo char
            char c = input.charAt(0);

            //Comprobamos que no sea una letra repetida (en cuyo caso contaría como fallo):
            if(String.valueOf(estado).indexOf(c) != -1 ){
                //La letra ya había salido, descontamos intento
                intentos--;
            }
            else if(String.valueOf(letras).indexOf(c) != -1 ){
                //La letra no está en la palabra secreta pero ya había salido, descontamos intento:
                intentos--;
            }
            else{//La letra no se ha dicho antes:
                //Comprobamos si la letra está en la palabra secreta:
                boolean coincidencia = false;//Controlamos si la letra está o no en la palabra secreta
                for(int i = 0; i < secreta.length(); i++){
                    if(c == secreta.charAt(i)) {
                        //La letra está en la palabra secreta, actualizamos estado:
                        estado[i] = c;
                        coincidencia = true;
                    }
                }
                if(!coincidencia){
                    //Si la letra no está en la palabra secreta, descontamos intento:
                    intentos--;
                    //Incrementamos la tabla de letras fallidas y añadimos la nueva letra:
                    letras = Arrays.copyOf(letras, letras.length + 1);
                    letras[letras.length - 1] = c;
                }
            }
        } while(!secreta.equals(String.valueOf(estado)) && intentos > 0);

        //Mostramos el resultado final
        if(intentos > 0){
            //Si aun quedan intentos, el jugador 2 ha desbloqueado la palabra y gana:
            System.out.println("Enhorabuena Jugador2, has sacado la palabra: " + secreta);
        }
        else{
            //Si nos hemos quedado sin intentos, gana el Jugador 1
            System.out.println(MostrarAhorcado(intentos));//"Dibujamos" al ahorcado
            System.out.println("Enhorabuena Jugador1, no han adivinado tu palabra secreta.");
        }
    }

    //Como añadido especial, creamos una función que dibujará el ahorcado según los intentos restantes:
    static String MostrarAhorcado(int i){
        String resultado = "";
        switch(i){
            case 7:
                resultado = (" __\n|  \n|  \n| \n| \n|______");
                break;
            case 6:
                resultado = (" __\n|  |\n|  \n| \n| \n|______");
                break;
            case 5:
                resultado = (" __\n|  |\n|  O\n| \n| \n|______");
                break;
            case 4:
                resultado = (" __\n|  |\n|  O\n|  |\n| \n|______");
                break;
            case 3:
                resultado = (" __\n|  |\n|  O\n|  |\\\n| \n|______");
                break;
            case 2:
                resultado = (" __\n|  |\n|  O\n| /|\\\n| \n|______");
                break;
            case 1:
                resultado = (" __\n|  |\n|  O\n| /|\\\n| /\n|______");
                break;
            default:
                resultado = (" __\n|  |\n|  O\n| /|\\\n| / \\\n|______");
        }
        return resultado;
    }
}
