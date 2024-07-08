import java.util.Scanner;

public class Siglas {
    /*Realiza un programa que lea un frase y la convierta en unas siglas. Por ejemplo,
Escuela Oficial de Idiomas, se convierte en EOI. (Solo forman parte de las siglas las
palabras que comiencen en mayúsculas). Restricción: solo puedes usar un máximo de
3 métodos sobre cadenas de caracteres.*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String frase;
        String[] palabras;
        String sigla = "";


        //Solicitamos la frase de entrada
        System.out.println("Introduce la frase para convertir a siglas:");
        frase = sc.nextLine();

        //Descomponemos la frase en una String[] con las palabras sueltas:
        palabras = frase.split(" ");//PRIMER MÉTODO USADO SOBRE UNA CADENA DE CARACTERES

        //Comprobamos si las palabras empiezan por mayúscula o no:
        for(int i = 0; i < palabras.length; i++){
            //Obtenemos el primer caracter de la palabra:
            char c = palabras[i].charAt(0);//SEGUNDO METODO
            if(Character.isUpperCase(c)){//ESTE METODO ES SOBRE UN CARACTER, NO SOBRE UNA CADENA, ASÍ QUE NO LO CUENTO :)
                sigla += c;
            }
        }

        //mostramos el resultado:
        System.out.println(sigla);
    }
}
