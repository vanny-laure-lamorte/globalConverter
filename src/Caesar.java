package src;

public class Caesar {

    public static String convertToBinary(int number) {
        if (number == 0) return "0";
        StringBuilder binaryString = new StringBuilder();
        while (number > 0) {
            binaryString.append(number % 2);
            number = number / 2;
        }
        return binaryString.reverse().toString();
    }

    public static String padBinaryString(String binary, int length) {
        StringBuilder padded = new StringBuilder();
        for (int i = 0; i < length - binary.length(); i++) {
            padded.append('0');
        }
        padded.append(binary);
        return padded.toString();
    }

    public static String addBinaryStrings(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

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

    public static String encryption(String inputString, int offset) {

        // Convert the inputString to a binary
        String binaryString = Translate.translateTowardBinary(inputString, 'b');

        // Convert the offset to a binary     
        String binaryOffset = convertToBinary(offset);

        // Pad the binary strings to the same length
        int maxLength = Math.max(binaryString.length(), binaryOffset.length());
        String paddedBinaryString = padBinaryString(binaryString, maxLength);
        String paddedBinaryOffset = padBinaryString(binaryOffset, maxLength);

        // Add the binary strings
        String addedBinaryString = addBinaryStrings(paddedBinaryString, paddedBinaryOffset);

        // Apply the Caesar cipher shift on the binary string.
        StringBuilder shifted = new StringBuilder();
        for (int i = 0; i < addedBinaryString.length(); i++) {
            char c = addedBinaryString.charAt(i);
           // System.out.println("char c: " + c);

            if (c == '0' || c == '1') {
                int originalValue = c - '0';
                int shiftedValue = (originalValue + offset) % 2;
                char shiftedChar = (char) ('0' + shiftedValue);
                shifted.append(shiftedChar);
            } else {
                shifted.append(c);
            }
        }

        // Convert the shifted binary string back to text 
        String results = Translate.binaryToText(shifted.toString());

        // Display messages
        System.out.println("2. Input string to Binary: " + binaryString);
        System.out.println("3. Shifted binary string: " + shifted.toString().trim());

        System.out.println("\nYour string before Caesar Cipher: " + inputString);
        System.out.println("Your string after Caesar Cipher with " + offset + " as a shift value: " + results + "\n");
        
        return shifted.toString();
    }

}
