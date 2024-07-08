import java.util.Scanner;
public class Ejercicio_3_11 {
    /*Realiza un programa que convierta un número decimal en su representación binaria. Hay que tener en cuenta que
    desconocemos cuántas cifras tiene el número que introduce el usuario. Por simplicidad, iremos mostrando el número
    binario con un dígito por línea.*/

    public static void main(String[] args){
        int num;
        Scanner sc = new Scanner(System.in);
        String resultado = "";

        System.out.println("Introduce un número decimal para convertir a binario: ");
        num = sc.nextInt();

        if(num > 0){
            int i = num;
            while(i > 0){
                System.out.println(i % 2);
                resultado += i % 2;
                i /= 2;
            }
        }
        else if(num < 0){
            //El binario de un numero negativo es su complemento a dos (numeros invertidos + 1)
            //Esto equivale a que el binario de un numero negativo es el complemento a uno del (numero original + 1):
            int i = -(num + 1);
            while(i > 0){
                int j = (i % 2) == 0 ? 1 : 0;
                System.out.println(j);
                resultado += j;
                i /= 2;
            }
        }
        else{
            System.out.println(0);
        }
    }
}
