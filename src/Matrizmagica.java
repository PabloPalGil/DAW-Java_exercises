public class Matrizmagica {
    /*Escribe un programa que dada una matriz de números enteros de 3x3 (creada en
tiempo de compilación), decida si la matriz corresponde a una matriz mágica, que es
aquella donde la suma de los elementos de cualquier fila o de cualquier columna valen
lo mismo. Restricción: usar 3 funciones. Solamente un return por función.*/

    public static void main(String[] args){
        int[][] matriz =
                {       {4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 6}};
        /*
        int[][] matriz =
                {       {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
                        */


        //Debemos comparar los sumatorios de cada columna y de cada fila (3 filas y 3 columnas, 6 valores en total)
        int[] sumatorios = new int[6];

        //Primero calculamos los sumatorios de las filas:
        for(int i = 0; i < 3; i++){
            sumatorios[i] = sumaFilas(matriz, i);
        }

        //Luego calculamos los sumatorios de las columnas:
        for(int i = 3; i < 6; i++){
            sumatorios[i] = sumaColumnas(matriz, (i - 3));
        }

        //Finalmente comprobamos si la matriz es mágica:
        comprobarMatriz(sumatorios);
    }

    //Funcion que devuelve los sumatorios de las 3 filas de la matriz de entrada (tiene que ser 3x3)
    public static int sumaFilas(int[][] matriz, int i){
        int fila = 0;
        for(int x = 0; x < 3; x++){
            fila += matriz[x][i];
        }
        System.out.println("El sumatorio de la fila " + i + " vale " + fila);
        return fila;
    }

    //Funcion que devuelve los sumatorios de las 3 columnas de la matriz de entrada (tiene que ser 3x3)
    public static int sumaColumnas(int[][] matriz, int i){
        int col = 0;
        for(int y = 0; y < 3; y++){
            col += matriz[i][y];
        }
        System.out.println("El sumatorio de la columna " + i + " vale " + col);
        return col;
    }


    //Funcion que comprueba que si la matriz es magica a partir de los sumatorios obtenidos:
    static void comprobarMatriz(int[] sumatorios){
        boolean matrizEsMagica = true;
        int valor = sumatorios[0];
        for(int i = 0; i < sumatorios.length; i++){
            if(sumatorios[i] != valor){
                matrizEsMagica = false;
                break;
            }
        }
        if(matrizEsMagica){
            System.out.println("La matriz sí es mágica! :)");
        }
        else{
            System.out.println("La matriz no es mágica :(");
        }
    }
}
