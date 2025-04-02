package JhonMendez.vectoresMatrices;

import java.util.Scanner;

public class Vectores {
    public static void main(String[] args) {
    String arregloLetras[];
    Scanner entrada = new Scanner(System.in);
    int arregloEnteros[] = new int[4];
    arregloEnteros[0] =  1 ;
    arregloEnteros[1] =  2;
    arregloEnteros[2] =  3;
    arregloEnteros[3] =  4;

    //lectura al array tamaño 4
    for (int i : arregloEnteros) {
        System.out.println(i);
    }
    
    for(int i=0; i<arregloEnteros.length; i++){
        System.out.println(arregloEnteros[i]);
    }

    //solicitar tamaño de una array
    System.out.println("ingrese el tamaño del vector");
    arregloLetras = new String [entrada.nextInt()];
    for(int i=0; i<arregloLetras.length; i++){
       System.out.println("ingrese una letra en la posicion " + i); 
       arregloLetras[i] = entrada.next(); 
       for (String j : arregloLetras) {
        System.out.println(j);
    } 
    }
}
}

 