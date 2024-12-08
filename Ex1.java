package assignments.ex1;

import java.util.Scanner;

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
        int ans = -1;
        if (isNumber(num)) {
            String[] arr = num.split("b");
            String numberPart = arr[0];
            String basePart = arr[1];
            int base;
            char baseChar = basePart.charAt(0);

            if (baseChar >= '2' && baseChar <= '9') {
                base = baseChar - '0';  // Numeric base 2-9
            } else {
                base = 10 + (baseChar - 'A'); // Letter base 10-16
            }

            ans = Integer.parseInt(numberPart, base);
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
        //  Check if the string is null or empty
        if (a == null || a.isEmpty()) {
            return false;
        }
        //  Ensure the input contains 'b' and split into number and base parts
        int bIndex = a.indexOf('b');
        if (bIndex == -1 || bIndex == 0 || bIndex == a.length() - 1) {
            return false; // 'b' not present, at the start, or at the end
        }
        String numberPart = a.substring(0, bIndex); // The part before 'b'
        String basePart = a.substring(bIndex + 1); // The part after 'b'
        System.out.println(basePart);
        //  Validate the numberPart is true
        //  Validate the basePart is true

        int base = 0;
        if (basePart.length() == 1) {
            char baseChar = basePart.charAt(0);
            if (baseChar >= '2' && baseChar <= '9') {

                base = baseChar - '0'; // Numeric base 2-9    //the result in int
            } else if (baseChar >= 'A' && baseChar <= 'G') {


                base = 10 + (baseChar - 'A'); // Letter base 10-16
            } else {
                return false; // Invalid base
            }
        } else {
            return false;   // Base part must be a single character
        }

        //  Validate the number part (digits must match the base)

        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i);
            int num;
            if (c >= '2' && c <= '9') {
                num = c - '0'; // Numeric base 2-9    //the result in int
            } else if (c >= 'A' && c <= 'G') {
                num = 10 + (c - 'A'); // Letter base 10-16
            } else {
                return false; // Invalid base
            }
            if (num >= base) {
                return false;
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


//////////////////////////

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value1 = 0;
        int value2 = 0;
        String[] numbersArray = new String[4]; // To hold the 4 numbers: 2 inputs + sum + multiplication results

        // First input
        System.out.println("Enter a string as number#1 :");
        String input1 = scanner.nextLine();
        if (isNumber(input1)) {
            numbersArray[0] = input1;
            value1 = number2Int(input1);
            System.out.println("num1= " + input1 + " is number: true , value: " + value1);
        } else {
            System.out.println("ERR: num1 is in the wrong format! ");
            return;
        }

        // Second input
        System.out.println("Enter a string as number#2 :");
        String input2 = scanner.nextLine();
        if (isNumber(input2)) {
            numbersArray[1] = input2;
            value2 = number2Int(input2);
            System.out.println("num2= " + input2 + " is number: true , value: " + value2);
        } else {
            System.out.println("ERR: num2 is in the wrong format!");
            return;
        }

        // Base input
        System.out.println("Enter a base for output (a number [2,16]):");
        int base = scanner.nextInt();
        if (base < 2 || base > 16) {
            System.out.println("Base must be between 2 and 16. Exiting program.");
            return;  // Exit if the base is not valid
        }

        // Calculate sum and product
        int sum = value1 + value2;
        int product = value1 * value2;

        // Convert to the desired base
        String sumInBase = int2Number(sum, base);
        String productInBase = int2Number(product, base);

        // Store the results in the array
        numbersArray[2] = sumInBase;
        numbersArray[3] = productInBase;

        // Find the maximum number and print the result
        int index = maxIndex(numbersArray);
        System.out.println(input1 + " + " + input2 + " = " + sumInBase);
        System.out.println(input1 + " * " + input2 + " = " + productInBase);
        System.out.println("Max number over [" + numbersArray[0] + "," + numbersArray[1] + "," + numbersArray[2] + "," + numbersArray[3] + "] is: " + numbersArray[index]);
    }
}






