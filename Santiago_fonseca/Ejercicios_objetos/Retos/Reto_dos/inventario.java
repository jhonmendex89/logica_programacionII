package Reto_dos;

import java.util.ArrayList;
import java.util.Scanner;

public class inventario {
    private ArrayList<Maleta> maletas = new ArrayList<>();

    public void agregarMaleta(Maleta maleta) {
        maletas.add(maleta);
    }
    
    public void mostarmaletas(){
        System.out.println("***Inventario de Maletas\n***");
        for (Maleta maleta : maletas) {
            System.out.println(maleta.toString() + "\n");
        }
    }

    public void procesarComandos(){
        boolean bandera = true;
        Scanner entradaTeclado = new Scanner(System.in);

        while(bandera){
            String linea = entradaTeclado.nextLine();
            if (linea.equals("3")) break;
            String[] componentes = linea.split("/");
            if (componentes[0].equals("1")) {
                if (componentes[1].equalsIgnoreCase("viaje")){
                    String nombre = componentes[2];
                    int capacidad = Integer.parseInt(componentes[3]);
                    int numeroBolsillos = Integer.parseInt(componentes[4]);
                    int vidaUtil = Integer.parseInt(componentes[5]);
                    agregarMaleta(new Viaje(nombre, capacidad, numeroBolsillos, vidaUtil));
                } else if (componentes[1].equalsIgnoreCase("trabajo")){
                    String nombre = componentes[2];
                    int capacidad = Integer.parseInt(componentes[3]);
                    int numeroBolsillos = Integer.parseInt(componentes[4]);
                    String color = componentes[5];
                    agregarMaleta(new Trabajo(nombre, capacidad, numeroBolsillos, color));
                }
            } else if (componentes[0].equals("2")) {
                mostarmaletas();
            }
        }
        entradaTeclado.close();
    }

    public static void main(String[] args) {
        inventario inventario = new inventario();
        inventario.procesarComandos();
    }
}