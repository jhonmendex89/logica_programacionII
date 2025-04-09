
import java.util.Scanner;

public class arreglos {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    String arregloLetras[];
    
    int arregloEnteros[] = new int[4];
    arregloEnteros[0] = 1;
    arregloEnteros[1] = 2;
    arregloEnteros[2] = 3;
    arregloEnteros[3] = 4;
    
    //lectura
    for (int i : arregloEnteros) {
        System.out.println(i);
    }
    
    for (int i = 0; i < arregloEnteros.length; i++) {
        System.out.println(arregloEnteros[i]);
    }
System.out.println("Ingrese el tamaño del vector de letras");
    arregloLetras = new String [entrada.nextInt()];

    for (int i = 0; i < arregloLetras.length; i++) {
        System.out.println("  ");
        System.out.println("Ingrese la letra del vector en la posicion "+i);
        arregloLetras[i]=entrada.next();
        for (String j : arregloLetras) {
            System.out.print("|"+j+"|");
        
        }
    }
 
}}