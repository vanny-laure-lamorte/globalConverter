package src;

public class Translate {
    /*
     * Class to convert a string that is passed as an argument to binary
     * First, we convert the string with ASCII values
     * Then, we convert the ASCII values to binary using Integer.toBinaryString
     * Finally, we concatenate the binary values to get the final binary string
     */

    public static String translateTowardBinary(String inputString, char baseType) {
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
            System.out.println("Character: " + character + " ASCII value: " + (int) character + " Binary value: "
                    + binaryValue.toString());

            binaryString.append(binaryValue).append(" ");
        }

        switch (baseType) {
            case 't':
                return binaryToText(binaryString.toString().trim().replace(" ", ""));
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

    public static String binaryToDecimal(String binary) {
        /*
         * Method to convert a binary string to a decimal number
         * We start from the rightmost bit and multiply it by 2^0, 2^1, 2^2, and so on
         * We add the results to get the decimal number
         */
        StringBuilder result = new StringBuilder();

        // Iterate through the binary string in chunks of 8 bits
        for (int i = 0; i < binary.length(); i += 8) {
            String eightBits = binary.substring(i, Math.min(i + 8, binary.length()));

            // Convert the 8-bit binary string to decimal
            int decimalValue = 0;
            int power = 0;

            // Calculate the decimal value of the 8-bit binary string
            for (int j = eightBits.length() - 1; j >= 0; j--) {
                int character = eightBits.charAt(j) - '0'; // Convert char to int (either 0 or 1)
                decimalValue += character * Math.pow(2, power);
                power++;
            }

            result.append(decimalValue).append(" ");
        }

        return result.toString().trim();
    }

    public static String binaryToOctal(String binary) {
        // Check if the binary string is a multiple of 8
        if (binary.length() % 8 != 0) {
            throw new IllegalArgumentException("La chaîne binaire doit avoir une longueur multiple de 8 bits.");
        }

        // Variable used to store the octal result
        StringBuilder octalResult = new StringBuilder();

        // Parse the binary string in 8-bit segments
        for (int i = 0; i < binary.length(); i += 8) {
            // Extract an 8-bit segment
            String byteSegment = binary.substring(i, i + 8);

            // Add padding if the segment is less than 8 bits
            int len = byteSegment.length();
            int padLength = (3 - (len % 3)) % 3;
            for (int j = 0; j < padLength; j++) {
                byteSegment = "0" + byteSegment;
            }

            // Convert the 8-bit segment to octal
            StringBuilder octal = new StringBuilder();
            for (int k = 0; k < byteSegment.length(); k += 3) {
                // Extraire un groupe de 3 bits manuellement
                int octalDigit = 0;
                if (byteSegment.charAt(k) == '1') {
                    octalDigit += 4;
                }
                if (byteSegment.charAt(k + 1) == '1') {
                    octalDigit += 2;
                }
                if (byteSegment.charAt(k + 2) == '1') {
                    octalDigit += 1;
                }
                octal.append(octalDigit);
            }

            // Add the octal result to the final string
            octalResult.append(octal);
        }

        // Insert space every three characters
        for (int j = 3; j < octalResult.length(); j += 4) {
            octalResult.insert(j, " ");
        }

        // Retourn the octal result
        return octalResult.toString();
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
            int decimalValue = Integer.parseInt(group, 2); // Convert binary group to decimal
    
            // Manually convert decimal to hexadecimal
            StringBuilder hexDigit = new StringBuilder();
            do {
                int remainder = decimalValue % 16;
                if (remainder < 10) {
                    hexDigit.insert(0, (char) ('0' + remainder)); // Convert to char '0'-'9'
                } else {
                    hexDigit.insert(0, (char) ('A' + (remainder - 10))); // Convert to char 'A'-'F'
                }
                decimalValue /= 16;
            } while (decimalValue != 0);
            
            hex.append(hexDigit);
        }
    
        // Insert space every two characters
        for (int j = 2; j < hex.length(); j += 3) {
            hex.insert(j, " ");
        }
    
        return hex.toString();
    }
    
    public static String binaryToText(String binary) {
        // Convert binary to text
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String group = binary.substring(i, i + 8);
            int decimalValue = Integer.parseInt(group, 2); // Convert binary group to decimal
            text.append((char) decimalValue);
        }
        return text.toString();
    }
}
