import java.util.Scanner;

public class PalabraOculta {

        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            
            System.out.println("================================");
            System.out.println("    JUEGO DE LA PALABRA OCULTA  ");
            System.out.println("================================");
            
            // Usuario 1 ingresa la palabra
            System.out.println("\nJugador 1, escribe la palabra secreta:");
            String palabraSecreta = entrada.nextLine().toLowerCase();
            
            // Preparar variables
            char[] palabraAdivinada = new char[palabraSecreta.length()];
            for(int i = 0; i < palabraAdivinada.length; i++) {
                palabraAdivinada[i] = '_';
            }
            
            int intentos = palabraSecreta.length();
            boolean adivinado = false;
            
            // Limpiar pantalla (forma simple)
            for(int i = 0; i < 20; i++) {
                System.out.println();
            }
            
            System.out.println("================================");
            System.out.println("    JUEGO DE LA PALABRA OCULTA  ");
            System.out.println("================================");
            
            System.out.println("\nJugador 2, adivina la palabra!");
            System.out.println("Tienes " + intentos + " intentos.");
            System.out.print("Palabra: ");
            mostrarPalabra(palabraAdivinada);
            
            // Juego principal
            while(intentos > 0 && !adivinado) {
                System.out.println("\n------------------------");
                System.out.println("Intento #" + (palabraSecreta.length() - intentos + 1));
                System.out.println("Adivina una letra o escribe la palabra completa:");
                String intento = entrada.nextLine().toLowerCase();
                
                if(intento.length() == 1) {
                    char letra = intento.charAt(0);
                    boolean acerto = false;
                    
                    for(int i = 0; i < palabraSecreta.length(); i++) {
                        if(palabraSecreta.charAt(i) == letra) {
                            palabraAdivinada[i] = letra;
                            acerto = true;
                        }
                    }
                    
                    if(acerto) {
                        System.out.println("¡Bien! La letra '" + letra + "' está en la palabra.");
                    } else {
                        System.out.println("La letra '" + letra + "' no está. Pierdes un intento.");
                        intentos--;
                    }
                    
                    System.out.print("Palabra: ");
                    mostrarPalabra(palabraAdivinada);
                    
                    // Verificar si se adivinó toda la palabra
                    if(String.valueOf(palabraAdivinada).equals(palabraSecreta)) {
                        adivinado = true;
                    }
                } else {
                    if(intento.equals(palabraSecreta)) {
                        adivinado = true;
                    } else {
                        System.out.println("Esa no es la palabra correcta. Pierdes un intento.");
                        intentos--;
                    }
                }
                
                System.out.println("Intentos restantes: " + intentos);
                dibujarAhorcado(intentos, palabraSecreta.length());
            }
            
            // Resultado final
            System.out.println("\n------------------------");
            if(adivinado) {
                System.out.println("¡FELICIDADES! Adivinaste la palabra: " + palabraSecreta);
                System.out.println("  ___________");
                System.out.println(" |           |");
                System.out.println(" |  GANASTE  |");
                System.out.println(" |___________|");
            } else {
                System.out.println("¡PERDISTE! La palabra era: " + palabraSecreta);
                System.out.println("  ___________");
                System.out.println(" |           |");
                System.out.println(" | PERDISTE  |");
                System.out.println(" |___________|");
            }
            
            entrada.close();
        }
        
        // Método para mostrar la palabra con espacios
        public static void mostrarPalabra(char[] palabra) {
            for(char letra : palabra) {
                System.out.print(letra + " ");
            }
            System.out.println();
        }
        
        // Método para dibujar el ahorcado
        public static void dibujarAhorcado(int intentosRestantes, int totalIntentos) {
            int errores = totalIntentos - intentosRestantes;
            
            System.out.println("  ______");
            System.out.println("  |    |");
            
            // Cabeza
            if(errores >= 1) System.out.println("  O    |");
            else System.out.println("       |");
            
            // Torso y brazos
            if(errores >= 4) System.out.println(" /|\\   |");
            else if(errores >= 3) System.out.println(" /|    |");
            else if(errores >= 2) System.out.println("  |    |");
            else System.out.println("       |");
            
            // Piernas
            if(errores >= 6) System.out.println(" / \\   |");
            else if(errores >= 5) System.out.println(" /     |");
            else System.out.println("       |");
            
            System.out.println("     _|_");
            System.out.println("    |   |______");
            System.out.println("    |__________|");

        
    }
}          