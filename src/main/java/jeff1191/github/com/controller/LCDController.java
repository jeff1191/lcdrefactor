package jeff1191.github.com.controller;

import jeff1191.github.com.Constants;
import jeff1191.github.com.datatype.LCD;
import jeff1191.github.com.views.IView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LCDController {
    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private int size;

    private LCD lcd;
    protected IView iView;

    public LCDController(IView iView){
        this.iView = iView;
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    public abstract void start();


    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     */
    public void imprimirNumero(int size, String numeroImp, int espacio)
    {
        int pivotX = 0;
        char[] digitos;

        this.size = size;

        // Calcula el numero de filas cada digito
        int filasDig = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        int columDig = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        int totalFilas = filasDig;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        int totalColum = (columDig * numeroImp.length())
                + (espacio * numeroImp.length());

        // crea matriz para almacenar los numero a imprimir
        this.lcd = new LCD(totalFilas, totalColum);

        // crea el arreglo de digitos
        digitos = numeroImp.toCharArray();
        

        for (char digito : digitos) {

            //Valida que el caracter sea un digito
            if( ! Character.isDigit(digito))
                throw new IllegalArgumentException("Caracter " + digito
                        + " no es un digito");


            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (columDig - 1);
            this.pf4[1] = (filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (columDig - 1) + pivotX;

            pivotX = pivotX + columDig + espacio;

            adicionarDigito(numero);
        }

        iView.showMatriz(totalFilas, totalColum,lcd);
    }




    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                lcd.adicionarLinea(this.pf1, Constants.POSICION_Y,
                        this.size, Constants.CARACTER_VERTICAL);
                break;
            case 2:
                lcd.adicionarLinea( this.pf2, Constants.POSICION_Y,
                        this.size, Constants.CARACTER_VERTICAL);
                break;
            case 3:
                lcd.adicionarLinea( this.pf5, Constants.POSICION_Y,
                        this.size, Constants.CARACTER_VERTICAL);
                break;
            case 4:
                lcd.adicionarLinea( this.pf4, Constants.POSICION_Y,
                        this.size, Constants.CARACTER_VERTICAL);
                break;
            case 5:
                lcd.adicionarLinea( this.pf1, Constants.POSICION_X,
                        this.size, Constants.CARACTER_HORIZONTAL);
                break;
            case 6:
                lcd.adicionarLinea( this.pf2, Constants.POSICION_X,
                        this.size, Constants.CARACTER_HORIZONTAL);
                break;
            case 7:
                lcd.adicionarLinea( this.pf3, Constants.POSICION_X,
                        this.size, Constants.CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {
        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.addAll(Arrays.asList(3, 4));
                break;
            case 2:
                segList.addAll(Arrays.asList(5, 3, 6, 2, 7));
                break;
            case 3:
                segList.addAll(Arrays.asList(5, 3, 6, 4, 7));
                break;
            case 4:
                segList.addAll(Arrays.asList(1, 6, 3, 4));
                break;
            case 5:
                segList.addAll(Arrays.asList(5, 1, 6, 4, 7));
                break;
            case 6:
                segList.addAll(Arrays.asList(5, 1, 6, 2, 7, 4));
                break;
            case 7:
                segList.addAll(Arrays.asList(5, 3, 4));
                break;
            case 8:
                segList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                break;
            case 9:
                segList.addAll(Arrays.asList(1, 3, 4, 5, 6, 7));
                break;
            case 0:
                segList.addAll(Arrays.asList(1, 2, 3, 4, 5, 7));
                break;
            default:
                break;
        }
        segList.forEach(seg -> adicionarSegmento(seg));
    }

    /**
     *
     * Metodo encargado comprobar que un numero esta en un rango determinado
     * devolverá una excepcion en caso que no lo cumpla
     *
     * @param comando numero a validar
     * @param menor cota inferior
     * @param mayor cota superior
     */
    public static Integer validaNumero(String comando, Integer menor, Integer mayor){
        int ret;
        ret = Integer.parseInt(comando);
        // se valida que el size este entre menor y mayor
        if(ret < menor || ret >mayor)
            throw new IllegalArgumentException("El parametro ["+ret
                    + "] debe estar entre "+menor+" y "+mayor);

        return ret;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    protected void procesar(String comando, int espacioDig) {

        String[] parametros;

        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        //Se hace el split de la cadena
        parametros = comando.split(",");

        //Valida la cantidad de parametros
        if(parametros.length>2)
            throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,");


        //Valida la cantidad de parametros
        if(parametros.length<2)
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");

        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0]))
            tam = validaNumero(parametros[0],1,10);
        else
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");

        // Realiza la impresion del numero
        imprimirNumero(tam, parametros[1],espacioDig);
    }

    public LCD getLcd(){
        return lcd;
    }
}
