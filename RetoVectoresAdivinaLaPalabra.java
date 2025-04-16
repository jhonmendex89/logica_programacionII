import java.util.Scanner;

public class RetoVectoresAdivinaLaPalabra {
    /**
     * Juego de la palabra oculta
     * - Usuario 1 ingresa una palabra oculta
     * - Usuario 2 intenta adivinarla letra por letra
     * - Muestra progreso con letras adivinadas
     * - Número de intentos igual a la longitud de la palabra
     */
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // Solicitar palabra oculta al usuario 1
        System.out.println("Usuario 1 - Digite una palabra oculta:");
        String palabraIngreso = entrada.next().toLowerCase();
        char[] palabraOculta = palabraIngreso.toCharArray();
        char[] palabraAdivinada = new char[palabraOculta.length];
        boolean[] letrasAdivinadas = new boolean[palabraOculta.length];
        
        // Inicializar arrays
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
            letrasAdivinadas[i] = false;
        }
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Limpiar pantalla (simulado)
        System.out.println("Usuario 2 - Adivina la palabra oculta!");
        System.out.println("Tienes " + palabraOculta.length + " intentos.");
        
        int intentos = 0;
        boolean palabraCompleta = false;
        
        // Bucle principal del juego
        while (intentos < palabraOculta.length && !palabraCompleta) {
            System.out.println("\nIntento #" + (intentos + 1));
            mostrarProgreso(palabraAdivinada);
            
            System.out.println("Ingresa una letra:");
            char letra = entrada.next().toLowerCase().charAt(0);
            
            boolean letraAdivinada = false;
            
            // Verificar si la letra está en la palabra oculta
            for (int i = 0; i < palabraOculta.length; i++) {
                if (palabraOculta[i] == letra && !letrasAdivinadas[i]) {
                    palabraAdivinada[i] = letra;
                    letrasAdivinadas[i] = true;
                    letraAdivinada = true;
                }
            }
            
            if (letraAdivinada) {
                System.out.println("¡Correcto! La letra '" + letra + "' está en la palabra.");
            } else {
                System.out.println("La letra '" + letra + "' no está en la palabra o ya fue adivinada.");
            }
            
            // Verificar si se completó la palabra
            palabraCompleta = true;
            for (boolean adivinada : letrasAdivinadas) {
                if (!adivinada) {
                    palabraCompleta = false;
                    break;
                }
            }
            
            intentos++;
        }
        
        // Mostrar resultado final
        if (palabraCompleta) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraIngreso);
        } else {
            System.out.println("\n¡Agotaste tus intentos! La palabra oculta era: " + palabraIngreso);
        }
    }
    
    // Método para mostrar el progreso actual
    private static void mostrarProgreso(char[] palabra) {
        System.out.print("Palabra: ");
        for (char c : palabra) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}