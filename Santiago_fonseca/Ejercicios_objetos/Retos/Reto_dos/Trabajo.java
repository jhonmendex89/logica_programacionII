package Reto_dos;

public class Trabajo extends Maleta {
    private String color ;

    public Trabajo(String nombre, int capacidad, int numeroBolsillos, String color) {
        super(nombre, capacidad, numeroBolsillos);
        this.color = color;
    }
    @Override
    public String toString() {
        return "Trabajo nombre = " + nombre + "\n capacidad :" + capacidad + 
                "\n numeroBolsillos :" + numeroBolsillos
                + "\n color :" + color;
    }
}
