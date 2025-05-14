package JhonMendez.VectoresMatrices;

import java.util.Scanner;

/*
 * 
 * JUEGO DE TRIKI
 * 1 DOS JUGADORES (PERSONA, MAQUINA)
 * 2 UN JUGADOR JUEGO CON UN ELEMENTO (X Ó O)
 * 3 REVISAR GANADOR (3 ELEMENTOS DEL MISMO TIPO EN LINEA, INCLUYENDO LAS DIAGONASLES)
 * 4 REVISAR EMPATE (SI NO HAY GANADOR Y TODOS LOS ELEMENTOS ESTAN LLENOS)
 * 5 DAR OPCION DE NUEVA PARTIDA
 * 6 DEFINIR FUNCIONES
 */
public class Triki {
    static String tablero [][];
    static Scanner entrada = new Scanner(System.in);

    public static void jugadaPersona(){
        String[] jugada;
        System.out.println("-------jugada persona------");
        System.out.println("Ingrese su jugada x y ");
        jugada = entrada.nextLine().split(" "); //ej 0 0 ->string
        System.out.println(jugada[0] + " " + jugada[1]);
        int fila = Integer.parseInt(jugada[0]);
        int columna = Integer.parseInt(jugada[1]);
        tablero[fila][columna] = "X";
        //imprimirTablero();
    }
    
    public static void asignarTablero(String [][] tablero){
        System.out.println("------tablero-------"); 
        for (int fila = 0; fila <= 2; fila++){
            for (int columna = 0; columna <= 2; columna++){
                tablero[fila][columna] = "_";
            }
            System.out.println("");
        }
    }

    public static  void imprimirTablero(){
        System.out.println("------tablero-------"); 
        for (int fila = 0; fila <= 2; fila++){
            for (int columna = 0; columna <= 2; columna++){
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println("");
        }
    }

    public void jugadaMaquina(){
        System.out.println("jugada maquina");
    }

    public void ganador(){
        System.out.println("ganador");
    }

    public void menu(){
        System.out.println("menu");
    }

    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL JUEGO DE TRIKI---");
        tablero = new String[3][3];
        asignarTablero(tablero);
        imprimirTablero();
        jugadaPersona();
    }
}
