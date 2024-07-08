import java.sql.SQLOutput;

public class Campana extends Instrumento{
    public Campana(){
        super();//Constructor de la superclase Instrumento
    }
    @Override
    void interpretar() {
        //Recorreremos las notas y las interpretaremos de la forma específica de la campana
        for(Nota nota:melodia){
            switch (nota){
                case DO:
                    System.out.print("doooo ");
                    break;
                case RE:
                    System.out.print("reeee ");
                    break;
                case MI:
                    System.out.print("miiii ");
                    break;
                case FA:
                    System.out.print("faaaa ");
                    break;
                case SOL:
                    System.out.print("sooool ");
                    break;
                case LA:
                    System.out.print("laaaa ");
                    break;
                case SI:
                    System.out.print("siiii ");
                    break;
            }
        }
        System.out.println("");
    }
}
