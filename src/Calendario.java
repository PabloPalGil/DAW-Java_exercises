public class Calendario {
    /*
    Diseña la clase Calendario que representa una fecha concreta (año,mes y día). La clase debe disponer de los métodos:

    Calendario(int año, int mes, int dia): crea un objeto con los datos pasados como parámetros, siempre y cuando,
    la fecha que representen sea correcta
    void incrementarDia(): incrementa en un día la fecha del calendario
    void incrementarMes(): incrementa en un mes la fecha del calendario
    void incrementarAño(): incrementa la fecha del calendario en el número de años especificados. Ten en cuenta que
    el año 0 no existió.
    void mostrar(): muestra la fecha por consola
    boolean iguales(Calendario otraFecha): determina si la fecha invocante y la que se pasa como parámetro son iguales
    o distintas

Por simplicidad, solo tendremos en consideración que existen meses con distintos número de días, pero no tendremos en
cuenta los años bisiestos

Además de la clase, crea un programa que cree la clase y ejecute los métodos para comprobar que la Clase es correcta.
     */

    byte dia;
    byte mes;
    int año;

    public Calendario(int dia, int mes, int año){
        boolean datosValidos = false;
        switch (mes){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if(dia > 0 && dia <= 31 && año != 0){
                    datosValidos = true;
                }
            }
            case 4, 6, 9, 11 -> {
                if(dia > 0 && dia <=30 && año != 0){
                    datosValidos = true;
                }
            }
            case 2 -> {
                if(dia > 0 && dia <= 28 && año != 0){
                    datosValidos = true;
                }
            }
        }

        if(datosValidos){
            this.dia = (byte) dia;
            this.mes = (byte) mes;
            this.año = año;
        }
        else{
            System.out.println("¡Fecha incorrecta!");
        }
    }

    public void incrementarDia(){
        dia++;
        if(dia == 32){
            dia = 1;
            mes++;
            if(mes == 13){
                mes = 1;
                año++;
                if(año == 0){
                    año = 1;
                }
            }
        }
        else if(dia == 31){
            switch (mes) {
                case 4, 6, 9, 11 -> {
                    dia = 1;
                    mes++;
                }
            }
        }
        else if(dia == 29 && mes == 2){
            dia = 1;
            mes++;
        }
    }

    public void incrementarMes(){
        //Al incrementar el mes mantendremos el día actual, pero si el día del mes actual supera a los días del mes
        //siguiente, pondremos el día al último día disponible del mes.
        mes++;
        if(mes == 13){//Comprobamos cambio de año
            mes = 1;
            año++;
            if(año == 0){
                año = 1;
            }
        }
        if(dia == 31){//Comprobamos que el mes siguiente no tenga menos días que el actual (de 31 a 30)
            if(mes != 8 && mes != 1){//De julio a agosto y de diciembre a enero no tenemos problema
                dia = 30;
            }
        }
        //Comprobamos el caso de febrero
        if(dia == 29 || dia == 30 && mes == 2){
            dia = 28;//Como no consideramos años bisiestos, febrero tiene 28 días
        }
    }

    public void incrementarAño(int años){
        if(this.año < 0 && años >= Math.abs(this.año)){//Si llegamos al año 0, pasamos al año 1
            this.año += años + 1;
        }
        else{
            this.año += años;
        }
    }

    public void mostrar(){
        System.out.println(dia + "/" + mes + "/" + año);
    }

    public boolean iguales(Calendario fecha){
        boolean resultado = false;
        if(fecha.dia == this.dia && fecha.mes == this.mes && fecha.año == this.año){
            resultado = true;
        }
        return resultado;
    }
}
