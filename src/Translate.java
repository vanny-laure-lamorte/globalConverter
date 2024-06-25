package src;

public class Translate {
    /*
     * Class to convert a string that is passed as an argument to binary
     * First, we convert the string with ASCII values
     * Then, we convert the ASCII values to binary manually
     * Finally, we concatenate the binary values to get the final binary string
     */

    public static String translateTowardBinary(char inputBaseFrom, String inputString, char baseType) {
        String binaryString = "";
        switch (inputBaseFrom) {
            case 't':
                binaryString = textToBinary(inputString);
                break;
            case 'h':
                binaryString = hexToBinary(inputString);
                break;
            case 'o':
                binaryString = octalToBinary(inputString);
                break;
            case 'd':
                binaryString = decimalToBinary(inputString);
                break;
            case 'b':
                binaryString = binaryToBinary(inputString);
                break;
            default:
                return "Invalid input base type";
        }

        switch (baseType) {
            case 't':
                return binaryToText(binaryString.replace(" ", ""));
            case 'h':
                return binaryToHex(binaryString.replace(" ", ""));
            case 'o':
                return binaryToOctal(binaryString.replace(" ", ""));
            case 'd':
                return binaryToDecimal(binaryString.replace(" ", ""));
            case 'b':
                return binaryString.trim();
            default:
                return "Invalid base type";
        }
    }

    // Translate text to binary
    public static String textToBinary(String inputString) {
        StringBuilder binaryString = new StringBuilder();
        for (int chara = 0; chara < inputString.length(); chara++) {
            char character = inputString.charAt(chara);
            int asciiValue = (int) character;
            StringBuilder binaryValue = new StringBuilder();
            while (asciiValue > 0) {
                int remainder = asciiValue % 2;
                asciiValue = asciiValue / 2;
                binaryValue.insert(0, remainder);
            }
            while (binaryValue.length() < 8) {
                binaryValue.insert(0, "0");
            }
            binaryString = binaryString.append(binaryValue).append(" ");
        }
        return binaryString.toString().trim();
    }

