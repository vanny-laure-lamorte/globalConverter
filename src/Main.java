package src;


import src.TerminalDisplay.Display;

public class Main {

    public static void main(String[] args) {
        Display.displayWelcomeMessage();
        String inputString = Display.getInputString();
        Display.displayStringToTranslate(inputString);
        String inputBase = Display.getTranslationBase();
        Display.displayTranslationBase(inputBase);
       
    }
}


