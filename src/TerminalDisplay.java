package src;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.InputUser.InputValidator;

public class TerminalDisplay {

    // Welcome Message with the team names
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
                "       ║              String Type                  ║\n" +
                "       ║                                           ║\n" +
                "       ║      Text   (t)      Hexadecimal (h)      ║\n" +
                "       ║      Octal  (o)      Decimal     (d)      ║\n" +
                "       ║      Binary (b)                           ║\n" +
                "       ╚═══════════════════════════════════════════╝\n" +
                "Please choose the type of string you want to convert: ");

        String inputBaseFrom = input.nextLine().toLowerCase();

        while (!InputValidator.isValidBaseFrom(inputBaseFrom)) {
            System.out.print("Invalid input! Please choose one of the available string type. \n \n" +
                    "Please choose the type of string you want to convert: ");
            inputBaseFrom = input.nextLine().toLowerCase();
            System.out.println();
        }
        return inputBaseFrom;
    }

    // Display the type of string the user want to convert
    public static void displayTranslationBaseFrom(String inputBaseFrom) {
        System.out.printf("Here is the type of string you want to convert: " + inputBaseFrom + " \n\n ");
    }

    // Ask the user to enter a string to translate and check if the input is valid
    public static String getInputString(Scanner input, String inputBaseFrom) {
        System.out.print("\nPlease enter a string to translate: ");
        String inputString = input.nextLine();

        while (!InputValidator.isValidInputUser(inputString, inputBaseFrom)) {
            System.out.print("Invalid input! Please enter a valid string for \"" + inputBaseFrom + "\" type." +
                    "\nPlease enter a string to translate: ");
            inputString = input.nextLine();
            System.out.println();
        }

        return inputString;
    }

    // Display the string the user wants to translate
    public static void displayStringToTranslate(String inputString) {
        System.out.printf("Here is the string you want to translate: %s\n\n", inputString);
    }

    // Display the available translation bases and check if the user input is valid
    public static String getTranslationBaseTo(Scanner input) {
        System.out.print("\n" +
                "       ╔═══════════════════════════════════════════╗\n" +
                "       ║       Available Translation bases         ║\n" +
                "       ║                                           ║\n" +
                "       ║      Text   (t)      Hexadecimal (h)      ║\n" +
                "       ║      Octal  (o)      Decimal     (d)      ║\n" +
                "       ║      Binary (b)      Return      (r)      ║\n" +
                "       ╚═══════════════════════════════════════════╝\n" +
                "\nPlease enter your translation base: ");

        String inputBaseTo = input.nextLine().toLowerCase();

        while (!InputValidator.isValidBaseTo(inputBaseTo)) {
            System.out.print("Invalid input! Please choose one of the available base options" +
                    "\nPlease enter your translation base: ");
            inputBaseTo = input.nextLine().toLowerCase();
        }
        return inputBaseTo;
    }

    // Display the translation base the user wants
    public static void displayTranslationBaseTo(String inputBaseTo) {
        System.out.printf("Here is the translation base you want: %s\n\n", inputBaseTo);
    }

    public static void displayTranslationResult(String inputString, String baseType, String result) {
        System.out.println("Your translation base is \"" + baseType + "\" and you want to translate \"" + inputString + "\" ");
        System.out.println("The result is: " + result + "\n");
    }

    // Welcome Caesar message
    public static void displayCaesarMessage() {
        System.out.print("\n" +
                "       ╔═══════════════════════════════════════════╗\n" +
                "       ║                                           ║\n" +
                "       ║         WELCOME TO CAESAR CIPHER          ║\n" +
                "       ║                                           ║\n" +
                "       ╚═══════════════════════════════════════════╝\n");
    }

    // Ask the user if he wish to use Caesar Cipher
    public static int displayCaesarInput(Scanner input) {
        String inputCesarAnswer;

        do {
            System.out.print("\nDo you wish to use Caesar Cipher (Y/N) ? ");
            inputCesarAnswer = input.next().toLowerCase();
            if (!inputCesarAnswer.equals("y") && !inputCesarAnswer.equals("n")) {
                System.out.println("You must choose Y or N");
            }
        } while (!inputCesarAnswer.equals("y") && !inputCesarAnswer.equals("n"));

        if (inputCesarAnswer.equals("y")) {
            while (true) {
                System.out.print("Enter the Caesar shift value: ");
                try {
                    int inputCesarShift = input.nextInt();
                    input.nextLine();
                    return inputCesarShift;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value only. \n ");
                    input.nextLine();
                }
            }
        } else {
            System.out.println("No problem. Goodbye ! :)");
            return 0;
        }
    }

    // Display all messages in the terminal
    public static String startTranslation(Scanner input) {

        displayWelcomeMessage();
        String inputBaseFrom = getTranslationBaseFrom(input);
        displayTranslationBaseTo(inputBaseFrom);
        String inputString = getInputString(input, inputBaseFrom);
        displayStringToTranslate(inputString);

        // Display Cesar Cipher only if the user doesn't chose return
        String inputBaseTo = getTranslationBaseTo(input);
        if (!inputBaseTo.equals("r") && !inputBaseTo.equals("return")) {
            String outputString = Translate.translateTowardBinary(inputString, inputBaseTo.charAt(0));
            displayTranslationBaseTo(inputBaseTo);
            displayTranslationResult(inputString, inputBaseTo, outputString);
            displayCaesarMessage(); 
            int inputShift = displayCaesarInput(input);
            Caesar.encryption(inputString, inputShift);
        }

        return inputBaseTo;
    }
}
