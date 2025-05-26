package Reto_uno;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Juguete> juguetes;

    public Inventario() {
        juguetes = new ArrayList<>();
    }

    public void agregarJuguete(Juguete j) {
        juguetes.add(j);
    }

    public void listarJuguetes() {
        System.out.println("***Inventario de juguetes***");
        for (Juguete j : juguetes) {
            System.out.println(j.toString());
        }
    }

    public void procesarComandos() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String comando = sc.nextLine();

            if (comando.equals("2")) {
                listarJuguetes();
            } else if (comando.equals("3")) {
                break;
            } else {
                String[] partes = comando.split("/");

                if (partes.length >= 2 && partes[0].equals("1")) {
                    if (partes[1].equalsIgnoreCase("Electronico") && partes.length == 7) {
                        String nombre = partes[2];
                        int piezas = Integer.parseInt(partes[3]);
                        int edad = Integer.parseInt(partes[4]);
                        int baterias = Integer.parseInt(partes[5]);
                        int vida = Integer.parseInt(partes[6]);

                        Electronico e = new Electronico(nombre, piezas, edad, baterias, vida);
                        agregarJuguete(e);

                    } else if (partes[1].equalsIgnoreCase("Mecanico") && partes.length == 6) {
                        String nombre = partes[2];
                        int piezas = Integer.parseInt(partes[3]);
                        int edad = Integer.parseInt(partes[4]);
                        String color = partes[5];

                        Mecanico m = new Mecanico(nombre, piezas, edad, color);
                        agregarJuguete(m);
                    }
                }
            }
        }

        sc.close();
    }

    public static void main(String[] args) {
        Inventario inv = new Inventario();
        inv.procesarComandos();
    }
}
