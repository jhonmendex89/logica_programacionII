package Parcial.vehiculo;
public class Patineta extends Vehiculo {

    public Patineta(int pasajeros,double velocidad){
        super(pasajeros, velocidad);
        if (pasajeros > 1) {
            throw new IllegalArgumentException("Una patineta no puede tener más de 1 pasajero.");
        }
    }

    @Override
    public void pintar(int posicion) {
        espacios(posicion + 2);
        System.out.println(" __o");
        espacios(posicion + 1);
        System.out.println("   /|\\");
        espacios(posicion + 1);
        System.out.println("  /  \\");
        espacios(posicion);
        System.out.println("===o===="); 
    }
   
}
