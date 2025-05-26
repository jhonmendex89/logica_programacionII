package Reto_dos;

public abstract class Maleta {
    protected String nombre;
    protected int capacidad;
    protected int numeroBolsillos;

    public Maleta(String nombre, int capacidad, int numeroBolsillos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.numeroBolsillos = numeroBolsillos;
    }

    public abstract String toString();
    
}
