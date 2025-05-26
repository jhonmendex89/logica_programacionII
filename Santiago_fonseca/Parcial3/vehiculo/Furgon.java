package Parcial.vehiculo;

public class Furgon extends Carga {

    public Furgon(int pasajeros, double velocidad, int peso) {
        super(pasajeros, velocidad, peso);
    }

    public void pintar(int posicion) {
        espacios(posicion);
        System.out.println(" _____");
        espacios(posicion);
        System.out.println("|     |__");
        String laCarga = "|" + this.carga.toString();
        int n = 6 - laCarga.length();
        for (int i = 0; i < n; i++) {
            laCarga += '_';
        }
        espacios(posicion);
        System.out.println(laCarga + "|__\\___");
        espacios(posicion);
        System.out.println("|_   ___   __|");
        espacios(posicion);
        System.out.println("   O     O");
    }
}
