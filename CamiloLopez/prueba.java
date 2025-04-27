
import java.util.Scanner;
public class prueba {
    public static void main(String[] args) {
        Scanner EntradaTeclado = new Scanner(System.in);

        estudiantesYmaterias(); // llamada al método

        EntradaTeclado.close();
    }

    public static void estudiantesYmaterias() {
        String[] estudiantes = {"camilo", "laura", "andres", "valentina", "sara"};
        String[] materias = {"calculo", "ingles", "fisica", "biologia"}; // <- línea corregida

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i]);

            for (int j = 0; j < materias.length; j++) {
                System.out.println("  Materia: " + materias[j]); // <- punto y coma corregido
            }

            System.out.println(); // línea vacía para separar estudiantes
        }
    }
}


