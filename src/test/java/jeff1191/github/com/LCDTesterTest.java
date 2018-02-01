package jeff1191.github.com;

import jeff1191.github.com.controller.LCDConsoleController;
import jeff1191.github.com.controller.LCDController;
import jeff1191.github.com.views.console.ConsoleView;
import org.junit.Test;

import static org.junit.Assert.*;


public class LCDTesterTest {

    @Test
    public void LCDIntegrationTest(){
       LCDController controller = new LCDConsoleController(new ConsoleView());

       controller.imprimirNumero(2, "2",0);
       String expected =" -- \n" +
                        "   |\n" +
                        "   |\n" +
                        " -- \n" +
                        "|   \n" +
                        "|   \n" +
                        " -- \n";
        assertEquals(controller.getLcd().toString(),expected);

        String expectedFourD =" --   --        --  \n" +
                              "   |    | |  | |    \n" +
                              "   |    | |  | |    \n" +
                              " --   --   --   --  \n" +
                              "|       |    |    | \n" +
                              "|       |    |    | \n" +
                              " --   --        --  \n";
       controller.imprimirNumero(2, "2345",1);

        assertEquals(controller.getLcd().toString(),expectedFourD);

        String expectedNineD ="         ----    ----            ----    ----    ----    ----    ----   \n" +
                              "     |       |       |  |    |  |       |            |  |    |  |    |  \n" +
                              "     |       |       |  |    |  |       |            |  |    |  |    |  \n" +
                              "     |       |       |  |    |  |       |            |  |    |  |    |  \n" +
                              "     |       |       |  |    |  |       |            |  |    |  |    |  \n" +
                              "         ----    ----    ----    ----    ----            ----    ----   \n" +
                              "     |  |            |       |       |  |    |       |  |    |       |  \n" +
                              "     |  |            |       |       |  |    |       |  |    |       |  \n" +
                              "     |  |            |       |       |  |    |       |  |    |       |  \n" +
                              "     |  |            |       |       |  |    |       |  |    |       |  \n" +
                              "         ----    ----            ----    ----            ----    ----   \n";

        controller.imprimirNumero(4, "123456789",2);

        assertEquals(controller.getLcd().toString(),expectedNineD);

        String soBigD = " --------       --------       --------       --------      \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "         |     |              |        |     |        |     \n" +
                        "                --------       --------       --------      \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "         |     |        |     |        |              |     \n" +
                        "                --------       --------       --------      \n";
        controller.imprimirNumero(8, "7689",5);

        assertEquals(controller.getLcd().toString(),soBigD);
    }



}