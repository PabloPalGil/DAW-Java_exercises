import java.util.Scanner;
import java.util.Arrays;
public class Application_5_15 {
    /*Realiza una aplicación que ayude a gestionar las notas de un centro educativo. Los alumnos se organizan
    en grupos compuestos por 5 personas. Leer las notas (números enteros) del primer, segundo y tercer trimestre
    de un grupo. Debes mostrar al final la nota media del grupo en cada trimestre y la media del alumno que se
    encuentra en una posición dada (que el usuario introduce por teclado)*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] grupo = new int[5][3];//Matriz bidimensional para almacenar grupos (5 alumnos) y sus notas (3 trimestres)

        //Primero rellenamos aleatoriamente las notas del grupo:
        for (int i = 0; i < grupo.length; i++){
            for (int j = 0; j < grupo[i].length; j++){
                grupo[i][j] = (int) (Math.random() * 10 + 1);//Número aleatorio de 1 a 10.
            }
        }

        //Mostramos las notas recorriendo la matriz y ayudándonos de un poco de texto para darle sentido a los números:
        for (int i = 0; i < grupo.length; i++){
            System.out.print("\nAlumno nº" + (i + 1) + "\n");
            for(int j = 0; j < grupo[i].length; j++){
                System.out.print("Trimestre " + (j + 1)+ ": " + grupo[i][j] + "\n");
            }
        }

        //Otra manera de mostrar las notas:
        System.out.print("\nResumen de notas:\n");
        System.out.println(Arrays.deepToString(grupo));

        //Llamamos a la función que calcula la nota media del grupo por trimestre:
        notaMediaTrimestre(grupo);

        //Llamamos a la función que calcula la media del alumno solicitado:
        System.out.println("\nDe qué alumno quieres saber la media? Introduce de 1 a 5:");
        notaMediaAlumno(grupo, sc.nextInt() - 1);
    }

    //Funcion que calcula la nota media del grupo por trimestre:
    static void notaMediaTrimestre(int[][] t){
        //Como nuestra matriz tiene la forma grupo[alumnos][trimestres],
        //la nota media del grupo por trimestre será la media de cada fila de nuestra matriz.
        double media = 0;//variable para calcular la media en cada trimestre

        System.out.println("\nA continuación se muestran las medias del grupo por trimestre:");

        for(int y = 0; y < 3; y++){
            media = 0;
            for(int x = 0; x < t.length; x++){
                media += t[x][y];//Sumamos las notas del grupo del trimestre i-ésimo
            }
            //Y calculamos la media de este trimestre:
            media /= t.length;
            System.out.println("La media del trimestre " + (y + 1) + " es: " + media);
        }
    }

    //Función que calcula la nota media del alumno solicitado:
    static void notaMediaAlumno(int[][] t, int a){
        //La media del alumno será la media de una columna (eje Y). Como X es conocido, resulta sencillo:
        double media = 0;

        for(int y = 0; y < t[a].length; y++){
            media += t[a][y];//Sumamos las notas del alumno a
        }
        //Y calculamos su media:
        media /= t[a].length;
        System.out.println("La media del alumno " + (a + 1) + " es: " + media);
    }
}
