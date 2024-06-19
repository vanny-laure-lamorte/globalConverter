package src;

public class StringTOBinary {
    /*
     * Class to convert a string that is passed as an argument to binary
     * First, we convert the string with ascii values
     * Then, we convert the ascii values to binary using Integer.toBinaryString
     * Finally, we concatenate the binary values to get the final binary string
    */
    
    public static String translateTowardBinary(String args){
        String inputString = args;
        System.out.println("String to translate: " + inputString);
        StringBuilder binaryString = new StringBuilder();
        
        for (int chara = 0; chara < inputString.length(); chara++) {
            // Convert the character to an ASCII value
            char character = inputString.charAt(chara);
            int asciiValue = (int) character;
            // Convert the ASCII value to binary
            String binaryValue = Integer.toBinaryString(asciiValue);
            System.out.println("ASCII value: " + asciiValue + " Binary value: " + binaryValue);

            // Ensure that the binary value is 8 bits long
            while (binaryValue.length() < 8) {
                binaryValue = "0" + binaryValue;
            }

            binaryString.append(binaryValue).append(" ");
        }
        return binaryString.toString().trim();
    }
}
