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
        if (!isNumber(num)) {
            return -1; // Invalid number format
        }
if(num.indexOf('b')==-1){
    return Integer.parseInt(num);
}
        // Split into the number part and base part
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

        // Convert the number part into an integer based on the base
        int ans = 0;
        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i);
            int digit = (c >= '0' && c <= '9') ? c - '0' : 10 + (c - 'A');
            ans = ans * base + digit;
        }
        return ans;
    }

    /**
     * Check if the given string is in a valid number format.
     *
     * @param a a String representing a number
     * @return true if the string is in a valid number format, false otherwise
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }

        // Trim whitespaces from both ends
       //f a = a.trim();

        // If there is no 'b', check if it's a decimal number
        int bIndex = a.indexOf('b');
        if (bIndex == -1) {
            // No 'b', check if the string contains only digits
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;  // All characters are digits
        }

        // If 'b' is in an incorrect position (start or end) or appears more than once
        if (bIndex == 0 || bIndex == a.length() - 1 || a.indexOf('b', bIndex + 1) != -1) {
            return false;
        }

        // Split the string into the number part and the base part
        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        // The base part must contain exactly one character
        if (basePart.length() != 1) {
            return false;
        }

        int base;
        char baseChar = basePart.charAt(0);

        // If the base is between 2 and 9
        if (baseChar >= '2' && baseChar <= '9') {
            base = baseChar - '0'; // Convert the character to an integer base
        }
        // If the base is between A and G
        else if (baseChar >= 'A' && baseChar <= 'G') {
            base = 10 + (baseChar - 'A'); // Convert letters A-F to bases 10-15
        } else {
            return false;  // Invalid base
        }

        // Check if each character in the number part is valid for the base
        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i);
            int num = 0;

            // Check if the character is a valid digit or letter for the base
            if (c >= '0' && c <= '9') {
                num = c - '0';  // Convert digits 0-9
            } else if (c >= 'A' && c <= 'G') {
                num = c - 'A' + 10;  // Convert letters A-G to 10-15
            }else{
                return false;
            }


            // If the number is greater than or equal to the base, it's invalid
            if (num >= base) {
                return false;
            }
        }

        return true;  // Valid number format
    }




    /**
     * Convert the given natural number (num) into a string representation in the specified base.
     *
     * @param num  the natural number
     * @param base the base (between 2 and 16)
     * @return a string representing the number in the given base
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return ""; // Return empty string for invalid input
        }

        // Handle zero case
        if (num == 0) {
            return "0b" + base;
        }

        // Convert number to string in given base
        String numPart = "";
        while (num > 0) {
            int remainder = num % base;
            if (remainder >= 10) {
                numPart = (char) ('A' + (remainder - 10)) + numPart;
            } else {
                numPart = remainder + numPart;
            }
            num /= base;
        }

        // Return the final formatted string
        return numPart + "b" + (base < 10 ? base : (char) ('A' + (base - 10)));
    }

    /**
     * Check if the two numbers are equal.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers are equal
     */
    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;
        }

        return number2Int(n1) == number2Int(n2);
    }

    /**
     * Find the index of the largest number in the array (by value).
     *
     * @param arr an array of numbers
     * @return the index of the largest number
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
}
