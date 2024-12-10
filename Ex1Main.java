package assignments.ex1;

import java.util.Scanner;

import static assignments.ex1.Ex1.*;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
/*
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                if (!isNumber(num1)) {
                    System.out.println("ERR: num1 is in the wrong format!");
                    return;
                }
                value1 = number2Int(num1);
                numbersArray[0] = num1;
                System.out.println("num1 = " + num1 + " is number: true, value: " + value1);

                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
    }
    */


public class Ex1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        int value1 = 0, value2 = 0;
        String[] numbersArray = new String[4]; // Holds inputs and calculated results
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();  //First input
            if (!num1.equals("quit")) {
                if (!isNumber(num1)) {
                    value1 = number2Int(num1);//
                    numbersArray[0] = num1;
                    System.out.println("num1 = " + num1 + " is number: true, value: " + value1);
                }
                System.out.println("ERR: num1 is in the wrong format!");
                return;
            }

            System.out.println("Enter a string as number#2 (or \"quit\" to end the program):");
             num2 = sc.next();  // Second input
            if (!isNumber(num2)) {
                System.out.println("ERR: num2 is in the wrong format!");
                return;
            }
            value2 = number2Int(num2);
            numbersArray[1] = num2;
            System.out.println("num2 = " + num2 + " is number: true, value: " + value2);

            // Base input
            System.out.println("Enter a base for output (a number [2,16]):");
            int base = sc.nextInt();
            if (base < 2 || base > 16) {
                System.out.println("ERR: Base must be between 2 and 16. Exiting program.");
                return;
            }

            // Calculate sum and product
            int sum = value1 + value2;
            int product = value1 * value2;

            String sumInBase = int2Number(sum, base);
            String productInBase = int2Number(product, base);

            // Store results in the array
            numbersArray[2] = sumInBase;
            numbersArray[3] = productInBase;
            for (int i = 0; i <= 3; i++) {
                if (numbersArray[i] == null || numbersArray[i].isEmpty()) {
                    continue; // Skip invalid or empty entries
                }
            }


            // Find the maximum value index
            int index = maxIndex(numbersArray);

            // Display results
            System.out.println(num1 + " + " + num2 + " = " + sumInBase);
            System.out.println(num1 + " * " + num2 + " = " + productInBase);
            System.out.println("Max number over [" + String.join(", ", numbersArray) + "] is: " + numbersArray[index]);
        }

        System.out.println("quiting now...");
    }

}




