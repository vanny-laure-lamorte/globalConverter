package src;
public class InputUser {
    public class InputValidator {


        // Validate string type
        public static boolean isValidBaseFrom(String base) {
            return base.matches("text|t|hexadecimal|h|octal|o|decimal|d|binary|b");
        } 
        
        // Validate translation base 
        public static boolean isValidBaseTo(String base) {
            return base.matches("text|t|hexadecimal|h|octal|o|decimal|d|binary|b|return|r");
        } 

        // Validate only lowercase, uppercase letters and spaces
        public static boolean isValidText(String base) {
            return base.matches("[a-zA-Z0-9 ]+");
        }

        // Validate only numbers between 0 and 7 and spaces
        public static boolean isValidOctal(String base) {
            return base.matches("[0-7 ]+");
        }

        // Validate only numbers between 0 and 1, space and the input should have min 8 numbers
        public static boolean isValidBinary(String base) {
            return base.matches("[01 ]{8,}");
        }

        //  Validate only numbers between 0 and 9, lowercase and uppercase letters and spaces
        public static boolean isValidHexadecimal(String base) {
            return base.matches("[a-zA-Z0-9 ]+");
        }

        // Validate only numbers between 0 and 9 and spaces
        public static boolean isValidDecimal(String base) {
            return base.matches("[0-9 ]+");
        }

        // Validate the user input depending on the type of string he wants to translate
        public static boolean isValidInputUser(String input, String inputBaseFrom) {
            switch (inputBaseFrom.toLowerCase()) {
                case "text":
                case "t":
                    return InputValidator.isValidText(input);
                case "octal":
                case "o":
                    return InputValidator.isValidOctal(input);
                case "Binary":
                case "binary":
                case "b":
                    return InputValidator.isValidBinary(input);
                case "hexadecimal":
                case "h": 
                return InputValidator.isValidHexadecimal(input);
                case "decimal":
                case "d": 
                return InputValidator.isValidDecimal(input);              
                default:
                    return false;
            }
        }

    }
    
    }
    
