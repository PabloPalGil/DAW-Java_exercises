import java.util.Arrays;

/*Implementamos las listas con tablas de tipo Integer, que iremos
redimensionando según vaya haciendo falta. El índice de un elemento en la
lista coincide con el índice del lugar que ocupa en la tabla.
 */
public class Lista {
    Integer[] tabla;

    public Lista(){
        tabla = new Integer[0];
    }

    void insertarPrincipio(Integer nuevo){
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        System.arraycopy(tabla, 0, tabla, 1, tabla.length - 1);
        tabla[0] = nuevo;
    }

    void insertarFinal(Integer nuevo){
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length - 1] = nuevo;
    }

    void insertarFinal(Lista otraLista){
        int tamIni = tabla.length;//tamaño inicial tabla
        tabla = Arrays.copyOf(tabla, tabla.length + otraLista.tabla.length);
        System.arraycopy(otraLista.tabla, 0, tabla, tamIni, otraLista.tabla.length);
    }

    //El primer parámetro es el índice del lugar donde queremos insertar
    //el valor del segundo parámetro
    void insertar(int posicion, Integer nuevo){
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        System.arraycopy(tabla, posicion, tabla, posicion + 1,
                tabla.length - posicion - 1);
        tabla[posicion] = nuevo;
    }

    //Se elimina el elemento correspondiente a indice y se devuelve
    Integer eliminar(int indice){
        Integer eliminado = null;
        if(indice >= 0 && indice < tabla.length){
            eliminado = tabla[indice];
            for (int i = indice + 1; i < tabla.length; i++){
                tabla[i - 1] = tabla[i];
            }
            tabla = Arrays.copyOf(tabla, tabla.length - 1);
        }
        return eliminado;
    }

    /*Al siguiente método le pasaremos un índice y nos devolverá el elemento
    correspondiente de la tabla sin modificarla. En el caso de que el índice no
    sea válido, devolverá null, con lo que cual evitamos que el programa aborte.
     */
    Integer get(int indice){
        Integer resultado = null;
        if (indice >= 0 && indice < tabla.length){ //indice válido
            resultado = tabla[indice];
        }
        return resultado;
    }

    int buscar(Integer claveBusqueda){
        int indice = -1;
        for (int i = 0; i < tabla.length && indice == -1; i++){
            if (tabla[i].equals(claveBusqueda)) {//no vale tabla[i]==claveBusqueda
                indice = i;
            }
        }
        return indice;
    }

    @Override
    public String toString() {//mostramos la tabla
        return Arrays.deepToString(tabla);
    }

    //El número de elementos de la lista es el número de elementos de la tabla
    public int numeroElementos(){
        return tabla.length;
    }

    //Muestra por consola el contenido de la lista
    public void mostrar(){
        System.out.println("Lista: " + Arrays.toString(tabla));
    }
}