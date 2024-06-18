package src;

import java.util.Scanner;
import src.TerminalDisplay.Display;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            String statusBase;
            do {
                statusBase = Display.startTranslation(input);
            } while (statusBase.equals("r") || statusBase.equals("return"));
        } finally {
            input.close();
        }

    }
}


