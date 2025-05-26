package Ejercicios_objetos;
import java.util.Scanner;

public class principal {
    public static void main (String[] args) {
        Scanner entradaTeclado = new Scanner(System.in);
    
        System.out.print("Nombre: ");
        String nombre = entradaTeclado.nextLine();

        System.out.print("Edad: ");
        int edad = entradaTeclado.nextInt();

        System.out.print("Género (H/M): ");
        String genero = entradaTeclado.next();

        System.out.print("Peso (kg): ");
        double peso = entradaTeclado.nextDouble();

        System.out.print("Altura (m): ");
        double altura = entradaTeclado.nextDouble();

        personas persona = new personas(nombre, edad, genero, peso, altura);

        System.out.println(persona);
        

        System.out.print("\nIngrese la longitud de la contraseña: ");
        int longitud = entradaTeclado.nextInt();

        contraseña pass = new contraseña();
        pass.password(longitud);

        System.out.println("\nDatos de la contraseña generada:");
        System.out.println(pass);

        System.out.print("\n¿Desea cambiar la contraseña? 1 para sí y 0 para no): ");
        int opcion = entradaTeclado.nextInt();

        if (opcion == 1) {
            System.out.print("Ingrese la nueva contraseña: ");
            String nueva = entradaTeclado.next();
            pass.cambiarContrasena(nueva);

            System.out.println("\nDatos de la nueva contraseña:");
            System.out.println(pass);

        triki juego = new triki();
        int jugadas = 0;
        char ganador = 'a';

        while (jugadas < 9 && ganador == 'a') {
            System.out.print("\nTRIKI - Ingrese símbolo (X o 0): ");
            String simbolo = entradaTeclado.next();
            System.out.print("Fila (0-2): ");
            int fila = entradaTeclado.nextInt();
            System.out.print("Columna (0-2): ");
            int columna = entradaTeclado.nextInt();
            juego.marcarCasilla(simbolo, fila, columna);

            System.out.println("Tablero:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    System.out.print(juego.verificarCasilla(i, j) + " ");
                System.out.println();
            }

            ganador = juego.verificarGanador();
            jugadas++;

            if (ganador != 'a') {
                System.out.println("¡Ganador: " + ganador + "!");
            } else if (jugadas == 9) {
                System.out.println("Empate, no hay ganador.");
            }
        }

        entradaTeclado.close();
    }
    
   }
}


