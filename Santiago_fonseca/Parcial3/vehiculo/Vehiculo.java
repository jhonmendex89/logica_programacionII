package Parcial.vehiculo;

public abstract class Vehiculo {

    /**
     * Speed of the Vehicle
     */
    protected double velocidad;
    /**
     * Number of passengers
     */
    protected int pasajeros;

    /**
     * Creates a vehicle with the given number of passengers and speed
     *
     * @param pasajeros Number of passengers
     * @param velocidad Speed of the Vehicle
     */
    public Vehiculo(int pasajeros, double velocidad) {
        this.velocidad = velocidad;
        this.pasajeros = pasajeros;
    }

    /**
     * Determines the position of the vehicle at the given time
     *
     * @param tiempo Time
     * @return Position of the vehicle at the given time
     */
    public int posicion(int tiempo) {
        return (int) (tiempo * velocidad);
    }

    /**
     * Prints a collection of empty spaces (for simulating the position of the
     * vehicle)
     *
     * @param espacios Number of empty spaces to print
     */
    public void espacios(int espacios) {
        for (int i = 0; i < espacios; i++) {
            System.out.print(' ');
        }
    }

    /**
     * Paints the vehicle at the given position
     *
     * @param posicion Position used to print the vehicle
     */
    public abstract void pintar(int posicion);
}
