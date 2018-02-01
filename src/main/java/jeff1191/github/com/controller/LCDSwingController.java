package jeff1191.github.com.controller;

import jeff1191.github.com.views.IView;
import jeff1191.github.com.views.swing.SwingView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static jeff1191.github.com.Constants.CADENA_FINAL;

public class LCDSwingController extends LCDController {

    public LCDSwingController(IView iView) {
        super(iView);
    }

    public void start() {
        try {
            int spaceDigitOption = ((SwingView)iView).showSpaceDigitOption();
            String ret = ((SwingView)iView).showInputDigitOption();
            String[] commands = ret.split(" ");

            List<String> commandList = new ArrayList<>();
            Arrays.stream(commands).forEach(comm -> {
                        if(!comm.equalsIgnoreCase(CADENA_FINAL))
                            commandList.add(comm);
                    });

                commandList.forEach(comm -> procesar(comm, spaceDigitOption));
        }catch (Exception e){
            iView.showError("Error: "+e.getMessage());
        }
    }
}
