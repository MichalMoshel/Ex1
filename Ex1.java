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
            if (isNumber(num)==true)
            continue
                    else
            int ans = -1;
            //check what us the bace


            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            /*
            if (a == null || a.isEmpty()) {  // Step 1: Check if the string is null or empty
                return false;
            }


            String regex = "^[0-9A-G]+b[2-9A-G]$";
            if (!a.matches(regex)) {  // Use regex to validate the general format
                return false;
            }

            //  Extract the base and validate the number against it (what is base)
            int base;
            String basePart = a.substring(a.indexOf('b') + 1);
            if (basePart.matches("[A-G]")) {
                // Convert letter bases A-G to 10–16
                base = 10 + (basePart.charAt(0) - 'A');
            } else {
                base = Integer.parseInt(basePart);
            }

            String numberPart = a.substring(0, a.indexOf('b'));
            for (char c : numberPart.toCharArray()) {
                int value = (c >= 'A' && c <= 'G') ? 10 + (c - 'A') : (c - '0');
                if (value >= base) {
                    return false;
                }
            }
            */
             */


            boolean ans = true;

        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            if ((num<0)&& (base![2,16]))
                return null;
            else
            String ans = "";
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            // add your code here

            ////////////////////
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
