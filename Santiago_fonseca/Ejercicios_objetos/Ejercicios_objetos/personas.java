package Ejercicios_objetos;


public class personas {
   
    private String nombre ;
    private int edad ;
    private String genero ;
    private double peso ;
    private double altura ;

    public personas(String nombre, int edad, String genero, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "\n nombre :  " + nombre + "\n edad : " + edad + "\n genero : " + genero + "\n peso : "
               + peso + "\n altura  : " + altura + "\n IMC : " + calcularIMC() + "\n mayor de edad : " + esMayorDeEdad(); 
    }
}