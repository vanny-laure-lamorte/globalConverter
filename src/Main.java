package src;

import java.util.Scanner;
import src.TerminalDisplay.Display;

public class Main {

    public static void main(String[] args) {

        // Open a scanner
        Scanner input = new Scanner(System.in);
        

        // 


        try {
            String statusBase;

            // Return option
            do {
                statusBase = Display.startTranslation(input);
            } while (statusBase.equals("r") || statusBase.equals("return"));
        } finally {
            input.close();
        }

    }    


}


