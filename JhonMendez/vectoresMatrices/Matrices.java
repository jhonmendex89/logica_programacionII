package JhonMendez.vectoresMatrices;

public class Matrices {
    public static void main(String[] args) {
       
        String matriz [][]; //matriz de nxm
        matriz = new String[3][3]; //matriz de 3x3
        //escritura matriz
        matriz [0][0] = "a";
        matriz [0][1] = "b";
        matriz [0][2] = "c";
        matriz [1][0] = "d";
        matriz [1][1] = "e";
        matriz [1][2] = "f";
        matriz [2][0] = "g";
        matriz [2][1] = "h";
        matriz [2][2] = "i";

        //lectura
        //System.out.println(matriz[0][2]);
        for (int fila = 0; fila <= 2; fila++){
            for (int columna = 0; columna <= 2; columna++){
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println("");
        }

    }
  
}
