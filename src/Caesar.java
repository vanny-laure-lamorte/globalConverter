package src;
public class Caesar {  
    
    public static String encryption(String binary, int offset) {
        StringBuilder shifted = new StringBuilder();
        
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            
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