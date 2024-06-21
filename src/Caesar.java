package src;
public class Caesar {
    

    
    public static String encryption(String inputString, int offset) {



        StringBuilder shifted = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            if (c == '0' || c == '1') {
                char shiftedChar = (char)(((c - '0' + offset) % 2) + '0');
                shifted.append(shiftedChar);
            } else {
                shifted.append(c); 
            }
        }

        return shifted.toString();

    }

    
}
