
import java.util.Scanner;

public class arreglos{
    public static void main (String[] args) {
        String arreglosletras [];
        Scanner entrada = new Scanner(System.in);
        int[] arreglo = new int[4];
        arreglo[0] = 1;
        arreglo[1] = 2;
        arreglo[2] = 3;
        arreglo[3] = 4;
    //lectura al array tamaño 4
    
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]); 
        }
    for (int i = 0; i < arreglo.length; i++) {
        System.out.println("Ingrese el valor numerico de la posicion " + i);
        arreglo[i] = entrada.nextInt();
    }
    //solicitar al usuario los valores del array
    System.out.println("Ingrese el tamaño del vector");
    arreglosletras = new String[entrada.nextInt()];
    for (int i = 0; i < arreglosletras.length; i++) {
        System.out.println("Ingrese la letra de la posicion " + i);
        arreglosletras[i] = entrada.next();
        for (String j : arreglosletras) { 
        System.out.println(j);
        }
    }
 }
}
