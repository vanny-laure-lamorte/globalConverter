package src;

import java.util.Scanner;

public class Main extends InputUser {
    public static void main(String[] args) {

        
        // Ask the user to enter a string to translate
        Scanner input = new Scanner(System.in); 
        System.out.print("\n" +
            "       ╔═══════════════════════════════════════════╗\n" +
            "       ║                                           ║\n" +
            "       ║       WELCOME TO GLOBAL CONVERTER         ║\n" +
            "       ║        By Lucas M., Than L, Vanny L.      ║\n" +
            "       ║                                           ║\n" +
            "       ╚═══════════════════════════════════════════╝\n" +
            "\nPlease enter a string to translate: " 
        );
        
        String input1 = input.nextLine();       
        
        // Verify if the user enter a valid input
        while (!InputValidator.isValidString(input1)) {
            System.out.println("Invalid input! Please enter a valid string.");
           input1 = input.nextLine();
        }; 


        
        input.close();  
        
        
    }
}
