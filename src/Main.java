package src;

import java.util.Scanner;
import src.InputUser;


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
            "\n          Please enter a string to translate:" 
        );    
        
        String input1 = input.nextLine();
        
        System.out.println(input1);
        input.close();        
    }
}
