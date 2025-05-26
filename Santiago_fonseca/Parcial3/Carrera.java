package Parcial;


import Parcial.vehiculo.Automovil;
import Parcial.vehiculo.Deportivo;
import Parcial.vehiculo.Furgon;
import Parcial.vehiculo.Moto;
import Parcial.vehiculo.Patineta;
import Parcial.vehiculo.Platon;
import Parcial.vehiculo.Vehiculo;

public class Carrera {

    public static void pausar() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { 
        Automovil automovil = new Automovil(5, 1);
        //automovil.pintar(5);
        Deportivo deportivo = new Deportivo(5, 1.5);
        //deportivo.pintar(3);
        Platon camioneta = new Platon(3, 1.2, 4);
        camioneta.llevar(1234);
        //camioneta.pintar(1);
        Furgon furgon = new Furgon(3, 0.9, 4);
        furgon.llevar("AA");

        Moto Moto = new Moto(0, 1.2, 3); ////
        Patineta patineta = new Patineta(1,1);

        Vehiculo[] vehiculo = new Vehiculo[6]; ///
        vehiculo[0] = automovil;
        vehiculo[1] = camioneta;
        vehiculo[2] = deportivo;
        vehiculo[3] = furgon;
        vehiculo[4] = Moto; ////
        vehiculo[5] = patineta; ////

        for (int i = 0; i < 50; i++) {
            System.out.println();
            for (int j = 0; j < vehiculo.length; j++) {
                int pos = vehiculo[j].posicion(i);
                vehiculo[j].pintar(pos);
            }
            pausar();
            System.out.print("=====================================================================================");
        }
    }
    
 

}


// modificado por jacobo caballero y santiago fonseca :)