package Reto_uno;
public class Electronico extends Juguete {
    private int cantidadBaterias;
    private int vidaUtil;

    public Electronico(String nombre, int numeroPiezas, int edadPermitida, int cantidadBaterias, int vidaUtil) {
        super(nombre, numeroPiezas, edadPermitida);
        this.cantidadBaterias = cantidadBaterias;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String toString() {
        return "\n Juguete Electronico - Nombre:" + nombre + 
               "\n piezas:" + numeroPiezas + 
               "\n edad:" + edadPermitida + 
               "\n baterias:" + cantidadBaterias +
               "\n Vida útil:" + vidaUtil;
    }
}
