package src;

public class Translate {
    /*
     * Class to convert a string that is passed as an argument to binary
     * First, we convert the string with ASCII values
     * Then, we convert the ASCII values to binary using Integer.toBinaryString
     * Finally, we concatenate the binary values to get the final binary string
    */
    
    public static String translateTowardBinary(String inputString, char baseType){
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

        switch (baseType) {
            case 't':
                return "";
            case 'h':
                return binaryToHex(binaryString.toString().trim().replace(" ", ""));
            case 'o':
                return binaryToOctal(binaryString.toString().trim().replace(" ", ""));
            case 'd':
                return String.valueOf(binaryToDecimal(binaryString.toString().trim().replace(" ", "")));
            case 'b':
                return binaryString.toString().trim();
            default:
                return "Invalid base type";
        }
    }

    public static int binaryToDecimal(String binary) {
        /*
         * Method to convert a binary string to a decimal number
         * We start from the rightmost bit and multiply it by 2^0, 2^1, 2^2, and so on
         * We add the results to get the decimal number
         */
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static String binaryToOctal(String binary) {
        // Convert binary to octal
        // Pad the binary string with leading zeros to make its length a multiple of 3
        int len = binary.length();
        int padLength = (3 - (len % 3)) % 3;
        for (int i = 0; i < padLength; i++) {
            binary = "0" + binary;
        }

        // Group the bits in sets of 3 and convert each group to an octal digit
        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            String group = binary.substring(i, i + 3);
            int decimalValue = Integer.parseInt(group, 2);  // Convert binary group to decimal
            octal.append(Integer.toString(decimalValue, 8)); // Convert decimal to octal and append
        }

        return octal.toString();
    }

    public static String binaryToHex(String binary) {
        // Convert binary to hexadecimal
        int len = binary.length();
        int padLength = (4 - (len % 4)) % 4;
        for (int i = 0; i < padLength; i++) {
            binary = "0" + binary;
        }
    
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 4) {
            String group = binary.substring(i, i + 4);
            int decimalValue = Integer.parseInt(group, 2);  // Convert binary group to decimal
            String hexValue = Integer.toString(decimalValue, 16).toUpperCase(); // Convert decimal to hex
            hex.append(hexValue);
        }
    
        // Insert space every two characters
        for (int j = 2; j < hex.length(); j += 3) {
            hex.insert(j, " ");
        }
    
        return hex.toString();
    }
}

