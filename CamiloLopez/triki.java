import java.util.Scanner;
import java.util.Random;

public class triki {
    static String[][] tablero = new String[3][3];
    static Scanner entrada = new Scanner(System.in);
    static Random rand = new Random();

    public static void asignarTablero() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = "_";
    }

    public static void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(tablero[i][j] + " ");
            System.out.println();
        }
    }

    public static void jugadaPersona() {
        int fila, col;
        while (true) {
            System.out.print("Tu jugada (fila columna): ");
            fila = entrada.nextInt();
            col = entrada.nextInt();
            if (fila >= 0 && fila < 3 && col >= 0 && col < 3 && tablero[fila][col].equals("_")) {
                tablero[fila][col] = "X";
                break;
            } else {
                System.out.println("Posición inválida, intenta otra vez.");
            }
        }
    }

    public static void jugadaMaquina() {
        int fila, col;
        do {
            fila = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!tablero[fila][col].equals("_"));
        System.out.println("La máquina jugó en: " + fila + " " + col);
        tablero[fila][col] = "O";
    }

    public static String verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("_") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]))
                return tablero[i][0];
            if (!tablero[0][i].equals("_") && tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i]))
                return tablero[0][i];
        }
        if (!tablero[0][0].equals("_") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]))
            return tablero[0][0];
        if (!tablero[0][2].equals("_") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]))
            return tablero[0][2];
        return null;
    }

    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j].equals("_"))
                    return false;
        return true;
    }

    public static void jugar() {
        asignarTablero();
        imprimirTablero();
        while (true) {
            jugadaPersona();
            imprimirTablero();
            if (verificarGanador() != null) {
                System.out.println("¡Ganó " + verificarGanador() + "!");
                break;
            }
            if (tableroLleno()) {
                System.out.println("¡Empate!");
                break;
            }
            jugadaMaquina();
            imprimirTablero();
            if (verificarGanador() != null) {
                System.out.println("¡Ganó " + verificarGanador() + "!");
                break;
            }
            if (tableroLleno()) {
                System.out.println("¡Empate!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        String respuesta;
        do {
            System.out.println("--- JUEGO DE TRIKI ---");
            jugar();
            System.out.print("¿Jugar otra vez? (s/n): ");
            respuesta = entrada.next().toLowerCase();
        } while (respuesta.equals("s"));
        System.out.println("¡Gracias por jugar!");
    }
}


