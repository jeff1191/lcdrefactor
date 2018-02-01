package jeff1191.github.com.views.console;

import jeff1191.github.com.datatype.LCD;
import jeff1191.github.com.views.IView;

public class ConsoleView implements IView {
    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void showError(String msg) {
        System.err.println(msg);
    }

    @Override
    public void showMatriz(int nRows, int nCols, LCD matriz) {
        System.out.println(matriz);
    }
}
