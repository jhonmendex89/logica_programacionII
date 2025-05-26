package Reto_uno;
public abstract class Juguete {
    protected String nombre;
    protected int numeroPiezas;
    protected int edadPermitida;

    public Juguete(String nombre, int numeroPiezas, int edadPermitida) {
        this.nombre = nombre;
        this.numeroPiezas = numeroPiezas;
        this.edadPermitida = edadPermitida;
    }

    public abstract String toString();
}

