import java.util.Arrays;

public abstract class Instrumento {
    protected Nota[] melodia;//tabla que almacena las notas a interpretar

    public Instrumento() {
        melodia = new Nota[0]; //creamos la tabla
    }

    //Usa el algoritmo de inserción no ordenada
    void add(Nota n){
        melodia = Arrays.copyOf(melodia, melodia.length + 1);
        melodia[melodia.length - 1] = n;
    }
    abstract void interpretar();//a implementar en cada subclase
}

