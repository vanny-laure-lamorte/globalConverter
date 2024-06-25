package src;

public class Caesar {
    // Method to convert a decimal number to binary string
    public static String convertToBinary(int number) {
        if (number == 0)
            return "0";
        StringBuilder binaryString = new StringBuilder();
        while (number > 0) {
            binaryString.append(number % 2);
            number = number / 2;
        }
        return binaryString.reverse().toString();
    }

    // Method to pad a binary string to a specified lenght with leading zeros
    public static String padBinaryString(String binary, int length) {
        StringBuilder padded = new StringBuilder();
        for (int i = 0; i < length - binary.length(); i++) {
            padded.append('0');
        }
        padded.append(binary);
        return padded.toString();
    }

    // Method to add two binary strings
    public static String addBinaryStrings(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Traverse the binary strings from right to left
        for (int i = binary1.length() - 1; i >= 0; i--) {
            int bit1 = binary1.charAt(i) - '0';
            int bit2 = binary2.charAt(i) - '0';

            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    // Method to perform encryption using Caesar Cipher with binary manipulation
    public static String encryption(String inputString, int offset, char baseFrom, char baseType) {
        String inputBinary = Translate.translateTowardBinary(baseFrom, inputString, baseType);

        // Convert the offset to an 8-bit binary
        String binaryOffset = padBinaryString(convertToBinary(offset), 8);

        // Split the inputBinary into octets and apply the offset
        StringBuilder addedBinaryString = new StringBuilder();
        String[] octets = inputBinary.split(" ");
        for (String octet : octets) {
            if (!octet.isEmpty()) {
                if (octet.equals("00100000")) { // Check if the octet is an ASCII space
                    addedBinaryString.append(octet).append(" ");
                } else {
                    String addedOctet = addBinaryStrings(octet, binaryOffset);
                    addedBinaryString.append(addedOctet).append(" ");
                }
            }
        }
        String finalBinaryString = addedBinaryString.toString().trim().replace(" ", "");

        // Convert the shifted binary string back to text
        String results = Translate.binaryToText(finalBinaryString);

        // Display messages
        System.out.println("\nYour string before Caesar Cipher: " + inputString);
        System.out.println("Your string after Caesar Cipher with " + offset + " as a shift value: " + results + "\n");

        return results.toString();
    }
}
