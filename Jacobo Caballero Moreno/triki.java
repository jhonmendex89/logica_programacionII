import java.util.Scanner;

public class triki {
    static String tablero[][];
    static Scanner entrada = new Scanner(System.in);

    public static void asignarTablero(String[][] tablero) {
        for (int fila = 0; fila <= 2; fila++) {
            for (int columna = 0; columna <= 2; columna++) {
                tablero[fila][columna] = "_";
            }
        }
    }

    public static void imprimirTablero() {
        System.out.println("------Tablero------");
        for (int fila = 0; fila <= 2; fila++) {
            for (int columna = 0; columna <= 2; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println("");
        }
    }

    public static void jugadaPersona() {
        String[] jugada;
        int fila, columna;
        boolean valido = false;

        System.out.println("-------Jugada persona------");

        while (!valido) {
            System.out.println("Ingrese su jugada (fila y columna separadas por espacio): ");
            jugada = entrada.nextLine().split(" ");
            fila = Integer.parseInt(jugada[0]);
            columna = Integer.parseInt(jugada[1]);

            if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
                if (tablero[fila][columna].equals("_")) {
                    tablero[fila][columna] = "X";
                    valido = true;
                } else {
                    System.out.println("Casilla ocupada, elija otra.");
                }
            } else {
                System.out.println("Posición inválida, debe estar entre 0 y 2.");
            }
        }
        imprimirTablero();
    }

    public static void jugadaMaquina() {
        System.out.println("-------Jugada maquina------");
        int fila, columna;

        do {
            fila = (int)(Math.random() * 3); 
            columna = (int)(Math.random() * 3);
        } while (!tablero[fila][columna].equals("_"));

        tablero[fila][columna] = "O";
        imprimirTablero();
    }

    public static String ganador() {
        // revisar filas
        for (int i = 0; i <= 2; i++) {
            if (!tablero[i][0].equals("_") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0];
            }
        }
        // revisar columnas
        for (int i = 0; i <= 2; i++) {
            if (!tablero[0][i].equals("_") && tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i])) {
                return tablero[0][i];
            }
        }
        // revisar diagonales
        if (!tablero[0][0].equals("_") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0];
        }
        if (!tablero[0][2].equals("_") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2];
        }
        return "_"; // no hay ganador todavía
    }

    public static boolean empate() {
        for (int fila = 0; fila <= 2; fila++) {
            for (int columna = 0; columna <= 2; columna++) {
                if (tablero[fila][columna].equals("_")) {
                    return false; // aún hay espacios
                }
            }
        }
        return true; // tablero lleno
    }

    public static void menu() {
        boolean continuar = true;

        while (continuar) {
            jugadaPersona();
            if (!ganador().equals("_")) {
                System.out.println("¡Ganó el jugador con " + ganador() + "!");
                continuar = false;
                break;
            }
            if (empate()) {
                System.out.println("¡Empate!");
                continuar = false;
                break;
            }

            jugadaMaquina();
            if (!ganador().equals("_")) {
                System.out.println("¡Ganó el jugador con " + ganador() + "!");
                continuar = false;
                break;
            }
            if (empate()) {
                System.out.println("¡Empate!");
                continuar = false;
                break;
            }
        }

        System.out.println("¿Desea jugar otra partida? (s/n)");
        String respuesta = entrada.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            tablero = new String[3][3];
            asignarTablero(tablero);
            imprimirTablero();
            menu();
        } else {
            System.out.println("Gracias por jugar Triki!");
        }
    }

    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL JUEGO DE TRIKI---");
        tablero = new String[3][3];
        asignarTablero(tablero);
        imprimirTablero();
        menu();
    }
}
