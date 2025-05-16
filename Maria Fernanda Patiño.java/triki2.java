import java.util.Scanner;
import java.util.Random;

public class triki2 {
    static String tablero[][];
    static Scanner entrada = new Scanner(System.in);
    
    // Función para pausar el juego hasta que el usuario presione Enter
    public static void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        entrada.nextLine();
    }
    
    // Función para asignar el tablero inicial
    // Se inicializa el tablero con "_" en todas las posiciones
    // "_" representa una casilla vacía
    // Se utiliza un bucle anidado para recorrer todas las filas y columnas del tablero
    // y asignar el valor "_" a cada posición
    // Se utiliza un bucle for para recorrer las filas y otro bucle for para recorrer las columnas
    public static void asignarTablero(String[][] tablero) {
        for (int fila = 0; fila <= 2; fila++) {
            for (int columna = 0; columna <= 2; columna++) {
                tablero[fila][columna] = "_";
            }
        }
    }

    // Función para mostrar el tablero en la consola
    // Se utiliza un bucle anidado para recorrer todas las filas y columnas del tablero 
    // y mostrar el contenido de cada posición

    public static void mostrarTablero() {
        System.out.println(); // Línea vacía al inicio
        
        for (int fila = 0; fila < 3; fila++) {
            System.out.print("           "); // 11 espacios
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }
    
    // Función para verificar si el tablero está lleno
    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }


    // Función para realizar la jugada del jugador (persona)
    // Se solicita al usuario que ingrese su jugada en formato "fila columna"
    // Se valida la entrada y se verifica si la casilla está ocupada o fuera de rango
    // Si la jugada es válida, se asigna "X" a la posición correspondiente en el tablero
    // y se muestra el tablero actualizado
    // Si la jugada no es válida, se muestra un mensaje de error y se solicita nuevamente
    public static void jugadaPersona() {
        String[] jugada;
        System.out.println("------- Turno Player (X) ------");
        while(true) {
            System.out.println("Ingrese su jugada (fila columna), ej: 0 1 ");
            jugada = entrada.nextLine().split(" ");
            try {
                int fila = Integer.parseInt(jugada[0]);
                int columna = Integer.parseInt(jugada[1]);

                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
                    if (tablero[fila][columna].equals("_")) {
                        tablero[fila][columna] = "X";
                        mostrarTablero();
                        break;
                    } else {
                        System.out.println("Error: La casilla [" + fila + "][" + columna + "] ya está ocupada. Intente de nuevo.");
                    }
                } else {
                    System.out.println("Error: Coordenadas fuera del tablero (deben ser entre 0 y 2). Intente de nuevo.");
                }
                // Código para manejar la excepcións de formato y rango
                // Se captura NumberFormatException para entradas no numéricas
                // Se captura ArrayIndexOutOfBoundsException para entradas con menos de 2 números
                // Se muestra un mensaje de error y se solicita nuevamente la entrada
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Entrada inválida. Asegúrese de ingresar dos números separados por espacio. Intente de nuevo.");
            }
        }
    }
    // Función para realizar la jugada de la máquina 
    // Se utiliza un objeto Random para generar la jugada aleatoria
    public static void jugadaMaquina() {
        Random random = new Random();
        int fila, columna;
        System.out.println("\n------- Turno Máquina (O) ------");

        if (!tableroLleno()) { 
            while(true) {
                fila = random.nextInt(3); 
                columna = random.nextInt(3); 

                if (tablero[fila][columna].equals("_")) { 
                    System.out.println("La máquina elige: " + fila + " " + columna);
                    tablero[fila][columna] = "O"; 
                    break;
                }
            }
        } else {
            System.out.println("La máquina no puede jugar (tablero lleno).");
        }
        mostrarTablero();
    }

    // Función para verificar el ganador del juego
    // Se verifica si hay un ganador en filas, columnas o diagonales
    // Si hay un ganador, se retorna el símbolo del ganador ("X" o "O")
    // Si no hay ganador, se retorna "_"
    public static String verificarGanador_Explicito() {
        // Verificar Filas
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("_") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0];
            }
        }

        // Verificar Columnas
        for (int j = 0; j < 3; j++) {
            if (!tablero[0][j].equals("_") && tablero[0][j].equals(tablero[1][j]) && tablero[1][j].equals(tablero[2][j])) {
                return tablero[0][j];
            }
        }

        // Verificar Diagonal Principal
        if (!tablero[0][0].equals("_") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0];
        }

        // Verificar Diagonal Secundaria
        if (!tablero[0][2].equals("_") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2];
        }

        return "_";
    }

    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL JUEGO DE TRIKI---");
        
        
        boolean jugarDeNuevo = true;
       // Se inicializa la variable jugarDeNuevo como true para permitir jugar varias partidas
        // Se utiliza un bucle while para permitir jugar varias partidas
        while(jugarDeNuevo) {
            tablero = new String[3][3];
            asignarTablero(tablero);
            mostrarTablero();
            String ganador = "_";
            boolean turnoPersona = true;
// Se inicializa la variable turnoPersona como true para que el jugador inicie primero
            // Se utiliza un bucle while para alternar turnos entre el jugador y la máquina
            while (ganador.equals("_") && !tableroLleno()) {
                if (turnoPersona) {
                    jugadaPersona();
                    pausa();
                } else {
                    jugadaMaquina();
                    pausa();
                }

                ganador = verificarGanador_Explicito();

                if (ganador.equals("_") && !tableroLleno()) {
                    turnoPersona = !turnoPersona;
                }
            }

            mostrarTablero();
            if (!ganador.equals("_")) {
                System.out.println("*********************************");
                if (ganador.equals("X")) {
                    System.out.println("¡¡¡ Felicidades, GANASTE !!!");
                } else {
                    System.out.println("¡¡¡ PERDISTE ! La máquina ganó esta vez. !!!");
                }
                System.out.println("*********************************");
            } else if (tableroLleno()) {
                System.out.println("*********************************");
                System.out.println("¡¡¡ Es un EMPATE !!!");
                System.out.println("*********************************");
            }
            pausa();

            System.out.println("\n¿Jugar otra partida? (s/n)");
            String respuesta = entrada.nextLine().trim().toLowerCase(); // Se utiliza trim() para eliminar espacios en blanco al inicio y al final de la respuesta
            // Se convierte la respuesta a minúsculas para evitar problemas de mayúsculas/minúsculas
            // Se compara la respuesta con "s" para determinar si se desea jugar de nuevo
            // Si la respuesta no es "s", se cambia la variable jugarDeNuevo a false para salir del bucle
            if (!respuesta.equals("s")) {
                jugarDeNuevo = false;
            }
        }

        System.out.println("\n¡Gracias por jugar! ¡Hasta pronto!");
        entrada.close();
    }
}