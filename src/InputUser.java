package src;
public class InputUser {
    public class InputValidator {
        public static boolean isValidString(String input) {

            // Verify if input contains only alphabets / numerics / space
            return input.matches("[a-zA-Z0-9 ]+");
        }
    
        public static boolean isValidBase(String base) {
            // Validate base input
            return base.matches("text|t|hexadecimal|h|octal|o|decimal|d|binary|b|return|r");
         //   return base.matches("text|Text|t|hexadecimal|Hexadecimal|h|octal|Octal|o|decimal|Decimal|d|binary|Binary|b|return|Return|r");
        }
    }
    
    }
    
