package src;
import java.util.Scanner;

import src.InputUser.InputValidator;

public class TerminalDisplay {

    public class Display{   
    
    // Welcome Message
    public static void displayWelcomeMessage() {
        System.out.print("\n" +
            "       ╔═══════════════════════════════════════════╗\n" +
            "       ║                                           ║\n" +
            "       ║       WELCOME TO GLOBAL CONVERTER         ║\n" +
            "       ║        By Lucas M., Than L, Vanny L.      ║\n" +
            "       ║                                           ║\n" +
            "       ╚═══════════════════════════════════════════╝\n"
        );
    }

    // Ask user to enter a string to translate and check if the input is valid
    public static String getInputString() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease enter a string to translate: ");
        String inputString = input.nextLine();
        System.out.println();        

        while (!InputValidator.isValidString(inputString)) {
            System.out.print("Invalid input! Please enter a valid string without special characters." +
                             "\nPlease enter a string to translate: ");
            inputString = input.nextLine();
            System.out.println();
        }

        input.close();
        return inputString;
    }

    // Display String
    public static void displayStringToTranslate(String inputString) {
        System.out.printf("Here is the string you want to translate: %s\n\n", inputString);
    }


    public static String getTranslationBase() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n" +
            "       ╔═══════════════════════════════════════════╗\n" +
            "       ║      Available Translation bases :        ║\n" +
            "       ║                                           ║\n" +
            "       ║      Text   (t)      Hexadecimal (h)      ║\n" +
            "       ║      Octal  (o)      Decimal     (d)      ║\n" +
            "       ║      Binary (b)      Return      (r)      ║\n" +
            "       ╚═══════════════════════════════════════════╝\n" +
            "\nPlease enter your translation base: "
        );

        String inputBase = input.nextLine().toLowerCase();

        while (!InputValidator.isValidBase(inputBase)) {
            System.out.print("Invalid input! Please choose one of the available base options" +
                             "\nPlease enter your translation base: ");
            inputBase = input.nextLine().toLowerCase();
            System.out.println();
        }
        input.close();
        return inputBase;
    }

    public static void displayTranslationBase(String inputBase) {
        System.out.printf("Here is the translation base you want: %s\n\n", inputBase);
    }

}}


