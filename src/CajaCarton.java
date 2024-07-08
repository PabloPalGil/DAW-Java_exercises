public class CajaCarton extends Caja {

    static double supTotal;
    double superficie;
    public CajaCarton(int ancho, int alto, int fondo){
        //Definimos el constructor de CajaCarton referenciando al constructor de su superclase Caja
        super(ancho, alto, fondo, Unidad.cm);
        this.ud = Unidad.cm;
        superficie = ((super.ANCHO + super.FONDO) * super.ALTO + super.ANCHO * super.FONDO) * 2;
        supTotal += superficie;
    }

    @Override
    double getVolumen(){
        return super.getVolumen() * 0.8d;
    }

    @Override
    public String toString(){
        String cad;
        cad = "Caja de " + ANCHO + " x " + ALTO + " x " + FONDO + " " + ud + " (ancho x alto x fondo)" + ", "
                + getVolumen() + " m3 y una superficie de " + superficie + " cm2\n- Etiqueta: " + etiq
                + "\nSuperficie de cartón total: " + supTotal + " cm2";
        return cad;
    }
}
