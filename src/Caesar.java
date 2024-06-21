package src;
public class Caesar {

    public static String encryption(String inputString, int offset) {

        // Convert the inputString to a binary
        String binaryString = Translate.translateTowardBinary(inputString, 'b');

        // Apply the Caesar cipher shift on the binary string.
        StringBuilder shifted = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            System.out.println("char c: "+c);

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
        System.out.println("1. Your string before Caesar Cipher: " + inputString);
        System.out.println("2. Input string to Binary: " + binaryString);
        System.out.println("3. Shifted binary string: " + shifted.toString().trim());
        System.out.println("4. Your string after Caesar Cipher with " + offset + " as a shift value: " + results);

        return shifted.toString();
    }
}

