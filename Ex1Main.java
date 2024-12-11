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
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        int value1 = -1, value2 = -1; // Set default value to -1 for invalid inputs
        String[] numbersArray = new String[4]; // Holds inputs and calculated results (sum, product)

        // Main loop: continues until both num1 and num2 are "quit"
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Prompt user to enter the first number (num1)
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();  // First input from user

            // Check if num1 is not "quit" and validate it
            if (!num1.equals("quit")) {
                if (isNumber(num1)) {
                    value1 = number2Int(num1); // Convert the number to integer value
                    numbersArray[0] = num1;  // Store num1 in the array
                    System.out.println("num1 = " + num1 + " is number: true, value: " + value1);
                } else {
                    // If num1 is not valid, display error and skip to next iteration
                    System.out.println("num1 = " + num1 + " is number: false, value: " + value1);
                    System.out.println("ERR: num1 is in the wrong format!");
                    continue;  // Skip further steps and go back to the beginning of the loop
                }
            }else {
                break;
            }


            // Prompt user to enter the second number (num2)
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
            num2 = sc.next();  // Second input from user

            // Check if num2 is not "quit" and validate it
            if (!num2.equals("quit")) {
                if (isNumber(num2)) {
                    value2 = number2Int(num2); // Convert the number to integer value
                    numbersArray[1] = num2;  // Store num2 in the array
                    System.out.println("num2 = " + num2 + " is number: true, value: " + value2);
                } else {
                    // If num2 is not valid, display error and skip to next iteration
                    System.out.println("num2 = " + num2 + " is number: false, value: " + value2);
                    System.out.println("ERR: num2 is in the wrong format!");
                    continue;  // Skip further steps and go back to the beginning of the loop
                }
            }else {
                break;
            }

            // Prompt user to enter a base for output (between 2 and 16)
            System.out.println("Enter a base for output (a number [2,16]):");
            int base = sc.nextInt();  // Input for base

            // Check if the base is within the valid range
            if (base < 2 || base > 16) {
                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ").");
                continue;  // Skip further steps and go back to the beginning of the loop
            }

            // Calculate the sum and product of value1 and value2
            int sum = value1 + value2;
            int product = value1 * value2;

            // Convert sum and product to the specified base
            String sumInBase = int2Number(sum, base);
            String productInBase = int2Number(product, base);

            // Store the calculated results in the array
            numbersArray[2] = sumInBase;
            numbersArray[3] = productInBase;

            // Find the index of the maximum value in the array (based on the number value)
            int index = maxIndex(numbersArray);

            // Display the results: sum, product, and the maximum value in the array
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + productInBase);
            System.out.println("Max number over [" + String.join(", ", numbersArray) + "] is: " + numbersArray[index]);
        }

        // Final message when the user types "quit"
        System.out.println("quiting now...");
    }
}
