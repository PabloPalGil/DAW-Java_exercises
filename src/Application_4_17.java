import java.util.Scanner;
public class Application_4_17 {
    /*Escribe una función que decida si dos números enteros positivos son amigos. (Comprobar que los dos números
    son positivos, sino lo son volver a pedir el número hasta que se introduzcan correctamente). Dos números a y b
    son números amigos si la suma de los divisores propios (distintos de él mismo) de a es igual a b. Y viceversa*/

    //FUNCION PRINCIPAL
    public static void main(String[] args) {
        //Declaramos las variables:
        Scanner sc = new Scanner(System.in);
        int a, b;

        //Pedimos los números al usuario:
        System.out.println("Introduce el primer número:");
        a = CheckPositiveInt(sc.nextInt());
        System.out.println("Introduce el segundo número:");
        b = CheckPositiveInt(sc.nextInt());

        //Una vez tenemos los números, comprobamos si son amigos y mostramos el resultado:
        if(SumDivisores(a) == b && SumDivisores(b) == a){
            System.out.println("Los números " + a + " y " + b + " sí son amigos.");
        } else{
            System.out.println("Los números " + a + " y " + b + " no son amigos.");
        }
    }

    //FUNCION QUE COMPRUEBA QUE EL NÚMERO INTRODUCIDO ES ENTERO POSITIVO:
    static int CheckPositiveInt(int n){
        Scanner sc = new Scanner(System.in);
        //Comprobamos que es un entero positivo:
        while(n <= 0){
            System.out.println("¡Introduce un número entero positivo!");
            n = sc.nextInt();
        }
        return(n);
    }

    //FUNCION QUE CALCULA EL SUMATORIO DE LOS DIVISORES PROPIOS DE UN NÚMERO:
    static int SumDivisores(int n){
        int res = 0;
        for(int i = 1; i < n; i++){
            res += n % i == 0 ? i : 0;
        }
        return(res);
    }
}