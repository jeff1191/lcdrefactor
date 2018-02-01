package jeff1191.github.com.controller;

import jeff1191.github.com.views.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static jeff1191.github.com.Constants.CADENA_FINAL;

public class LCDConsoleController extends LCDController{

    public LCDConsoleController(IView iView) {
        super(iView);
    }

    @Override
    public void start() {
        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDig;

        try {

            try (Scanner lector = new Scanner(System.in)) {
                iView.showMessage("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                if (isNumeric(comando))
                    espacioDig = validaNumero(comando,0,5);
                else
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero");

                iView.showMessage("Entrada: ");
                do
                {
                    comando = lector.next();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                        listaComando.add(comando);

                }while (!comando.equalsIgnoreCase(CADENA_FINAL));

            }

            listaComando.forEach(comandoLinea -> procesar(comandoLinea, espacioDig));

        } catch (Exception ex)
        {
           iView.showError("Error: "+ex.getMessage());
        }

    }

}
