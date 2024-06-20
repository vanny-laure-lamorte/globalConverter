package src;

import java.util.Scanner;

import src.InputUser.InputValidator;

public class TerminalDisplay {

    public static class Display {

        // Welcome Message
        public static void displayWelcomeMessage() {
            System.out.print("\n" +
                    "       ╔═══════════════════════════════════════════╗\n" +
                    "       ║                                           ║\n" +
                    "       ║       WELCOME TO GLOBAL CONVERTER         ║\n" +
                    "       ║        By Lucas M., Than L, Vanny L.      ║\n" +
                    "       ║                                           ║\n" +
                    "       ╚═══════════════════════════════════════════╝\n");
        }

        // Ask the user to chose the string type to convert
        public static String getTranslationBaseFrom(Scanner input) {
            System.out.print("\n" +
                    "       ╔═══════════════════════════════════════════╗\n" +
                    "       ║           String Type :                   ║\n" +
                    "       ║                                           ║\n" +
                    "       ║      Text   (t)      Hexadecimal (h)      ║\n" +
                    "       ║      Octal  (o)      Decimal     (d)      ║\n" +
                    "       ║      Binary (b)      Return      (r)      ║\n" +
                    "       ╚═══════════════════════════════════════════╝\n" +
                    "Please choose the type of string you want to convert : ");

            String inputBaseFrom = input.nextLine().toLowerCase();
            
            while (!InputValidator.isValidBase(inputBaseFrom)) {
                System.out.print("Invalid input! Please choose one of the available string type" +
                        "Please choose the type of string you want to convert : ");
                inputBaseFrom = input.nextLine().toLowerCase();
                System.out.println();
            }
            return inputBaseFrom;
        }

        public static void displayTranslationBaseFrom(String inputBaseFrom) {
            System.out.printf("Here is the type of string you want to convert: %s\n\n", inputBaseFrom);
        }

        // Ask user to enter a string to translate and check if the input is valid
        public static String getInputString(Scanner input, String inputBaseFrom) {
            System.out.print("\nPlease enter a string to translate: ");
            String inputString = input.nextLine();
            System.out.println();

            while (!InputValidator.isValidInputUser(inputString, inputBaseFrom)) {
                System.out.print("Invalid input! Please enter a valid string for \"" + inputBaseFrom + "\" type."+
                        "\nPlease enter a string to translate: ");
                inputString = input.nextLine();
                System.out.println();
            }

            return inputString;
        }

        // Display String type 
        public static void displayStringToTranslate(String inputString) {
            System.out.println();
            System.out.printf("Here is the string you want to translate: %s\n\n", inputString);
        }

        public static String getTranslationBaseTo(Scanner input) {
            System.out.print("\n" +
                    "       ╔═══════════════════════════════════════════╗\n" +
                    "       ║      Available Translation bases :        ║\n" +
                    "       ║                                           ║\n" +
                    "       ║      Text   (t)      Hexadecimal (h)      ║\n" +
                    "       ║      Octal  (o)      Decimal     (d)      ║\n" +
                    "       ║      Binary (b)      Return      (r)      ║\n" +
                    "       ╚═══════════════════════════════════════════╝\n" +
                    "\nPlease enter your translation base: ");

            String inputBaseTo = input.nextLine().toLowerCase();

            while (!InputValidator.isValidBase(inputBaseTo)) {
                System.out.print("Invalid input! Please choose one of the available base options" +
                        "\nPlease enter your translation base: ");
                inputBaseTo = input.nextLine().toLowerCase();
                System.out.println();

            }
            return inputBaseTo;
        }

        public static void displayTranslationBaseTo(String inputBaseTo) {
            System.out.printf("Here is the translation base you want: %s\n\n", inputBaseTo);
        }

        public static String startTranslation(Scanner input) {
            Display.displayWelcomeMessage();
            String inputBaseFrom = Display.getTranslationBaseFrom(input);
            Display.displayTranslationBaseTo(inputBaseFrom);
            String inputString = getInputString(input, inputBaseFrom);
            displayStringToTranslate(inputString);
            String inputBaseTo = Display.getTranslationBaseTo(input);
            inputString = Translate.translateTowardBinary(inputString);
            Display.displayTranslationBaseTo(inputString);

            return inputBaseTo;
        }
    }
}
