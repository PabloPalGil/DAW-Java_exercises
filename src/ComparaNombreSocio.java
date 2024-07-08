import java.util.Comparator;
public class ComparaNombreSocio implements Comparator {
    @Override
    public int compare(Object ob1, Object ob2){
        return ((Socio)ob1).nombre.compareTo(((Socio)ob2).nombre);
        //se invoca compareTo() de la clase String
    }
}
