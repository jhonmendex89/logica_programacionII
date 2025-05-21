import java.util.Scanner;

public class SistemaCalificaciones {

    //constantes static es que pertenece a la clase y final es que no cambia su valor 
    static final int NUM_ESTUDIANTES = 5;
    static final int NUM_MATERIAS = 4;

    //materias
    static String[] materias = {"Matemáticas", "Español", "Inglés", "Ciencias"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //leer

        //nombres es una lista
        String[] estudiantes = new String[NUM_ESTUDIANTES];

        //guardal calificaciones , matriz con decimales 
        double[][] calificaciones = new double[NUM_ESTUDIANTES][NUM_MATERIAS];

        //Llama
        ingresarNombres(estudiantes, sc);

        //Llama
        ingresarCalificaciones(calificaciones, estudiantes, materias, sc);

        //1
        System.out.println("\n--- Promedios por estudiante ---");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            double promedio = calcularPromedioEstudiante(calificaciones[i]);
            System.out.println(estudiantes[i] + ": " + promedio);
        }

        //2
        System.out.println("\n--- Promedios por materia ---");
        for (int j = 0; j < NUM_MATERIAS; j++) {
            double promedio = calcularPromedioMateria(calificaciones, j);
            System.out.println(materias[j] + ": " + promedio);
        }

        //3
        mostrarAprobadosYReprobados(calificaciones, estudiantes);

        //4
        mostrarEstadisticas(calificaciones, estudiantes, materias);
    }

    static void ingresarNombres(String[] estudiantes, Scanner sc) {
        System.out.println("Ingrese los nombres de los estudiantes:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            estudiantes[i] = sc.nextLine(); // Guardamos el nombre en el arreglo
        }
    }

    static void ingresarCalificaciones(double[][] calificaciones, String[] estudiantes, String[] materias, Scanner sc) {
        System.out.println("\nIngrese las calificaciones:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i]);
            for (int j = 0; j < materias.length; j++) {
                System.out.print("  " + materias[j] + ": ");
                calificaciones[i][j] = sc.nextDouble(); // Guardamos la nota en la matriz
            }
        }
    }

    static double calcularPromedioEstudiante(double[] calificacionesEstudiante) {
        double suma = 0;
        for (double nota : calificacionesEstudiante) {
            suma += nota; 
        }
        return suma / calificacionesEstudiante.length;
    }

    static double calcularPromedioMateria(double[][] calificaciones, int materiaIndex) {
        double suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i][materiaIndex]; 
        }
        return suma / calificaciones.length;
    }


    static void mostrarAprobadosYReprobados(double[][] calificaciones, String[] estudiantes) {
        System.out.println("\n--- Aprobados y Reprobados ---");
        for (int i = 0; i < estudiantes.length; i++) {
            double promedio = calcularPromedioEstudiante(calificaciones[i]);
            String estado = promedio >= 6.0 ? "Aprobado" : "Reprobado"; 
            System.out.println(estudiantes[i] + ": " + estado + " (" + promedio + ")");
        }
    }

    static void mostrarEstadisticas(double[][] calificaciones, String[] estudiantes, String[] materias) {
        double mayor = calificaciones[0][0];
        double menor = calificaciones[0][0];
        double sumaTotal = 0;
        int totalNotas = 0;


        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[i].length; j++) {
                double nota = calificaciones[i][j];
                if (nota > mayor) mayor = nota;
                if (nota < menor) menor = nota;
                sumaTotal += nota;
                totalNotas++;
            }
        }

        double promedioGeneral = sumaTotal / totalNotas;

        System.out.println("\n--- Estadísticas Generales ---");
        System.out.println("Mayor calificación: " + mayor);
        System.out.println("Menor calificación: " + menor);
        System.out.println("Promedio general: " + promedioGeneral);
    }
}

// .length imprime la cantidad de elementos, final es que no cambia, double es para decimales
