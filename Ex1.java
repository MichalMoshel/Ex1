package assignments.ex1;


/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) {
            return -1; // Invalid number format
        }
        String[] parts = num.split("b");
        String numberPart = parts[0];
        String basePart = parts[1];

        // Determine base
        int base;
        char baseChar = basePart.charAt(0);
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0';
        } else {
            base = 10 + (baseChar - 'A');
        }

        int ans = 0;
        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i);
            int digit = (c >= '0' && c <= '9') ? c - '0' : 10 + (c - 'A');
            ans = ans * base + digit;
        }
        return ans;
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }
        int bIndex = a.indexOf('b');
        if (bIndex == -1 || bIndex == 0 || bIndex == a.length() - 1) {
            return false; // 'b' not present, at the start, or at the end
        }
        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        // Validate base
        int base = 0;
        if (basePart.length() == 1) {
            char baseChar = basePart.charAt(0);
            if (baseChar >= '2' && baseChar <= '9') {
                base = baseChar - '0'; // Bases 2-9
            } else if (baseChar >= 'A' && baseChar <= 'F') {
                base = 10 + (baseChar - 'A'); // Bases 10-16
            } else {
                return false; // Invalid base
            }
        } else {
            return false; // Base part must be a single character
        }

        // Validate number part
        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i);
            int num;
            if (c >= '0' && c <= '9') {
                num = c - '0'; // Numeric value
            } else if (c >= 'A' && c <= 'F') {
                num = 10 + (c - 'A'); // Alphabetic value
            } else {
                return false; // Invalid character
            }
            if (num >= base) {
                return false; // Digit out of base range
            }
        }
        return true;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */

    public static String int2Number(int num, int base) {
        // Initialize the result string
        String ans = "";

        // Validate input
        if (num < 0 || base < 2 || base > 16) {
            return ans; // Return empty string for invalid input
        }

        // Handle the zero case
        if (num == 0) {
            return "0b" + base; // Representation of 0 in any base
        }

        // Conversion logic
        String numPart = "";
        int currentNum = num;

        while (currentNum > 0) {
            int divisionRemainder = currentNum % base;

            // For bases greater than 10, convert remainder to appropriate character
            if (divisionRemainder >= 10) {
                numPart = (char) ('A' + (divisionRemainder - 10)) + numPart;
            } else {
                numPart = divisionRemainder + numPart;
            }

            currentNum = currentNum / base; // Update the number
        }

        // Determine base representation
        String basePart = "";
        if (base >= 2 && base <= 9) {
            basePart = String.valueOf(base); // Convert base to string
        } else if (base >= 10 && base <= 16) {
            basePart = "" + (char) ('A' + (base - 10)); // Convert base to corresponding letter
        }

        // Combine the number and base parts
        ans = numPart + "b" + basePart;

        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;
        }

        // Validate and convert n1 and n2 using number2Int (or similar)
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);

        return num1 == num2;
    }
    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                int value = number2Int(arr[i]);
                if (value != -1 && value > max) {
                    max = value;
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }


    /**
     * This function extracts the number and base from the string in format <number><b><base>.
     * Assumes the input format is correct and validated already.
     *
     * @param input the input string in the format <number><b><base>
     * @return an array with two elements: the number and the base as integers.
     */
    public static int[] extractNumberAndBase(String input) {
        // Find the position of the 'b' character
        int bIndex = input.indexOf('b');

        // Separate the number and base parts
        String numberPart = input.substring(0, bIndex); // Extract number part before 'b'
        String basePart = input.substring(bIndex + 1);  // Extract base part after 'b'

        // Convert the number part to an integer
        int number = Integer.parseInt(numberPart);

        // Convert the base part to an integer
        int base = Integer.parseInt(basePart);

        // Return an array containing the number and the base
        return new int[]{number, base};
    }
}










