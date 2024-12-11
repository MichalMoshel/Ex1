package assignments.ex1;

import java.util.Scanner;

import static assignments.ex1.Ex1.*;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * This main method implements the logic as described in the Ex1Sol.jar solution.
 * It checks user inputs, validates numbers, calculates sum and product, and prints the results.
 */
public class Ex1Main {
    public static void main(String[] args) {
        // Define main variables
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";  // Input strings and "quit" constant
        int value1 = -1, value2 = -1;  // Default values for invalid inputs
        String[] numbersArray = new String[4];  // Array to store inputs and results (sum, product)

        // Main loop: continues until both num1 and num2 are "quit"
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            //  Input the first number (num1)
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();  // Read input for the first number

            if (!num1.equals(quit)) {  // If "quit" is not entered
                if (isNumber(num1)) {  // Validate input using isNumber() function
                    value1 = number2Int(num1);  // Convert to integer using number2Int() function
                    numbersArray[0] = num1;  // Store num1 in the array
                    System.out.println("num1 = " + num1 + " is number: true, value: " + value1);
                } else {
                    System.out.println("num1 = " + num1 + " is number: false, value: " + value1);
                    System.out.println("ERR: num1 is in the wrong format!");
                    continue; // Skip to the next iteration
                }
            } else {
                break;  // Exit if "quit" is entered
            }

            //  Input the second number (num2)
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
            num2 = sc.next();  // Read input for the second number
            if (!num2.equals(quit)) {  // If "quit" is not entered
                if (isNumber(num2)) {  // Validate input using isNumber() function
                    value2 = number2Int(num2);  // Convert to integer using number2Int() function
                    numbersArray[1] = num2;  // Store num2 in the array
                    System.out.println("num2 = " + num2 + " is number: true, value: " + value2);
                } else {
                    System.out.println("num2 = " + num2 + " is number: false, value: " + value2);
                    System.out.println("ERR: num2 is in the wrong format!");
                    continue;  // Skip to the next iteration
                }
            } else {
                break;  // Exit if "quit" is entered
            }

            //  Choose a base for the output
            System.out.println("Enter a base for output (a number [2,16]):");
            int base = sc.nextInt();  // Read input for the base

            if (base < 2 || base > 16) {  // Validate that the base is in range [2,16]
                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ").");
                continue;  // Skip to the next iteration
            }

            //  Calculate results
            int sum = value1 + value2;  // Calculate the sum of the two numbers
            int product = value1 * value2;  // Calculate the product of the two numbers

            String sumInBase = int2Number(sum, base);  // Convert the sum to the specified base using int2Number() function
            String productInBase = int2Number(product, base);  // Convert the product to the specified base using int2Number() function

            numbersArray[2] = sumInBase; // Store the sum in the array
            numbersArray[3] = productInBase;  // Store the product in the array

            //  Find the maximum value in the array
            int index = maxIndex(numbersArray);  // Find the index of the maximum value using maxIndex() function

            //  Display results
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + productInBase);
            System.out.println("Max number over [" + String.join(", ", numbersArray) + "] is: " + numbersArray[index]);
        }

        // Final message when quitting
        System.out.println("quiting now...");
    }
}
