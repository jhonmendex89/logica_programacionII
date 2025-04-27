import java.util.*;

public class p2 {
    static Scanner EntradaTeclado = new Scanner(System.in);
    static ArrayList<String> estudiantes = new ArrayList<>(List.of("camilo", "laura", "andres", "valentina", "sara"));
    static ArrayList<String> materias = new ArrayList<>(List.of("calculo", "ingles", "fisica", "biologia"));
    static Map<String, Map<String, ArrayList<Double>>> calificaciones = new HashMap<>();

    public static void main(String[] args) {
        int opcion;
        inicializarCalificaciones();
        do {
            System.out.println("\n------MENU-------");
            System.out.println("1. Ingresar estudiantes");
            System.out.println("2. Ingresar calificaciones por materia");
            System.out.println("3. Promedio estudiantes por materia");
            System.out.println("4. Ver la lista de aprobados y reprobados");
            System.out.println("5. Ver estadísticas generales del grupo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = EntradaTeclado.nextInt();
            

            switch (opcion) {
                case 1:
                    ingresarEstudiantes();
                    break;
                case 2:
                    ingresarCalificaciones();
                    break;
                case 3:
                    mostrarPromedioPorMateria();
                    break;
                case 4:
                    mostrarAprobadosReprobados();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void ingresarEstudiantes() {
        System.out.println("desea agregar estudiantes, si / no");
        String respuesta= EntradaTeclado.next();
            if (respuesta.equalsIgnoreCase("si")){
                System.out.println("Ingrese el nombre del estudiante");
                String nuevoestudiante= EntradaTeclado.next();
                estudiantes.add(nuevoestudiante);
                System.out.println("estudiante agregado");
                System.out.println("lista de estudiantes actualizada");
                    for (String i:estudiantes){
                        System.out.println("-"+i);
                    }

            }else{System.out.println("chao");}
    }

    public static void ingresarCalificaciones() {
        System.out.println("Estudiantes:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i));
        }
        System.out.print("Seleccione el número del estudiante: ");
        int est = EntradaTeclado.nextInt() - 1;
        String estudiante = estudiantes.get(est);
    
       
        if (!calificaciones.containsKey(estudiante)) {
            calificaciones.put(estudiante, new HashMap<>());
        }
    
        System.out.println("Materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i));
        }
        System.out.print("Seleccione el número de la materia: ");
        int mat = EntradaTeclado.nextInt() - 1;
        String materia = materias.get(mat);
    
        Map<String, ArrayList<Double>> materiasNotas = calificaciones.get(estudiante);
        if (!materiasNotas.containsKey(materia)) {
            materiasNotas.put(materia, new ArrayList<>());
        }
        ArrayList<Double> notas = materiasNotas.get(materia);
    
        System.out.print("¿Cuántas notas desea ingresar?: ");
        int cantidad = EntradaTeclado.nextInt();
    
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese nota " + (i + 1) + ": ");
            double nota = EntradaTeclado.nextDouble();
            notas.add(nota);
        }
        System.out.println("Notas ingresadas correctamente.");
    }
    
    public static void inicializarCalificaciones() {
        for (int i = 0; i < estudiantes.size(); i++) {
            String estudiante = estudiantes.get(i);
            Map<String, ArrayList<Double>> notasPorMateria = new HashMap<>();
    
            for (int j = 0; j < materias.size(); j++) {
                String materia = materias.get(j);
                ArrayList<Double> notas = new ArrayList<>();
    
                // Generar dos notas fijas distintas por estudiante y materia
                double nota1 = 3.0 + (i + j) % 3 * 0.3; 
                double nota2 = 2.5 + (i * j) % 3 * 0.3; 
                notas.add(nota1);
                notas.add(nota2);
    
                notasPorMateria.put(materia, notas);
            }
    
            calificaciones.put(estudiante, notasPorMateria);
        }
    }
    
    public static void mostrarPromedioPorMateria() {
        for (String est : estudiantes) {
            System.out.println("\nEstudiante: " + est);
            Map<String, ArrayList<Double>> materiasNotas = calificaciones.get(est);
            if (materiasNotas != null) {
                for (String mat : materiasNotas.keySet()) {
                    ArrayList<Double> notas = materiasNotas.get(mat);
                    double suma = 0;
                    for (int i = 0; i < notas.size(); i++) {
                        suma += notas.get(i); // Sumar las notas
                    }
                    double promedio = suma / notas.size(); 
                    System.out.println("Materia: " + mat + ", Promedio: " + promedio); 
                }
            } else {
                System.out.println("Sin calificaciones.");
            }
        }
    }

    public static void mostrarAprobadosReprobados() {
        for (String est : estudiantes) {
            Map<String, ArrayList<Double>> materiasNotas = calificaciones.get(est);
            if (materiasNotas == null) {
                System.out.println(est + " no tiene notas registradas.");
                continue; // Si no tiene notas, pasa al siguiente estudiante
            }
            double suma = 0;
            int totalNotas = 0;
            for (ArrayList<Double> notas : materiasNotas.values()) {
                for (double nota : notas) {
                    suma += nota;
                    totalNotas++;
                }
            }
            double promedio = suma / totalNotas;
            if (promedio >= 3.0) {
                System.out.println(est + " Aprobado (" + promedio + ")");
            } else {
                System.out.println(est + " Reprobado (" + promedio + ")");
            }
        }
    }
    

    public static void mostrarEstadisticas() {
        int totalNotas = 0;
        double sumaTotal = 0;
    
        for (Map<String, ArrayList<Double>> m : calificaciones.values()) {
            for (ArrayList<Double> notas : m.values()) {
                for (double nota : notas) {
                    sumaTotal += nota;
                    totalNotas++;
                }
            }
        }
    
        if (totalNotas > 0) {
            double promedioGeneral = sumaTotal / totalNotas;
            System.out.println("Promedio general del grupo: " + promedioGeneral);
        } else {
            System.out.println("No hay notas registradas.");
        }
    }
}