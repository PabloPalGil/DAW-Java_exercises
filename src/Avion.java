import org.w3c.dom.ls.LSOutput;

public class Avion implements Volador{
    public String modelo;
    public int capacidadPasajeros;
    public float combustible;
    public float combustibleMax;

    //Definimos una variable que indica el gasto de combustible, que podría depender
    // de cada vuelo y del modelo de avion
    public float gastoCombustible1 = 500f;

    //Constructor:
    Avion(String modelo, int CapacidadPasajeros, float combustibleMax){
        this.modelo = modelo;
        this.capacidadPasajeros = CapacidadPasajeros;
        this.combustibleMax = combustibleMax;
    }

    //Implementamos los métodos de la interfaz volador
    @Override
    public void volar() {
        boolean puedeVolar = false;
        if (combustible > gastoCombustible1){
            puedeVolar = true;
            combustible -= gastoCombustible1;
        }
        if(puedeVolar){
            System.out.println(this);
            System.out.println("El avión está volando.");
        }else{
            System.out.println(this);
            System.out.println("El avión necesita repostar.");
        }
    }

    @Override
    public void repostar() {
        if(combustible < combustibleMax){
            System.out.println(this);
            System.out.println("Repostando " + (combustibleMax - combustible) + " unidades de combustible.");
            combustible = combustibleMax;
        } else{
            System.out.println(this);
            System.out.println("El depósito de combustible está lleno. No se puede repostar.");
        }
    }

    @Override
    public String toString(){
        String cad = "Modelo: " + modelo + "\nCapacidad de pasajeros: " + capacidadPasajeros +
                "\nCombustible restante: " + combustible +
                " unidades\nCapacidad total del depósito: " + combustibleMax + " unidades";
        return cad;
    }
}
