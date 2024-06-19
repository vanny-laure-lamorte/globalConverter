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
        }


        // Only lowercase or uppercase letters
        public static boolean isValidText(String base) {
            return base.matches("[a-zA-Z]*");
        }

        // Numbers between 0 and 7
        public static boolean isValidOctal(String base) {
            return base.matches("[0-7]+");
        }

        // Only 0 and 1, min 8 numbers
        public static boolean isValidBinary(String base) {
            return base.matches("[01]{8,}");
        }

        public static boolean isValidHexadecimal(String base) {
            return base.matches("[a-zA-Z0-9 ]+");
        }

        // Only 0 and 9
        public static boolean isValidDecimal(String base) {
            return base.matches("[0-9]+");
        }
 
    }
    
    }
    
