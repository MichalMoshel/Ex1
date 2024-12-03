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
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            // check if the number is in the format
            if (isNumber(num) == true) {
                //  split into number and base parts
                String[] arr = num.split("b");
                String numberPart = arr[0];
                String basePart = arr[1];
                //  Validate the base
                int base = 0;
                if (basePart.length() == 1) {
                    char baseChar = basePart.charAt(0);
                    if (baseChar >= '2' && baseChar <= '9') {
                        base = baseChar - '0'; // Numeric base 2-9  // Base part must be a single character
                    } else if (baseChar >= 'A' && baseChar <= 'G') {
                        base = 10 + (baseChar - 'A'); // Letter base 10-16
                    }
                    ans = Integer.parseInt(numberPart, base);
                }

                return ans;
            }



        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
            public static boolean isNumber(String a){
                boolean ans = true;

                //  Check if the string is null or empty
                if (a == null || a.isEmpty()) {
                   return false;
                }

                //  Ensure the input contains 'b' and split into number and base parts
                int bIndex = a.indexOf('b');
                if (bIndex == -1 || bIndex == 0 || bIndex == a.length() - 1) {
                    return ans; // 'b' not present, at the start, or at the end
                }

                String numberPart = a.substring(0, bIndex); // The part before 'b'
                String basePart = a.substring(bIndex + 1); // The part after 'b'

                // Step 3: Validate the base
                int base = 0;
                if (basePart.length() == 1) {
                    char baseChar = basePart.charAt(0);
                    if (baseChar >= '2' && baseChar <= '9') {
                        base = baseChar - '0'; // Numeric base 2-9
                    } else if (baseChar >= 'A' && baseChar <= 'G') {
                        base = 10 + (baseChar - 'A'); // Letter base 10-16
                    } else {
                        return ans; // Invalid base
                    }
                } else {
                    return ans ;   // Base part must be a single character
                }

                // Step 4: Validate the number part (digits must match the base)
                for (char c : numberPart.toCharArray()) {
                    int value;
                    if (c >= '0' && c <= '9') {
                        value = c - '0'; // Numeric value
                    } else if (c >= 'A' && c <= 'G') {
                        value = 10 + (c - 'A'); // Letter value
                    } else {
                        return ans ; // Invalid character
                    }

                    if (value >= base) {
                        return ans; // Character exceeds base range
                    }
                }
                // If all checks passed, the format is valid
             return true;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */

        public static String int2Number(int num , int base) {
            String ans = "";
                if ((num<0)||(base<2)||base>16)
                    return ans;
                else




            return ;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals( String n1, String n2) {
            boolean ans = true;
               String n1 = new String();
          if (( n1.compareTo(n2)!=0){
              else
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int max =0;
            for (int i = 0; i < arr.length; i++) {
                //צריכה לבדוק מה הערך של המחרוזת בעשרוני
               if (int2Number(arr[i]>0))
                    max=arr[i]


            }
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }

    public static void main(String[] args) {
        String s = new String ("1234b10");
       int a = number2Int(s);
        System.out.println(a);
    }
}
