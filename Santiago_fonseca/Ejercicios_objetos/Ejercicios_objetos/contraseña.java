package Ejercicios_objetos;

import java.util.Random;

public class contraseña {
     
   private int longitud;
    private String contrasena;

    public void password(int longitud) {
        this.longitud = (longitud > 0) ? longitud : 8;
        this.contrasena = generarContrasena();
    }

    private String generarContrasena() {
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minus = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String simbolos = "!@#$%^&*()_+[]{}|;:,.<>?";
        String all = mayus + minus + nums + simbolos ;
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            sb.append(all.charAt(rand.nextInt(all.length())));
        }
        return sb.toString();
    }

    public boolean esFuerte() {
        int mayus = 0, minus = 0, nums = 0;
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) mayus++;
            else if (Character.isLowerCase(c)) minus++;
            else if (Character.isDigit(c)) nums++;
        }
        return mayus >= 1 && minus >= 1 && nums > 5;
    }

    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }

    @Override
    public String toString() {
        return "Longitud: " + longitud + "\nContraseña: " + contrasena + "\n¿Es fuerte?: " + esFuerte();
    }
    
}
