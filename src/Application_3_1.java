import java.util.Scanner;
public class Application_3_1 {
    /*Diseña una aplicación que muestre la edad máxima y mínima de un grupo de alumnos.
    El usuario introducirá las edades y terminará cuando se escriba un -1*/

    public static void main(String[] args){
       //Declaramos las variables necesarias
        int edadMax = -1;//Inicializamos a -1 para contemplar alumnos de 0 años (meses de edad)
        int edadMin = -1;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        //Como no sabemos el tamaño del grupo, utilizamos un bucle while
        while(num != -1) {//Mientras no se introduzca un -1, iteramos:
            System.out.println("Introduce la edad de un alumno (-1 para terminar): ");
            num = sc.nextInt();
            if(num < -1)//Controlamos que no se introduzca una edad negativa
                System.out.println("¡La edad no puede ser negativa!");
            else if(num != -1){//Si no se ha introducido un -1, asignamos/comparamos las edades
                if(num > edadMax) {
                    edadMax = num;
                    if (edadMin == -1)//Al introducir la primera edad, esta será tanto la edad mínima como la máxima
                        edadMin = edadMax;
                }
                if(num < edadMin)
                    edadMin = num;
            }
            else{//Si se ha introducido -1
                System.out.println("Cerramos el listado de edades de alumnos.");
            }
        }

        //Una vez se termina el bucle, se muestran las edades mínima y máxima:
        if(edadMax == -1)
            System.out.println("No se ha introducido la edad de ningún alumno");
        else
            System.out.println("La edad mínima es " + edadMin + "\nLa edad máxima es " + edadMax);
    }
}
