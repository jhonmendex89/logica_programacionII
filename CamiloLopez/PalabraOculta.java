import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalabraOculta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Usuario 1 ingresa la palabra
        System.out.print("Jugador 1, ingrese la palabra oculta: ");
        String palabraOriginal = scanner.nextLine().toLowerCase();

        char[] palabraOculta = new char[palabraOriginal.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

        int intentosDisponibles = palabraOriginal.length();
        int intentosUsados = 0;
        boolean adivinada = false;

        // Guardar letras ya usadas
        Set<Character> letrasUsadas = new HashSet<>();

        System.out.println("\nJugador 2, adivina la palabra letra por letra. Tienes " + intentosDisponibles + " intentos.\n");

        while (!adivinada && intentosDisponibles > 0) {
            System.out.println("Intentos disponibles: " + intentosDisponibles);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            // Verificar si ya usó esa letra
            if (letrasUsadas.contains(letra)) {
                System.out.println("⚠️ Ya intentaste con esa letra. Intenta otra diferente.\n");
                continue; // no cuenta como intento
            }

            letrasUsadas.add(letra); // agregar letra al conjunto

            boolean acierto = false;
            for (int i = 0; i < palabraOriginal.length(); i++) {
                if (palabraOriginal.charAt(i) == letra && palabraOculta[i] == '_') {
                    palabraOculta[i] = letra;
                    acierto = true;
                }
            }

            intentosUsados++;

            if (acierto) {
                intentosDisponibles++; // gana un intento adicional
                System.out.println("✅ ¡Correcto! Ganas un intento adicional.");
            } else {
                intentosDisponibles--; // pierde un intento
                System.out.println("❌ Letra incorrecta. Pierdes un intento.");
            }

            // Mostrar el progreso de la palabra
            System.out.print("Progreso: ");
            for (char c : palabraOculta) {
                System.out.print(c + " ");
            }
            System.out.println("\nIntentos usados: " + intentosUsados + "\n");

            if (String.valueOf(palabraOculta).equals(palabraOriginal)) {
                adivinada = true;
            }
        }

        if (adivinada) {
            System.out.println("🎉 ¡Felicidades, GANASTE CRACK ");
        } else {
            System.out.println("❌ PERDISTE NOOB. La palabra era: " + palabraOriginal);
        }

        scanner.close();
    }
}

