import java.sql.Date;

public class EmpleadoT14 {
    private final int TAM_NOMBRE = 30;//variable nombre es VARCHAR(30)
    private final int TAM_PUESTO = 30;//variable puesto es VARCHAR(30)
    private int numemp;
    private String nombre;
    private int edad;
    private int oficina;
    private String puesto;
    private java.util.Date contrato;//La fecha del contrato es de tipo java.util.Date en el objeto EmpleadoT14

    //Constructor que crea un objeto Empleado:
    public EmpleadoT14(int numemp, String nombre, int edad, int oficina, String puesto, java.util.Date contrato) {
        this.numemp = numemp;
        this.nombre = nombre;
        this.edad = edad;
        this.oficina = oficina;
        this.puesto = puesto;
        this.contrato = contrato;
    }

    //Getters y setters:
    public int getNumemp() {
        return numemp;
    }
    public void setNumemp(int numemp) {
        this.numemp = numemp;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        //Limitamos a 30 caracteres
        this.nombre = nombre.substring(0, Math.min(TAM_NOMBRE, nombre.length()));
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getOficina() {
        return oficina;
    }
    public void setOficina(int oficina) {
        this.oficina = oficina;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        //Limitamos a 30 caracteres
        this.puesto = puesto.substring(0, Math.min(TAM_PUESTO, puesto.length()));
    }
    public java.util.Date getContrato() {
        return contrato;
    }
    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }

    //toString
    @Override
    public String toString(){
        return "Empleado{numemp = " + numemp + ", nombre = " + nombre + ", edad = " + edad +
                ", oficina = " + oficina + ", puesto = " + puesto + ", contrato = " + contrato + '}';
    }

}
