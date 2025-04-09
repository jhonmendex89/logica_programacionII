import java.util.Collections;
import java.util.Scanner;

/**
 * Clase principal para el juego "Adivinar Palabra".
 *
 * Aspectos destacados:
 * - Encapsulación: Las variables privadas protegen el estado interno del objeto,
 *   permitiendo que solo los métodos de la clase puedan acceder y modificarlas.
 * - Uso de StringBuilder: Permite modificar cadenas de forma eficiente sin crear nuevos objetos en cada cambio.
 * - Clase Retorno: Patrón DTO (Data Transfer Object): La clase interna Retorno agrupa datos relacionados (palabra original y su versión oculta).
 * - Collections.nCopies: Se utiliza para crear múltiples copias de un elemento, facilitando la generación de la representación oculta.
 * - Uso de métodos como charAt y contains para la manipulación y verificación de cadenas.
 */
public class AdivinarPalabra {

    public static void main(String[] args) {
        Partida nuevaPartida = new Partida();
        nuevaPartida.jugar(); // Iniciar el juego
    }

    /**
     * Clase Partida:
     * Contiene la lógica principal del juego, incluyendo la inicialización, procesamiento de intentos,
     * verificación de victoria y la presentación del estado actual y resultado final.
     */
    static class Partida {
        // Variables de instancia (uso de 'private' para encapsulación)
        private String palabraOculta;         // La palabra secreta a adivinar (en minúsculas)
        private StringBuilder palabraProgreso; // Representación del progreso, con letras descubiertas y guiones bajos
        private int intentosRestantes;         // Número de intentos disponibles para el jugador
        private boolean palabraAdivinada;       // Indica si la palabra ha sido adivinada

        // Scanner para entrada de datos (único objeto para todo el juego)
        private Scanner scanner = new Scanner(System.in);

        /**
         * Clase interna Retorno (DTO):
         * Se utiliza para devolver dos valores relacionados:
         * - palabraIngreso: la palabra original ingresada por el Usuario 1.
         * - palabraOculta: la representación oculta (con guiones bajos) de la palabra.
         */
        class Retorno {
            String palabraIngreso;
            String palabraOculta;

            Retorno(String palabraIngreso, String palabraOculta) {
                this.palabraIngreso = palabraIngreso;
                this.palabraOculta = palabraOculta;
            }
        }

        /**
         * Método principal del juego.
         * Inicializa la partida, procesa cada intento del Usuario 2 y verifica si se ha adivinado la palabra.
         */
        public void jugar() {
            inicializarJuego();

            // Bucle principal del juego: se ejecuta mientras haya intentos y la palabra no haya sido adivinada.
            while (intentosRestantes > 0 && !palabraAdivinada) {
                mostrarEstadoActual();
                String intento = pedirIntentoUsuario();
                procesarIntento(intento);
                verificarVictoria();
            }

            mostrarResultadoFinal();
        }

        /**
         * Inicializa las variables del juego.
         * Se obtiene la palabra oculta del Usuario 1, se crea la representación oculta y se configuran los intentos.
         */
        private void inicializarJuego() {
            Retorno ret = pedirPalabraUsuario1();
            // Se crea un StringBuilder mutable para poder actualizar el progreso sin crear nuevos objetos
            this.palabraProgreso = new StringBuilder(ret.palabraOculta);
            // La palabra original se almacena en minúsculas para comparaciones insensibles a mayúsculas
            this.palabraOculta = ret.palabraIngreso.toLowerCase();
            // Se establecen los intentos: longitud de la palabra + 2 intentos extras
            this.intentosRestantes = palabraOculta.length() + 2;
            this.palabraAdivinada = false;
        }

