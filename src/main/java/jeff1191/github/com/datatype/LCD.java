package jeff1191.github.com.datatype;

import jeff1191.github.com.Constants;

public class LCD {
    private String[][] matrizImpr;
    private final int totalFilas;
    private final int totalColum;

    public LCD(int totalFilas, int totalColum){
        this.totalColum = totalColum;
        this.totalFilas = totalFilas;
        this.matrizImpr = new String[totalFilas][totalColum];

        // Inicializa matriz
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */
    public void adicionarLinea(int[] punto, String posFija,
                                int size, String caracter) {

        if (posFija.equalsIgnoreCase(Constants.POSICION_X))
        {
            for (int y = 1; y <= size; y++)
            {
                int valor = punto[1] + y;
                matrizImpr[punto[0]][valor] = caracter;
            }
        }
        else
        {
            for (int i = 1; i <= size; i++)
            {
                int valor = punto[0] + i;
                matrizImpr[valor][punto[1]] = caracter;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toPaint= new StringBuilder();
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                toPaint.append(matrizImpr[i][j]);
            }
            toPaint.append(System.lineSeparator());
        }

        return toPaint.toString();
    }
}
