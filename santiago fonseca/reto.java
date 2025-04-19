import java.util.Scanner;

public class reto {
    public static void main(String[] args) {
        Scanner entradaTeclado = new Scanner(System.in);
        int jugarDeNuevo = 1;

        while (jugarDeNuevo == 1) {
            System.out.println("ingresa esa palabra oculta");

            String hiddenword[];
            String palabra_ingresada = entradaTeclado.next();
            int intentosR = 0;
            boolean bandera = true;
            int intentosM = palabra_ingresada.length();

            hiddenword = new String[palabra_ingresada.length()];

            System.out.println("esta es la palabra a adivinar\n tienes " + intentosM + " intentos");

            for (int i = 0; i < hiddenword.length; i++) {
                hiddenword[i] = "_";
                System.out.print(hiddenword[i] + " ");
            }

            while (intentosR < intentosM && bandera) {
                System.out.println("\n intento " + (intentosR + 1) + ", ingresa una letra : ");
                char letra = entradaTeclado.next().toLowerCase().charAt(0);

                boolean check = false;
                int coincidencias = 0;
                for (int i = 0; i < palabra_ingresada.length(); i++) {
                    if (palabra_ingresada.charAt(i) == letra && hiddenword[i].equals("_")) {
                        hiddenword[i] = String.valueOf(letra);
                        check = true;
                        coincidencias++;
                    }
                }

                if (check == true) {
                    System.out.println("letra correcta ( " + letra + " ) si esta en la palabra");
                    if (coincidencias > 1) {
                        intentosM += 2;
                        System.out.println("bien, esa letra repetida te da 2 intentos extra " + intentosM + " intentos totales.");
                    }
                } else {
                    System.out.println("mal la letra( " + letra + " ) no esta");
                }

                intentosR++;
                System.out.println("has realizado " + intentosR + " de " + intentosM + " intentos");

                for (int i = 0; i < hiddenword.length; i++) {
                    System.out.print(hiddenword[i] + " ");
                }
                System.out.println();

                if (String.join("", hiddenword).equals(palabra_ingresada)) {
                    System.out.println("bien hecho campeon, adivinaste la palabra ");
                    bandera = false;
                }
            }

            if (bandera) {
                System.out.println("no tienes intentos, la palabra era: " + palabra_ingresada);
            }

            System.out.println("\n si quieres volver a jugar presiona 1 si o no 0 ");
            jugarDeNuevo = entradaTeclado.nextInt();
        }

        entradaTeclado.close();
        System.out.println("Gracias");
    }
}