        /**
         * Solicita y valida la palabra secreta ingresada por el Usuario 1.
         * Se asegura que la entrada no esté vacía y que contenga solo letras.
         * Se genera la representación oculta utilizando guiones bajos separados por espacios.
         *
         * return Objeto Retorno que contiene la palabra original y su versión oculta.
         */
        private Retorno pedirPalabraUsuario1() {
            System.out.println("\nUsuario 1 - Digite la palabra oculta:");
            String entrada = scanner.nextLine().trim(); // .trim() elimina espacios en blanco al inicio y final

            // Validación: La entrada debe ser no vacía y contener solo letras (a-z o A-Z)
            while (entrada.isEmpty() || !entrada.matches("[a-zA-Z]+")) {
                System.out.println("Entrada inválida! Solo letras permitidas");
                entrada = scanner.nextLine().trim();
            }

            // Collections.nCopies: Crea una lista con tantas copias de "_" como caracteres tiene la palabra
            String palabraOculta = String.join(" ", Collections.nCopies(entrada.length(), "_"));
            return new Retorno(entrada, palabraOculta);
        }

        /**
         * Solicita al Usuario 2 que ingrese un intento (puede ser una letra o la palabra completa).
         *
         * return El intento ingresado, convertido a minúsculas para facilitar la comparación.
         */
        private String pedirIntentoUsuario() {
            System.out.println("\nUsuario 2 - Ingrese una letra o palabra completa:");
            return scanner.nextLine().trim().toLowerCase();
        }

        /**
         * Procesa el intento ingresado por el Usuario 2.
         * Si el intento es de una sola letra, se busca la letra en la palabra oculta y se actualiza el progreso.
         * Si el intento es una palabra completa, se verifica si coincide con la palabra oculta.
         *
         *  intento El intento ingresado por el usuario.
         */
        private void procesarIntento(String intento) {
            if (intento.length() == 1) { // Intento de adivinar una letra
                char letra = intento.charAt(0); // charAt(0): obtiene el primer carácter del intento
                boolean letraEncontrada = false;

                // Se recorre la palabra oculta para buscar coincidencias (insensible a mayúsculas)
                for (int i = 0; i < palabraOculta.length(); i++) {
                    if (Character.toLowerCase(palabraOculta.charAt(i)) == letra) {
                        /*
                         * Actualización de progreso:
                         * Se utiliza 2*i como índice ya que en la representación oculta hay espacios entre guiones:
                         * Ejemplo: "_ _ _ _"
                         */
                        palabraProgreso.setCharAt(2 * i, palabraOculta.charAt(i));
                        letraEncontrada = true;
                    }
                }

                if (!letraEncontrada) {
                    intentosRestantes--;
                    System.out.println("Letra no encontrada. Intentos restantes: " + intentosRestantes);
                }
            } else { // Intento de adivinar la palabra completa
                if (intento.equalsIgnoreCase(palabraOculta)) {
                    palabraAdivinada = true;
                    // Se actualiza el progreso para mostrar la palabra completa
                    palabraProgreso = new StringBuilder(palabraOculta);
                } else {
                    intentosRestantes--;
                    System.out.println("Palabra incorrecta. Intentos restantes: " + intentosRestantes);
                }
            }
        }

        /**
         * Verifica si se ha adivinado la palabra.
         * Se determina comprobando si la representación del progreso ya no contiene guiones bajos.
         */
        private void verificarVictoria() {
            // .toString(): Convierte el StringBuilder a String para usar contains()
            if (!palabraProgreso.toString().contains("_")) {
                palabraAdivinada = true;
            }
        }

        /**
         * Muestra el estado actual del juego, incluyendo el progreso y el número de intentos restantes.
         */
        private void mostrarEstadoActual() {
            System.out.println("\nProgreso actual:");
            System.out.println(palabraProgreso);
            System.out.println("Intentos restantes: " + intentosRestantes);
        }

        /**
         * Muestra el resultado final del juego:
         * - Si se adivinó la palabra, felicita al usuario y muestra la palabra completa.
         * - De lo contrario, indica que el juego terminó y revela la palabra oculta.
         */
        private void mostrarResultadoFinal() {
            if (palabraAdivinada) {
                System.out.println("\n¡Felicidades! Has adivinado la palabra:");
                System.out.println(palabraProgreso);
            } else {
                System.out.println("\n¡Game Over! La palabra era: " + palabraOculta);
            }
        }
    }
}
