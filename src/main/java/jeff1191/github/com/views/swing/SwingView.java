package jeff1191.github.com.views.swing;

import jeff1191.github.com.datatype.LCD;
import jeff1191.github.com.views.IView;

import javax.swing.*;
import java.awt.*;

public class SwingView implements IView {
    @Override
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg,"Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showMatriz(int nRows, int nCols, LCD matriz) {
        JOptionPane.showMessageDialog(null, matriz.toString());
    }

    public Integer showSpaceDigitOption(){
        Object[] possibilities = {0, 1, 2, 3, 4, 5};
        Integer s = (Integer)JOptionPane.showInputDialog(
                null,
                "Espacio entre Digitos:\n",
                "INFO",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                0);

        return s;
    }

    public String showInputDigitOption(){
        String s = (String)JOptionPane.showInputDialog(
                null,
                "Entrada:\n",
                "INFO",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "2,12345 3,67890");

        return s;
    }

}
