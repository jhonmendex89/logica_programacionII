package Reto_uno;
public class Mecanico extends Juguete {
    private String color;

    public Mecanico(String nombre, int numeroPiezas, int edadPermitida, String color) {
        super(nombre, numeroPiezas, edadPermitida);
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n Juguete Mecanico - Nombre:" + nombre +
               "\n piezas:" + numeroPiezas +
               "\n edad:" + edadPermitida + 
               "\n color:" + color;
    }
}
