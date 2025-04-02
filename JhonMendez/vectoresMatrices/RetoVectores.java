package JhonMendez.vectoresMatrices;

import java.util.Scanner;

public class RetoVectores {
    /**
     * reto de la palabra oculta
     * requisitos
     * juego para dos personas
     * solicitar al usuario 1 una palabra oculta
     * solicitar al usuario 2 que adivine la palabra
     * si la palabra es correcta mostrar un mensaje de felicitaciones
     * si la palabra es incorrecta mostrar un mensaje de error
     * el juego termina cuando se adivina la palabra o se llega a numero de intentos de acuerdo al tamaño del vector
     * ej: palabra oculta: amor -> intentos 4
     * ej: palabra oculta: unisalle -> intentos 8
     * ej: palabra programacion -> intentos 12
     * 
     * mostrar el numero de intentos que lleva el usuario 2
     * mostrar para cada letra adivinada como queda la palabra oculta en la posicion
     * ej. palabra oculta: amor -> intentos 4 -> adivina a -> a _ _ _
     * ej. palabra oculta: amor -> intentos 4 -> adivina m -> a m _ _
     * ej. palabra oculta: amor -> intentos 4 -> adivina o -> a m o _
     * ej. palabra oculta: amor -> intentos 4 -> adivina r -> a m o r
     * 
     */

     public static void main(String[] args) {
         Scanner entrada = new Scanner(System.in);
         String palabraOculta[];
         System.out.println("digite una palabra oculta");
         String palabraIngreso = entrada.next();

        palabraOculta = new String[palabraIngreso.length()];
        
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = "_";
        }

        for (int i = 0; i < palabraOculta.length; i++) {
            System.out.print(palabraOculta[i]+" ");
            
        }
     }
}