    // Translate hexadecimal to binary
    public static String hexToBinary(String hex) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            char hexDigit = hex.charAt(i);
            int value = hexDigitToDecimal(hexDigit);
            String binaryDigit = decimalToBinaryString(value, 4);
            binary.append(binaryDigit);
        }
        return binary.toString();
    }

    // Translate octal to binary
    public static String octalToBinary(String octal) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < octal.length(); i += 3) {
            int value = 0;
            String octalDigit = octal.substring(i, i + 3);

            int intOctal = Integer.parseInt(octalDigit);

            value = octalToDecimal(intOctal);
            String binaryDigit = decimalToBinaryString(value, 8);
            binary.append(binaryDigit);
        }
        return binary.toString();
    }

    // Translate decimal to binary
    public static String decimalToBinary(String decimal) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < decimal.length(); i++) {
            char decimalDigit = decimal.charAt(i);
            int value = decimalDigitToDecimal(decimalDigit);
            String binaryDigit = decimalToBinaryString(value, 4);
            binary.append(binaryDigit);
        }
        return binary.toString();
    }

    // Return binary of binary is chosen
    public static String binaryToBinary(String binary) {
        return binary;
    }

    // Translate binary to text
    public static String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String byteString = binary.substring(i, i + 8);
            int charCode = binaryStringToDecimal(byteString);
            text.append((char) charCode);

        }
        return text.toString();
    }

    // Translate binary to hexadecimal
    public static String binaryToHex(String binary) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String nibble = binary.substring(i, i + 8);
            int value = binaryStringToDecimal(nibble);
            hex.append(decimalToHexDigit(value) + " ");
        }
        // Insert space every three characters
        for (int j = 3; j < hex.length(); j += 4) {
            hex.insert(j, " ");
        }
        return hex.toString();
    }

    // Translate binary to octal
    public static String binaryToOctal(String binary) {
        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String octet = binary.substring(i, Math.min(i + 8, binary.length()));
            int value = binaryStringToDecimal(octet);
            octal.append(decimalToOctalDigit(value) + " ");
        }
        return octal.toString();
    }

    // Translate binary to decimal
    public static String binaryToDecimal(String binary) {
        StringBuilder decimal = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 8) {
            String octet = binary.substring(i, Math.min(i + 8, binary.length()));
            int value = binaryStringToDecimal(octet);
            // insert space every three characters
            decimal.append(value + " ");
        }
        return decimal.toString();
    }

    // Translate hexadecimal to decimal
    private static int hexDigitToDecimal(char hexDigit) {
        if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit - '0';
        } else if (hexDigit >= 'A' && hexDigit <= 'F') {
            return 10 + (hexDigit - 'A');
        } else if (hexDigit >= 'a' && hexDigit <= 'f') {
            return 10 + (hexDigit - 'a');
        } else {
            throw new IllegalArgumentException("Invalid hexadecimal digit: " + hexDigit);
        }
    }

    // Translate octal to decimal
    private static int octalToDecimal(int octal) {
        int decimal = 0;
        int power = 0;

        // Convert the octal number to a string for easier processing
        String octalString = String.valueOf(octal);

        // Traverse the digits of the octal number from right to left
        for (int i = octalString.length() - 1; i >= 0; i--) {
            int octalDigit = octalString.charAt(i) - '0';

            // Check that each digit is valid (between 0 and 7)
            if (octalDigit < 0 || octalDigit > 7) {
                throw new IllegalArgumentException("Invalid octal digit: " + octalDigit);
            }

            // Add the decimal value of the octal digit to the corresponding position
            decimal += octalDigit * Math.pow(8, power);
            power++;
        }

        return decimal;
    }

    // Translate decimal to decimal
    private static int decimalDigitToDecimal(char decimalDigit) {
        if (decimalDigit >= '0' && decimalDigit <= '9') {
            return decimalDigit - '0';
        } else {
            throw new IllegalArgumentException("Invalid decimal digit: " + decimalDigit);
        }
    }

    // Translate decimal to binary
    private static String decimalToBinaryString(int value, int bits) {
        StringBuilder binaryValue = new StringBuilder();
        while (value > 0) {
            int remainder = value % 2;
            value = value / 2;
            binaryValue.insert(0, remainder);
        }
        while (binaryValue.length() < bits) {
            binaryValue.insert(0, "0");
        }
        return binaryValue.toString();
    }

    // Translate binary to decimal
    private static int binaryStringToDecimal(String binaryString) {
        int decimalValue = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char bit = binaryString.charAt(i);

            if (bit == '1') {
                decimalValue += Math.pow(2, power);
            }
            power++;
        }
        return decimalValue;
    }

    // Translate binary to hexadecimal
    private static String decimalToHexDigit(int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Decimal number must be non-negative: " + decimal);
        }

        StringBuilder hex = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 16;

            if (remainder < 10) {
                hex.insert(0, (char) ('0' + remainder));
            } else {
                hex.insert(0, (char) ('A' + (remainder - 10)));
            }
            decimal /= 16;
        }

        // Handle the case when the number is 0
        if (hex.length() == 0) {
            hex.append('0');
        }
        return hex.toString();
    }

    // Translate decimal to octal
    private static String decimalToOctalDigit(int decimal) {
        if (decimal >= 0 && decimal <= 7) {
            return Character.toString((char) ('0' + decimal)); // If the number is already a single octal digit (0-7), return it directly

        } else {
            StringBuilder octal = new StringBuilder();
            while (decimal > 0) {
                int remainder = decimal % 8; // Get the remainder of the division by 8

                octal.insert(0, (char) ('0' + remainder)); // Insert the octal digit at index 0
                decimal /= 8; // Update the quotient for the next division
            }
            return octal.toString(); // Convert the StringBuilder to a String before returning
        }
    }
}