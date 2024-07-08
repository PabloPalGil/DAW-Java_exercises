import java.util.Scanner;

public class Caja {
    /*
    Las empresas de transporte, para evitar daños en los paquetes, embalan todas sus mercancías en cajas con el
    tamaño adecuado. Una caja se crea expresamente con un ancho, un alto y un fondo y, una vez creada, se mantiene
    inmutable. Cada caja lleva pegada una etiqueta, de un máximo de 30 caracteres, con información útil como el
    nombre del destinatario, dirección, etc. Implementa la clase Caja con los siguientes métodos:
    - Caja(int ancho, int alto, int fondo, Unidad unidad): que construye una caja con las dimensiones especificadas,
    que pueden encontrarse en "cm" (centímetros) o "m" (metros).
    - double getVolumen(): que devuelve el volumen de la caja en metros cúbicos.
    - void setEtiqueta(String etiqueta): que modifica el valor de la etiqueta de la caja.
    - String toString(): que devuelve una cadena con la representación de la caja.
     */

    //Como las medidas de una caja son inmutables, haremos que sean de tipo final (valores constantes)
    final int ANCHO, ALTO, FONDO;
    enum Unidad{cm, m}
    protected Unidad ud;
    protected String etiq = "";
    Caja(int ancho, int alto, int fondo, Unidad unidad){
        ANCHO = ancho;
        ALTO = alto;
        FONDO = fondo;
        ud = unidad;
    }

    double getVolumen(){
        double vol = ANCHO * ALTO * FONDO;
        if(ud == Unidad.cm){
            vol *=  0.000001;//Coeficiente de conversión de cm3 a m3
        }

        return vol;
    }

    void setEtiqueta(String etiqueta){
        if(etiqueta.length() > 30){
            etiqueta = etiqueta.substring(0, 30);
        }
        etiq = etiqueta;

    }

    @Override
    public String toString(){
        String cad;
        cad = "Caja de " + ANCHO + " x " + ALTO + " x " + FONDO + " " + ud + " (ancho x alto x fondo)" + ", "
                + getVolumen() + " m3\n- Etiqueta: " + etiq;
        return cad;
    }

    /*
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Caja c = new Caja(100, 100, 100, Unidad.cm);
        c.setEtiqueta("CAJA Unitaria");
        System.out.println(c);
    }
     */
}
