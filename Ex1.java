package assignments.ex1;

/**
 * This class represents a simple solution for Ex1.
 * This solution involves number formatting converters and calculators.
 * The number format is based on a string representation with a "b" for the base.
 * Valid bases are between 2 and 16, with values for 10-16 represented by A-G.
 */

public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * Returns -1 if the number is in an invalid format.
     *
     * @param num a String representing a number in basis [2,16]
     * @return the decimal value of the number or -1 if invalid
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) { // Check if the input is valid using isNumber().
            return -1; // Invalid number format, return -1.
        }
        if (num.indexOf('b') == -1) { // If no 'b' is found, assume it's a decimal number.
            return Integer.parseInt(num); // Parse and return as a decimal integer.
        }
        String[] parts = num.split("b"); // Split the input into <numberPart> and <basePart>.
        String numberPart = parts[0]; // Extract the numeric part.
        String basePart = parts[1]; // Extract the base part.

        int base; // Variable to store the base.
        char baseChar = basePart.charAt(0); // Get the base character.
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0'; // Convert digit base to integer.
        } else {
            base = 10 + (baseChar - 'A'); // Convert letter base (A-G) to integer.
        }

        int ans = 0; // Initialize result to accumulate the decimal value.
        for (int i = 0; i < numberPart.length(); i++) { // Iterate over the number part.
            char c = numberPart.charAt(i); // Get each character.
            int digit = (c >= '0' && c <= '9') ? c - '0' : 10 + (c - 'A'); // Map to its value.
            ans = ans * base + digit; // Accumulate using base arithmetic.
        }
        return ans; // Return the final decimal value.
    }

    /**
     * Check if the given string is in a valid number format.
     *
     * @param a a String representing a number
     * @return true if the string is in a valid number format, false otherwise
     */

    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) { // Check if the input is null or empty.
            return false; // Invalid format.
        }

        // If there are any spaces in the string, it's invalid
        if (a.contains(" ")) {
            return false; // Return false if there's a space anywhere in the string.
        }

        int bIndex = a.indexOf('b'); // Locate the 'b' indicating the base.
        if (bIndex == -1) { // If no 'b', check for a decimal number.
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i); // Check each character.
                if (c < '0' || c > '9') { // Ensure all are digits.
                    return false; // Non-digit character found.
                }
            }
            return true; // Valid decimal number.
        }

        // Invalid placement of 'b' (it must not be at the beginning or end, and no extra 'b' allowed).
        if (bIndex == 0 || bIndex == a.length() - 1 || a.indexOf('b', bIndex + 1) != -1) {
            return false;
        }

        String numberPart = a.substring(0, bIndex); // Extract the number part.
        String basePart = a.substring(bIndex + 1); // Extract the base part.

        if (basePart.length() != 1) { // Base part must be exactly one character.
            return false;
        }

        int base;
        char baseChar = basePart.charAt(0);
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0'; // Digit base (2-9).
        } else if (baseChar >= 'A' && baseChar <= 'G') {
            base = 10 + (baseChar - 'A'); // Letter base (A-G).
        } else {
            return false; // Invalid base character.
        }

        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i); // Check each character in number part.
            int num = (c >= '0' && c <= '9') ? c - '0' : 10 + (c - 'A'); // Map to its value.
            if (num >= base) { // Ensure it's valid within the base.
                return false;
            }
        }
        return true; // Valid number format.
    }


    /**
     * Convert the given natural number (num) into a string representation in the specified base.
     * @param num  the natural number
     * @param base the base (between 2 and 16)
     * @return a string representing the number in the given base
     */

    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) { // Validate inputs.
            return ""; // Return empty string for invalid input.
        }
        if (num == 0) { // Special case: zero.
            return "0b" + base;
        }

        String numPart = ""; // String to accumulate the converted number.
        while (num > 0) { // Convert to the specified base.
            int remainder = num % base; // Get the remainder.
            if (remainder >= 10) {
                numPart = (char) ('A' + (remainder - 10)) + numPart; // Map to A-F for bases > 10.
            } else {
                numPart = remainder + numPart; // Append digit.
            }
            num /= base; // Reduce the number.
        }

        // Convert base 16 to 'G', base 15 to 'F', etc.
        char baseChar = (base == 16) ? 'G' : (base == 15) ? 'F' : (base == 14) ? 'E' : (base == 13) ? 'D' :
                (base == 12) ? 'C' : (base == 11) ? 'B' : (char) ('0' + base); // Handle special cases.

        return numPart + "b" + baseChar; // Format result with 'b' before base character.
    }


    /**
     * Check if the two numbers are equal.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers are equal
     */
    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) { // Check for null inputs.
            return false;
        }
        return number2Int(n1) == number2Int(n2); // Compare their decimal values.
    }

    /**
     * Find the index of the largest number in the array (by value).
     *
     * @param arr an array of numbers
     * @return the index of the largest number
     */
    public static int maxIndex(String[] arr) {
        int max = -1; // Variable to track the maximum value.
        int maxIndex = -1; // Variable to track the index of the maximum value.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) { // Skip null elements.
                int value = number2Int(arr[i]); // Convert to decimal.
                if (value != -1 && value > max) { // Check if it's a new maximum.
                    max = value;
                    maxIndex = i;
                }
            }
        }
        return maxIndex; // Return the index of the largest number.
    }
}
