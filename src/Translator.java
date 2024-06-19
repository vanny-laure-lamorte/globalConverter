package src;

public class Translator {

    public static void main(String[] args) {
        // Normal
        String[] normal = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", // digits 0-9
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", // letters A-Z
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" // letters a-z
        };

        // Decimal
        String[] decimal = {
            "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", // digits 0-9
            "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", // letters A-Z
            "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122" // letters a-z
        };

        // Octal
        String[] octal = {
            "060", "061", "062", "063", "064", "065", "066", "067", "070", "071", // digits 0-9
            "101", "102", "103", "104", "105", "106", "107", "110", "111", "112", "113", "114", "115", "116", "117", "120", "121", "122", "123", "124", "125", "126", "127", "130", "131", "132", // letters A-Z
            "141", "142", "143", "144", "145", "146", "147", "150", "151", "152", "153", "154", "155", "156", "157", "160", "161", "162", "163", "164", "165", "166", "167", "170", "171", "172" // letters a-z
        };

        // Hexadecimal
        String[] hexadecimal = {
            "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", // digits 0-9
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", // letters A-Z
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A" // letters a-z
        };

        // Binary
        String[] binary = {
            "0110000", "0110001", "0110010", "0110011", "0110100", "0110101", "0110110", "0110111", "0111000", "0111001", // digits 0-9
            "1000001", "1000010", "1000011", "1000100", "1000101", "1000110", "1000111", "1001000", "1001001", "1001010", "1001011", "1001100", "1001101", "1001110", "1001111", "1010000", "1010001", "1010010", "1010011", "1010100", "1010101", "1010110", "1010111", "1011000", "1011001", "1011010", // letters A-Z
            "1100001", "1100010", "1100011", "1100100", "1100101", "1100110", "1100111", "1101000", "1101001", "1101010", "1101011", "1101100", "1101101", "1101110", "1101111", "1110000", "1110001", "1110010", "1110011", "1110100", "1110101", "1110110", "1110111", "1111000", "1111001", "1111010" // letters a-z
        };

        
    }

}