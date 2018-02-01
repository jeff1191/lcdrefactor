package jeff1191.github.com.views;

import jeff1191.github.com.datatype.LCD;

public interface IView {
    void showMessage(String msg);
    void showError(String msg);
    void showMatriz(int nRow, int nCol, LCD matriz);
}
