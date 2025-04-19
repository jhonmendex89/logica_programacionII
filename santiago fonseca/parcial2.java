import java.util.Scanner ;

public class parcial2 {
    
    public static  int Estudaintes = 5;
    public static  int Materias= 4;

    public static void main(String[]args){
        Scanner entradaTeclado = new Scanner(System.in);

        String Estudiante[] = new String[Estudaintes];
        String Materia[] = {"sociales", "ingles", "informatica", "español"};
        double calificaciones[][] = new double[Estudaintes][Materias];

        ingresarNombresEstudiantes(Estudiante, entradaTeclado);

        ingresarCalificaciones(calificaciones, Estudiante, Materia, entradaTeclado);
        
        mostrarCalificaciones(calificaciones,Estudiante, Materia);

        calcularPromedioPorEstudiante(calificaciones, Estudiante);

        calcularPromedioPorMateria(calificaciones,Materia);

        mostrarestadisticas(calificaciones, Estudiante, Materia);

        mostrarmejorestudiantes(calificaciones, Estudiante, Materia);

        mostrarTablaResumen(calificaciones, Estudiante, Materia);

        mostrarEstadisticasGenerales(calificaciones);

        entradaTeclado.close();
    }

    public static void ingresarNombresEstudiantes(String[] Estudiante, Scanner entradaTeclado) {
        for (int i = 0; i < Estudaintes; i++) {
            System.out.println("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            Estudiante[i] = entradaTeclado.next();
        }
    }

    public static void ingresarCalificaciones(double[][] calificaciones, String[] Estudiante, String[] Materia, Scanner entradaTeclado) {
        for (int i = 0; i < Estudaintes; i++) {
            System.out.println("Ingrese las calificaciones de " + Estudiante[i] + " : ");
            for (int j = 0; j < Materias; j++) {
                double nota;
                do {
                    System.out.print(Materia[j] + ": ");
                    nota = entradaTeclado.nextDouble();
                    if (nota < 1 || nota > 50) {
                        System.out.println("La calificación debe estar entre 1 y 50.");
                    }
                } while (nota < 1 || nota > 50);
                calificaciones[i][j] = nota;
            }
        }
    }

    public static void mostrarCalificaciones(double[][] calificaciones, String[] Estudiante, String[] Materia) {
        System.out.println("Calificaciones de los estudiantes: ");
        for (int i = 0; i < Estudaintes; i++) {
            System.out.print(Estudiante[i] + ": ");
            for (int j = 0; j < Materias; j++) {
                System.out.print(Materia[j] + ": " + calificaciones[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void calcularPromedioPorEstudiante(double[][] calificaciones, String[] Estudiante) {
        System.out.println("Promedio por estudiante: ");
        for (int i = 0; i < Estudaintes; i++) {
            double suma = 0;
            for (int j = 0; j < Materias; j++) {
                suma += calificaciones[i][j];
            }
            double promedio = suma / Materias;
            System.out.println(Estudiante[i] + ": " + promedio);
        }
    }

    public static void calcularPromedioPorMateria(double[][] calificaciones, String[] Materia) {
        System.out.println("Promedio por materia: ");
        for (int j = 0; j < Materias; j++) {
            double suma = 0;
            for (int i = 0; i < Estudaintes; i++) {
                suma += calificaciones[i][j];
            }
            double promedio = suma / Estudaintes;
            System.out.println(Materia[j] + ": " + promedio);
        }
    }

    public static void mostrarestadisticas(double[][] calificaciones, String[] Estudiante, String[] Materia) {
        System.out.println("Estadísticas de calificaciones: ");
        for (int i = 0; i < Estudaintes; i++) {
            for (int j = 0; j < Materias; j++) {
                if (calificaciones[i][j] >= 30) {
                    System.out.println(Estudiante[i] + " aprobó " + Materia[j]);
                } else {
                    System.out.println(Estudiante[i] + " reprobó " + Materia[j]);
                }
            }
        }
    }

    public static void mostrarmejorestudiantes(double[][] calificaciones, String[] Estudiante, String[] Materia) {
        System.out.println("Mejores estudiantes: ");
        boolean bandera = false;
        for (int i = 0; i < Estudaintes; i++) {
            double suma = 0;
            for (int j = 0; j < Materias; j++) {
                suma += calificaciones[i][j];
            }
            double promedio = suma / Materias;
            if (promedio >= 45) {
                System.out.println(Estudiante[i] + " es un estudiante destacado con un promedio de " + promedio);
                bandera = true;
            }
        }
        if (!bandera) {
            System.out.println("No se encontraron estudiantes destacados.");
        }
    }

    public static void mostrarTablaResumen(double[][] calificaciones, String[] Estudiante, String[] Materia) {
        System.out.println("\t\tTABLA RESUMEN DE NOTAS Y PROMEDIOS");
        System.out.println("===============================================================");

        System.out.printf("%-12s", "Estudiante");
        for (int j = 0; j < Materias; j++) {
            System.out.printf("%-12s", Materia[j]);
        }
        System.out.printf("%-12s\n", "Promedio");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < Estudaintes; i++) {
            System.out.printf("%-12s", Estudiante[i]);
            double suma = 0;
            for (int j = 0; j < Materias; j++) {
                System.out.printf("%-12.1f", calificaciones[i][j]);
                suma += calificaciones[i][j];
            }
            double promedio = suma / Materias;
            System.out.printf("%-12.2f\n", promedio);
        }
        System.out.println("===============================================================\n");
    }

    public static void mostrarEstadisticasGenerales(double[][] calificaciones) {
        double mayor = calificaciones[0][0];
        double menor = calificaciones[0][0];
        double sumaTotal = 0;
        int totalNotas = Estudaintes * Materias;

        for (int i = 0; i < Estudaintes; i++) {
            for (int j = 0; j < Materias; j++) {
                if (calificaciones[i][j] > mayor) {
                    mayor = calificaciones[i][j];
                }
                if (calificaciones[i][j] < menor) {
                    menor = calificaciones[i][j];
                }
                sumaTotal += calificaciones[i][j];
            }
        }

        double promedioGeneral = sumaTotal / totalNotas;

        System.out.println("Estadísticas generales:");
        System.out.println("Mayor calificación: " + mayor);
        System.out.println("Menor calificación: " + menor);
        System.out.println("Promedio general: " + promedioGeneral);
        System.out.println();
    }
}