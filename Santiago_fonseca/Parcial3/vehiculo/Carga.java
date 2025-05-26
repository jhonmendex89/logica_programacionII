package Parcial.vehiculo;

public class Carga extends Vehiculo {

    /**
     * Load capability
     */
    protected int capacidad;
    /**
     * Carrying object
     */
    protected Object carga;

    /**
     * Creates a carrying vehicle with the given number of passengers, speed and
     * load capability
     *
     * @param pasajeros Number of passengers
     * @param velocidad Speed of the Vehicle
     * @param peso Load capability
     */
    public Carga(int pasajeros, double velocidad, int peso) {
        super(pasajeros, velocidad);
        this.capacidad = peso > 5 ? 5 : peso;
        this.carga = "___";
    }

    /**
     * Paints the vehicle at the given position
     *
     * @param posicion Position used to print the vehicle
     */
    @Override
    public void pintar(int posicion) {
    }

    /**
     * Carries the given number, if possible
     *
     * @param p Number to carry
     * @return <i>true</i> If the number can be carried, <i>false</i> otherwise
     */
    public boolean llevar(int p) {
        int k = 1;
        for (int i = 0; i < this.capacidad; i++) {
            k *= 10;
        }
        if (p < k) {
            this.carga = p;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Carries the given string, if possible
     *
     * @param p Number to carry
     * @return <i>true</i> If the string can be carried, <i>false</i> otherwise
     */
    public boolean llevar(String p) {
        if (p.length() <= this.capacidad) {
            this.carga = p;
            return true;
        } else {
            return false;
        }
    }
}
