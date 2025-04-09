import java.util.Scanner;

public class RetoVectores {
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
         
         System.out.println(); // salto de línea
         
         int intentosMax = palabraIngreso.length();
         int intentos = 0;
         boolean palabraCompleta = false;

         while (intentos < intentosMax && !palabraCompleta) {
             System.out.println("Intento " + (intentos + 1) + " de " + intentosMax);
             System.out.print("Adivina una letra: ");
             String letra = entrada.next();

             boolean acierto = false;

             for (int i = 0; i < palabraIngreso.length(); i++) {
                 if (String.valueOf(palabraIngreso.charAt(i)).equalsIgnoreCase(letra)) {
                     palabraOculta[i] = letra;
                     acierto = true;
                 }
             }

             for (int i = 0; i < palabraOculta.length; i++) {
                 System.out.print(palabraOculta[i] + " ");
             }

             System.out.println(); // salto de línea

             if (!acierto) {
                 System.out.println("Letra incorrecta.");
             }

             intentos++;

             // Comprobamos si la palabra ya está completa
             palabraCompleta = true;
             for (int i = 0; i < palabraOculta.length; i++) {
                 if (palabraOculta[i].equals("_")) {
                     palabraCompleta = false;
                     break;
                 }
             }
         }

         if (palabraCompleta) {
             System.out.println("¡Felicitaciones! Adivinaste la palabra: " + palabraIngreso);
         } else {
             System.out.println("Se acabaron los intentos. La palabra era: " + palabraIngreso);
         }

         entrada.close();
     }
}
