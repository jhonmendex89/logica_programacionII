package Ejercicios_objetos;
public class triki {

    private char[][] matriz;

    public triki() {
        matriz = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matriz[i][j] = 'a';
    }

    public void marcarCasilla(String simbolo, int fila, int columna) {
        if (simbolo.length() == 1 && (simbolo.equals("X") || simbolo.equals("0"))) {
            matriz[fila][columna] = simbolo.charAt(0);
        }
    }

    public char verificarGanador() {
        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] != 'a' && matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2])
                return matriz[i][0];
            if (matriz[0][i] != 'a' && matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i])
                return matriz[0][i];
        }
        // Revisar diagonales
        if (matriz[0][0] != 'a' && matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2])
            return matriz[0][0];
        if (matriz[0][2] != 'a' && matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0])
            return matriz[0][2];
        // Si no hay ganador
        return 'a';
    }

    public char verificarCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }
}
