import java.util.InputMismatchException;
import java.util.Scanner;

public class Parcial2 {

    // --- Constantes ---
    static final int NUM_ESTUDIANTES = 5; // Número fijo de estudiantes
    static final int NUM_MATERIAS = 4;    // Número fijo de materias
    static final double NOTA_MIN_APROBATORIA = 6.0; // Nota mínima para aprobar

    // --- Arreglos y Matriz ---
    static String[] estudiantes = new String[NUM_ESTUDIANTES];
    static String[] materias = {"Matemáticas", "Historia", "Ciencias", "Lenguaje"}; // Nombres fijos de materias
    static double[][] calificaciones = new double[NUM_ESTUDIANTES][NUM_MATERIAS];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Calificaciones Escolares ===");

        // *** Preguntar si cargar datos de prueba ***
        System.out.print("¿Desea cargar datos de prueba para probar rápidamente? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        if (respuesta.equals("s")) {
            cargarDatosDePrueba(estudiantes, calificaciones);
        } else {
            // Si no se cargan datos de prueba, proceder con el ingreso manual
            // 1. Ingresar Nombres
            ingresarNombres(estudiantes, scanner);
            // 2. Ingresar Calificaciones
            ingresarCalificaciones(calificaciones, estudiantes, materias, scanner);
        }
        // 3. Menú de Opciones
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    mostrarPromediosEstudiantes(calificaciones, estudiantes, materias.length);
                    espera();
                    break;
                case 2:
                    mostrarPromediosMaterias(calificaciones, materias, estudiantes.length);
                    espera();
                    break;
                case 3:
                    mostrarAprobadosReprobados(calificaciones, estudiantes, materias.length, NOTA_MIN_APROBATORIA);
                    espera();
                    break;
                case 4:
                    mostrarEstadisticasGenerales(calificaciones);
                    espera();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println(); // Línea en blanco para separar

        } while (opcion != 0);

        scanner.close(); // Cerrar el scanner al final
        System.out.println("Programa finalizado.");
    }
    /**
    --- Métodos ---
    Carga datos predefinidos para pruebas rápidas
     */
    public static void cargarDatosDePrueba(String[] estudiantes, double[][] calificaciones) {
        System.out.println("\n>>> Cargando datos de prueba automáticamente... <<<");

        // Nombres de prueba
        estudiantes[0] = "Ana López";
        estudiantes[1] = "Luis Mas";
        estudiantes[2] = "Eva Prado";
        estudiantes[3] = "Juan Sol";
        estudiantes[4] = "Sara Cruz";

        // Calificaciones de prueba [estudiante][materia]
        // Ana: Buenas notas, aprueba
        calificaciones[0] = new double[]{8.5, 7.0, 9.0, 6.5}; // Promedio: 7.75
        // Luis: Notas bajas, reprueba
        calificaciones[1] = new double[]{5.0, 6.0, 5.5, 4.0}; // Promedio: 5.125
        // Eva: Excelentes notas, aprueba
        calificaciones[2] = new double[]{9.5, 8.8, 10.0, 9.1}; // Promedio: 9.35
        // Juan: Notas justas, aprueba
        calificaciones[3] = new double[]{6.0, 7.5, 5.8, 6.2}; // Promedio: 6.375
        // Sara: Notas mixtas, reprueba
        calificaciones[4] = new double[]{4.5, 5.1, 6.0, 7.0}; // Promedio: 5.65

        System.out.println("Datos de prueba cargados.");
    }


    /**
     * Muestra el menú principal de opciones al usuario.
     */
    public static void mostrarMenu() {
        System.out.println("--- Menú Principal ---");
        System.out.println("1. Ver Promedio por Estudiante");
        System.out.println("2. Ver Promedio por Materia");
        System.out.println("3. Ver Lista de Aprobados y Reprobados");
        System.out.println("4. Ver Estadísticas Generales");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee la opción seleccionada por el usuario de forma segura.
     * @param scanner El objeto Scanner para leer la entrada.
     * @return La opción numérica ingresada por el usuario.
     */
     public static int leerOpcion(Scanner scanner) {
        int opcion = -1; // Valor por defecto inválido
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: Debe ingresar un número entero.");
            opcion = -1; // Asegurar que sea inválida si hay error
        } finally {
             scanner.nextLine(); // Limpiar el buffer del scanner SIEMPRE
        }
        return opcion;
     }


    /**
     * Permite al usuario ingresar los nombres de los estudiantes.
     * @param estudiantes Arreglo donde se guardarán los nombres.
     * @param scanner El objeto Scanner para leer la entrada.
     */
    public static void ingresarNombres(String[] estudiantes, Scanner scanner) {
        System.out.println("\n--- Registro de Nombres de Estudiantes ---");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            estudiantes[i] = scanner.nextLine();
        }
        System.out.println("Nombres registrados correctamente.");
    }

    /**
     * Permite al usuario ingresar las calificaciones de cada estudiante en cada materia.
     * Incluye validación para que las notas estén en un rango (0-10).
     * @param calificaciones Matriz donde se guardarán las calificaciones.
     * @param estudiantes Arreglo con los nombres de los estudiantes.
     * @param materias Arreglo con los nombres de las materias.
     * @param scanner El objeto Scanner para leer la entrada.
     */
    public static void ingresarCalificaciones(double[][] calificaciones, String[] estudiantes, String[] materias, Scanner scanner) {
        System.out.println("\n--- Registro de Calificaciones ---");
        double nota;
        for (int i = 0; i < estudiantes.length; i++) { // Recorre estudiantes
            System.out.println("Ingrese las calificaciones para " + estudiantes[i] + ":");
            for (int j = 0; j < materias.length; j++) { // Recorre materias
                do {
                    System.out.print("  Calificación en " + materias[j] + " (0-10): ");
                    try {
                        nota = scanner.nextDouble();
                        if (nota < 0 || nota > 10) {
                            System.err.println("Error: La calificación debe estar entre 0 y 10.");
                            nota = -1; // Marcar como inválida para repetir bucle
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Error: Ingrese un valor numérico válido.");
                        nota = -1; // Marcar como inválida
                        scanner.next(); // Limpiar la entrada incorrecta del buffer
                    }
                } while (nota < 0 || nota > 10); // Repetir si la nota es inválida
                calificaciones[i][j] = nota;
            }
             scanner.nextLine(); // Limpiar el buffer después de leer los doubles de un estudiante
        }
        System.out.println("Calificaciones registradas correctamente.");
    }

    /**
     * Calcula y devuelve el promedio de un conjunto de calificaciones.
     * @param calificacionesEstudiante Arreglo con las calificaciones de un estudiante.
     * @return El promedio de las calificaciones.
     */
    public static double calcularPromedioEstudiante(double[] calificacionesEstudiante) {
        if (calificacionesEstudiante == null || calificacionesEstudiante.length == 0) {
            return 0.0;
        }
        double suma = 0;
        for (double nota : calificacionesEstudiante) {
            suma += nota;
        }
        return suma / calificacionesEstudiante.length;
    }

     /**
     * Muestra el promedio de calificaciones para cada estudiante.
     * @param calificaciones La matriz de calificaciones.
     * @param estudiantes El arreglo de nombres de estudiantes.
     * @param numMaterias El número total de materias.
     */
    public static void mostrarPromediosEstudiantes(double[][] calificaciones, String[] estudiantes, int numMaterias) {
        System.out.println("\n--- Promedio por Estudiante ---");
        if (numMaterias == 0) {
            System.out.println("No hay materias registradas para calcular promedios.");
            return;
        }
        for (int i = 0; i < estudiantes.length; i++) {
            double suma = 0;
            for (int j = 0; j < numMaterias; j++) {
                suma += calificaciones[i][j];
            }
            double promedio = suma / numMaterias;
            System.out.printf("Estudiante: %-15s | Promedio: %.2f\n", estudiantes[i], promedio);
        }
    }


    /**
     * Calcula el promedio de calificaciones para una materia específica.
     * @param calificaciones Matriz de calificaciones.
     * @param materiaIndex El índice de la materia a calcular (columna).
     * @param numEstudiantes El número total de estudiantes.
     * @return El promedio de la materia.
     */
    public static double calcularPromedioMateria(double[][] calificaciones, int materiaIndex, int numEstudiantes) {
        if (numEstudiantes == 0) {
            return 0.0;
        }
        double suma = 0;
        for (int i = 0; i < numEstudiantes; i++) { // Recorre filas (estudiantes)
            // Asegurarse de que el índice de materia es válido para la matriz
            if (materiaIndex >= 0 && materiaIndex < calificaciones[i].length) {
                 suma += calificaciones[i][materiaIndex];
            }
        }
        return suma / numEstudiantes;
    }

    /**
     * Muestra el promedio de calificaciones para cada materia.
     * @param calificaciones La matriz de calificaciones.
     * @param materias El arreglo de nombres de materias.
     * @param numEstudiantes El número total de estudiantes.
     */
    public static void mostrarPromediosMaterias(double[][] calificaciones, String[] materias, int numEstudiantes) {
        System.out.println("\n--- Promedio por Materia ---");
         if (numEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados para calcular promedios.");
            return;
        }
        for (int j = 0; j < materias.length; j++) {
            double promedio = calcularPromedioMateria(calificaciones, j, numEstudiantes);
            System.out.printf("Materia: %-12s | Promedio: %.2f\n", materias[j], promedio);
        }
    }


   /**
     * Muestra qué estudiantes aprobaron y quiénes reprobaron basado en su promedio.
     * @param calificaciones La matriz de calificaciones.
     * @param estudiantes El arreglo de nombres de estudiantes.
     * @param numMaterias El número de materias para calcular el promedio.
     * @param notaMinima La nota mínima requerida para aprobar.
     */
    public static void mostrarAprobadosReprobados(double[][] calificaciones, String[] estudiantes, int numMaterias, double notaMinima) {
        System.out.println("\n--- Estado de Aprobación (Nota mínima: " + notaMinima + ") ---");
        if (numMaterias == 0) {
            System.out.println("No hay materias para calcular promedios.");
            return;
        }

        System.out.println("\nAprobados:");
        boolean hayAprobados = false;
        for (int i = 0; i < estudiantes.length; i++) {
            double promedioEst = calcularPromedioEstudiante(calificaciones[i]); // Usa la función auxiliar
            if (promedioEst >= notaMinima) {
                System.out.printf("- %s (Promedio: %.2f)\n", estudiantes[i], promedioEst);
                hayAprobados = true;
            }
        }
        if (!hayAprobados) {
             System.out.println("  (Ninguno)");
        }


        System.out.println("\nReprobados:");
        boolean hayReprobados = false;
        for (int i = 0; i < estudiantes.length; i++) {
             double promedioEst = calcularPromedioEstudiante(calificaciones[i]); // Reutiliza cálculo
            if (promedioEst < notaMinima) {
                System.out.printf("- %s (Promedio: %.2f)\n", estudiantes[i], promedioEst);
                hayReprobados = true;
            }
        }
         if (!hayReprobados) {
             System.out.println("  (Ninguno)");
        }
    }


    /**
     * Muestra estadísticas generales: mayor calificación, menor calificación y promedio general.
     * @param calificaciones Matriz de calificaciones.
     */
    public static void mostrarEstadisticasGenerales(double[][] calificaciones) {
        System.out.println("\n--- Estadísticas Generales ---");
        if (calificaciones.length == 0 || calificaciones[0].length == 0) {
            System.out.println("No hay calificaciones registradas para mostrar estadísticas.");
            return;
        }

        double calificacionMin = Double.MAX_VALUE;
        double calificacionMax = Double.MIN_VALUE;
        double sumaTotal = 0;
        int totalCalificaciones = 0;

        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[i].length; j++) {
                double notaActual = calificaciones[i][j];
                sumaTotal += notaActual;
                totalCalificaciones++;

                if (notaActual < calificacionMin) {
                    calificacionMin = notaActual;
                }
                if (notaActual > calificacionMax) {
                    calificacionMax = notaActual;
                }
            }
        }

        double promedioGeneral = (totalCalificaciones > 0) ? sumaTotal / totalCalificaciones : 0.0;

        System.out.printf("Calificación Más Alta Registrada: %.2f\n", calificacionMax);
        System.out.printf("Calificación Más Baja Registrada:  %.2f\n", calificacionMin);
        System.out.printf("Promedio General del Grupo:       %.2f\n", promedioGeneral);
    }

    public static void espera(){
        System.out.println("\nDigite cualquier botón para continuar...");
        scanner.nextLine(); // Espera a que el usuario presione Enter
    }
   

}