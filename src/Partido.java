public class Partido {

    public String simularPartido(Equipo local, Equipo visitante){
        int golesLocal = 0;
        int golesVisitante = 0;
        //int[] resultado = new int[2];

        golesLocal = (int) ((Math.random() + local.fuerza/100) * 6);
        golesVisitante = (int) ((Math.random() + visitante.fuerza/100) * 6);

        //resultado[0] = golesLocal;
        //resultado[1] = golesVisitante;

        String resultado = "Resultado del partido:\n" +
                local.nombre + " " + golesLocal + " - " + golesVisitante + " " + visitante.nombre;

        System.out.println(resultado);

        return resultado;
    }

}
