package Reto_dos;

public class Viaje extends Maleta {
    private int vidaUtil;

    public Viaje(String nombre, int capacidad, int numeroBolsillos, int vidaUtil) {
        super(nombre, capacidad, numeroBolsillos);
        this.vidaUtil = vidaUtil;
    }
    @Override
    public String toString() {
        return "Viaje nombre = " + nombre + "\n capacidad :" + capacidad + 
                "\n numeroBolsillos : " + numeroBolsillos
                + "\n vida Util : " + vidaUtil;
    }

    
}
