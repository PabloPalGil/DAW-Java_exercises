/* Diseñar la clase "Futbolista" con los siguiente atributos: Dni, Nombre, Edad y Número de goles
Implementar:

    Un constructor y los métodos toString() y equals() (este último basado en el DNI)
    La interfaz "Comparable" con un criterio de ordenación basado también en el DNI
    Un comparador para hacer ordenaciones basados en el nombre y otro basado en la edad

Crea un programa con una tabla con 5 futbolistas y múestra un menú para poder ordenarlos por DNI,
 por nombre y por edad */

public class Futbolista implements Comparable {
    //Atributos:
    public String dni;
    String nombre;
    int edad;
    int numGoles;

    //Constructor:
    Futbolista(String dni, String nombre, int edad, int numGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;//Como no se especifica, definimos la edad puntual, no a partir de la fecha actual
        this.numGoles = numGoles;
    }

    //método toString()
    @Override
    public String toString() {//Siempre utilizamos public para toString() overriding
        String s;
        s = "Dni: " + dni + ". Nombre: " + nombre + ". Edad: " + edad + ". Nº de goles: " + numGoles + ".\n";
        return s;
    }

    //método equals()
    @Override
    public boolean equals(Object otro) {
        Futbolista otroFut = (Futbolista)otro; //conversión de estrechamiento de Object a Futbolista
        boolean iguales;
        if(dni.equals(otroFut.dni)){
            iguales = true;
        } else{
            iguales = false;
        }
        return iguales;
    }

    //Método compareTo() para implementar la interface Comparable:
    public int compareTo(Object otro) {
        return dni.compareTo(((Futbolista)otro).dni);//Se invoca compareTo() de la clase String
    }
}
