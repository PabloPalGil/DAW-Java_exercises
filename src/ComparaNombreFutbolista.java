import java.util.Comparator;
public class ComparaNombreFutbolista implements Comparator {
    @Override
    public int compare(Object ob1, Object ob2){
        return ((Futbolista)ob1).nombre.compareTo(((Futbolista)ob2).nombre);
        //se invoca compareTo() de la clase String
    }
}
