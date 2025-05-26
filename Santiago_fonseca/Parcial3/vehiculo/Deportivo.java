package Parcial.vehiculo;

public class Deportivo extends Vehiculo {

    public Deportivo(int pasajeros, double velocidad) {
        super(pasajeros, velocidad);
    }

    public void pintar(int posicion) {
        espacios(posicion + 1);
        System.out.println("________");
        espacios(posicion);
        System.out.println("/_|__|___\\___");
        espacios(posicion);
        System.out.println("|_  _____  __|");
        espacios(posicion);
        System.out.println("   0      0");
    }
}
