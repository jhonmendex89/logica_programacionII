package Parcial.vehiculo;

public class Moto extends Vehiculo {

    public Moto(int pasajeros, double velocidad, int peso){
       super(pasajeros, velocidad);
        if (pasajeros > 2) {
            throw new IllegalArgumentException("Una moto no puede tener más de 2 pasajeros.");
        }
    }

        @Override
        public void pintar(int posicion) {
            espacios(posicion + 2);
            System.out.println(" __o");
            espacios(posicion + 1);
            System.out.println(" _'\\<,_");
            espacios(posicion);
            System.out.println("(*)/(*)");
        }
    
}
