import java.util.ArrayList;
import java.util.Scanner;

public class Parcial2 {
    public static void main(String[] args) {
        Scanner EntradaTeclado = new Scanner(System.in);

        estudiantesYmaterias();
        calificaciones();
        EntradaTeclado.close();
        int opccion;
    
        do{
            System.out.println("------MENU-------");
            System.out.println("1. Ingresar estudiantes");
            System.out.println("2. Ingresar calificaciones por materia");
            System.out.println("3. Promedio estudiantes");
            System.out.println("4. Promedio por materia");
            System.out.println("5. Ver la lista de aprobados y reprobados");
            System.out.println("6. Ver estadísticas generales del grupo.");
            System.out.println("7. salir");
            System.out.println("seleccione una opccion");
            opccion = EntradaTeclado.nextInt();

            switch (opccion) {
                case 1:
                    estudiantesYmaterias();
                    break;
                case 2:
                    calificaciones();
                    break;
                case 3:
                    promedioestudiantes();
                    break;
                case 4:
                    promediopormateria();
                    break;
                case 5:
                    aprobadosreprobados();
                    break;
                case 6:
                    estadisticas();
                case 7:
                    System.out.println("saliendooo");
                    break;
            }
        }while(opccion !=0 );

    public static void estudiantesYmaterias(Scanner EntradaTeclado) {
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add("camilo")
        estudiantes.add("laura")
        estudiantes.add("andres")
        estudiantes.add("valentina")
        estudiantes.add("sara")
        System.out.println("estudiantes actuales");
            for (String i : estudiantes){
                System.out.println("-"+i);
            }

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

        
            String[] materias = {"calculo","ingles","fisica","biologia"};
            System.out.println("estudiantes y sus materias: ");
            for (String j:estudiantes){
                System.out.println("estudiante: "+j);
                for (String i : materias) {
                    System.out.println("materias: "+i);
                }
            }   
        
    }

    public static void calificaciones(){
        double[][][] calificaciones = {
                { {4.0, 4.2, 4.5}, {3.8, 4.0, 4.1}, {3.5, 3.7, 3.6}, {4.0, 3.9, 4.1} }, // camilo
                { {4.1, 4.0, 3.9}, {3.7, 3.9, 4.0}, {3.8, 3.9, 4.1}, {4.2, 4.0, 3.9} }, // laura
                { {3.9, 4.1, 4.0}, {4.0, 4.1, 3.9}, {4.2, 4.0, 4.1}, {3.7, 3.8, 3.9} }, // andres
                { {3.8, 3.9, 4.0}, {3.7, 3.8, 3.9}, {3.9, 4.0, 3.8}, {4.1, 4.0, 4.2} }, // valentina
                { {4.3, 4.2, 4.4}, {4.1, 4.0, 4.2}, {4.0, 3.9, 4.1}, {4.3, 4.4, 4.5} }  // sara
            };
        String[] estudiantes = {"camilo", "laura", "andres", "valentina","sara"};
        String[] materias = {"calculo","ingles","fisica","biologia"};
        
        for (int i = 0; i < estudiantes.length; i++){
            System.out.println("calificaiones de: "+ estudiantes[i]);
            for (int j=0; j <materias.length; j++){
                System.out.println("materia: "+ materias[j]); 
                for (int k = 0; k < calificaciones[i][j].length; k++) {
                    System.out.print(calificaciones[i][j][k]);
                    if (k < calificaciones[i][j].length - 1) System.out.print(", ");
                } 
                System.out.println();  
            }
            System.out.println();
        }
    }
}
