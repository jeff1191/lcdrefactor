package jeff1191.github.com;

import jeff1191.github.com.controller.LCDConsoleController;
import jeff1191.github.com.controller.LCDController;
import jeff1191.github.com.controller.LCDSwingController;
import jeff1191.github.com.views.console.ConsoleView;
import jeff1191.github.com.views.IView;
import jeff1191.github.com.views.swing.SwingView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {
    static final String CONSOLE_MODE = "console";
    static final String SWING_MODE = "swing";
    public static void main(String[] args) {
        matchArgs(args);

        IView viewApp;
        LCDController controller;

        if(args[0].equalsIgnoreCase(CONSOLE_MODE)) {
            viewApp = new ConsoleView();
            controller = new LCDConsoleController(viewApp);
        }
        else{
            viewApp = new SwingView();
            controller = new LCDSwingController(viewApp);
        }
        controller.start();
    }

    private static void matchArgs(String[] args) {
        if (args.length != 1 || (!args[0].equalsIgnoreCase(CONSOLE_MODE) && !args[0].equalsIgnoreCase(SWING_MODE))) {
            System.out.println("Arguments: <"+CONSOLE_MODE+" | "+SWING_MODE+"> ");
            System.exit(1);
        }
    }
}
