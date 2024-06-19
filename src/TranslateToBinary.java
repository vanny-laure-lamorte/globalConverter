package src;

public class TranslateToBinary {
    /*
     * Class to convert a string that is passed as an argument to binary
     * First, we convert the string with ASCII values
     * Then, we convert the ASCII values to binary using Integer.toBinaryString
     * Finally, we concatenate the binary values to get the final binary string
    */
    
    public static String translateTowardBinary(String inputString){
        // ! Debugging purposes
        System.out.println("String to translate: " + inputString);
        StringBuilder binaryString = new StringBuilder();
        
        for (int chara = 0; chara < inputString.length(); chara++) {
            // Convert the character to an ASCII value
            char character = inputString.charAt(chara);
            int asciiValue = (int) character;
            // Convert the ASCII value to binary
            StringBuilder binaryValue = new StringBuilder();

            while (asciiValue > 0) {
                int remainder = asciiValue % 2;
                asciiValue = asciiValue / 2;
                binaryValue.insert(0, remainder); // prepend the remainder
            }

            // Ensure that the binary value is 8 bits long
            while (binaryValue.length() < 8) {
                binaryValue.insert(0, "0"); // prepend '0' to make it 8 bits
            }
            // ! Debugging purposes
            // Print the character, ASCII value, and binary value
            System.out.println("Character: " + character + " ASCII value: " + (int) character + " Binary value: " + binaryValue.toString());

            binaryString.append(binaryValue).append(" ");
        }
        return binaryString.toString().trim();
    }
}
