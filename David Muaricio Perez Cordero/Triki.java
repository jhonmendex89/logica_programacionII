import java.util.Random;
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
    
    public static void asignarTablero(String [][] tablero){
       // System.out.println("------tablero-------"); 
        for (int fila = 0; fila <= 2; fila++){
            for (int columna = 0; columna <= 2; columna++){
                tablero[fila][columna] = "_";
            }
         //   System.out.println("");
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

    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("_")) {
                    return false; // Encontró una casilla vacía, no está lleno
                }
            }
        }
        return true; // No encontró casillas vacías, está lleno
    }

public static void jugadaPersona(){
    String[] jugada;
    System.out.println("------- Turno Player (X) ------");
     // Bucle para asegurar que la entrada sea válida y la casilla esté libre
    while(true) {
        System.out.println("Ingrese su jugada (fila columna), ej: 0 1 ");
         jugada = entrada.nextLine().split(" "); //ej 0 0 ->string
        try {
            int fila = Integer.parseInt(jugada[0]);
            int columna = Integer.parseInt(jugada[1]);

             // Validar que la entrada esté dentro del tablero
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
                 // Validar que la casilla esté vacía
                if (tablero[fila][columna].equals("_")) {
                    tablero[fila][columna] = "X";
                    imprimirTablero();
                     break; // Salir del bucle si la jugada es válida
                } else {
                    System.out.println("Error: La casilla [" + fila + "][" + columna + "] ya está ocupada. Intente de nuevo.");
                }
            } else {
                System.out.println("Error: Coordenadas fuera del tablero (deben ser entre 0 y 2). Intente de nuevo.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Entrada inválida. Asegúrese de ingresar dos números separados por espacio. Intente de nuevo.");
        }
    }
}

public static void jugadaMaquina(){
    Random random = new Random();
    int fila, columna;
    System.out.println("\n------- Turno Máquina (O) ------");

    // Asegura que haya casillas disponibles para evitar bucle infinito si el tablero está lleno
    if (!tableroLleno()) { 
        while(true) { // Bucle para seguir intentando hasta encontrar una casilla vacía
            // 1. Elige coordenadas aleatorias
            fila = random.nextInt(3); 
            columna = random.nextInt(3); 

            // 2. VERIFICA si la casilla elegida está VACÍA ("_")
            if (tablero[fila][columna].equals("_")) { 
                // 3. Si está vacía, coloca la 'O' y sale del bucle
                System.out.println("La máquina elige: " + fila + " " + columna);
                tablero[fila][columna] = "O"; 
                break; // ¡IMPORTANTE! Sale del while porque encontró una casilla válida
            }
            // 4. Si la casilla NO está vacía (contiene "X" o "O"), 
            //    el 'if' es falso, no se ejecuta el 'break', 
            //    y el bucle 'while(true)' vuelve a empezar, 
            //    generando NUEVAS coordenadas aleatorias.
        }
    } else {
         System.out.println("La máquina no puede jugar (tablero lleno)."); // Mensaje por si acaso
    }
    imprimirTablero();
}
    /**
     * Verifica si hay un ganador en el tablero actual.
     * Comprueba explícitamente todas las filas, columnas y diagonales.
     * @return "X" si X gana, "O" si O gana, "_" si no hay ganador aún.
     */
    public static String verificarGanador_Explicito() {
        // Verificar Filas
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("_") && tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0]; // Retorna "X" o "O"
            }
        }

        // Verificar Columnas
        for (int j = 0; j < 3; j++) {
            if (!tablero[0][j].equals("_") && tablero[0][j].equals(tablero[1][j]) && tablero[1][j].equals(tablero[2][j])) {
                return tablero[0][j]; // Retorna "X" o "O"
            }
        }

        // Verificar Diagonal Principal (arriba-izquierda a abajo-derecha)
        if (!tablero[0][0].equals("_") && tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0]; // Retorna "X" o "O"
        }

        // Verificar Diagonal Secundaria (arriba-derecha a abajo-izquierda)
        if (!tablero[0][2].equals("_") && tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2]; // Retorna "X" o "O"
        }

        // Si ninguna de las condiciones anteriores se cumplió, no hay ganador todavía.
        return "_";
    }

    public void menu(){
        System.out.println("menu");
    }


    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL JUEGO DE TRIKI---");
        boolean jugarDeNuevo = true; // Variable para controlar si se juega otra partida

        // Bucle principal para permitir jugar múltiples partidas
        while(jugarDeNuevo) {

            // 1. Inicialización de la partida
            tablero = new String[3][3];
            asignarTablero(tablero);
            imprimirTablero();
            String ganador = "_"; // Guarda quién ganó ("X", "O") o "_" si nadie ha ganado
            boolean turnoPersona = true; // true: turno de la persona, false: turno de la máquina. Empieza la persona.

            // 2. Bucle del juego (mientras no haya ganador Y el tablero no esté lleno)
            while (ganador.equals("_") && !tableroLleno()) {

                // 3. Determinar y ejecutar el turno
                if (turnoPersona) {
                    jugadaPersona(); // Llama a la función para la jugada de la persona
                } else {
                    jugadaMaquina(); // Llama a la función para la jugada de la máquina
                }

                // 4. Verificar si la última jugada resultó en un ganador
                ganador = verificarGanador_Explicito(); // Revisa si hay 3 en línea

                // 5. Cambiar el turno para la siguiente iteración (si el juego continúa)
                //    Solo cambiamos de turno si todavía no hay ganador y el tablero no está lleno
                if (ganador.equals("_") && !tableroLleno()) {
                     turnoPersona = !turnoPersona; // Invierte el valor (true -> false, false -> true)
                }
                // El bucle while se encargará de verificar las condiciones de nuevo
            } // Fin del bucle del juego (while)

            // 6. Mostrar el resultado de la partida
            imprimirTablero(); // Muestra el tablero final
            if (!ganador.equals("_")) {
                System.out.println("*********************************");
                System.out.println("¡¡¡ El ganador es: " + ganador + " !!!");
                System.out.println("*********************************");
            } else if (tableroLleno()) { // Si salió del bucle porque se llenó el tablero
                System.out.println("*********************************");
                System.out.println("¡¡¡ Es un EMPATE !!!");
                System.out.println("*********************************");
            }

            // 7. Preguntar si quiere jugar de nuevo
            System.out.println("\n¿Jugar otra partida? (s/n)");
            String respuesta = entrada.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                jugarDeNuevo = false; // Si la respuesta no es "s", termina el bucle exterior
            }

        } // Fin del bucle para jugar de nuevo (while jugarDeNuevo)

        System.out.println("\n¡Gracias por jugar! ¡Hasta pronto!");
        entrada.close(); // Es buena práctica cerrar el Scanner al final del programa
    }
}