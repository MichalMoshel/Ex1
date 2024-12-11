# Ex1 - Number Formatting Converter and Calculator

This project is an implementation of a number formatting
converter and calculator that allows for operations
(addition and multiplication) between two numbers represented as strings.
These numbers can be in various bases, ranging from binary (base 2) to hexadecimal (base 16).
The system handles both decimal and base-formatted numbers (e.g., "123bA" for base 10 or "1011b2" for binary).
This project also includes a simple user interface through the console, where the user can input two numbers,
choose a base for the output, and see the results.

## File Structure

### `Ex1Main.java`
This is the main entry point for the program. It is responsible for handling user input and providing a simple interface for interacting with the number formatting and calculation system.
The main functionalities include:
- Reading input from the user for two numbers.
- Validating the input to ensure correct number format.
- Allowing the user to select the base for output (from 2 to 16).
- Calculating the sum and product of the two numbers.
- Displaying the results in the chosen base format.
- Identifying the maximum value from the results and displaying it.

### `Ex1.java`
This class contains the core functionality of the project, including:
- **`number2Int(String num)`**: Converts a number string (in any base from 2 to 16) to a decimal integer.
- **`isNumber(String a)`**: Checks whether a given string is in a valid number format, allowing for base-specific notation (e.g., "123bA" for base 10).
- **`int2Number(int num, int base)`**: Converts a decimal integer to a string in a specified base (between 2 and 16).
- **`equals(String n1, String n2)`**: Compares two numbers, ensuring they are equivalent when converted to decimal.
- **`maxIndex(String[] arr)`**: Finds the index of the largest number in an array of number strings, based on their decimal values.

### `Ex1Test.java`
This file contains unit tests for the functions in `Ex1.java`. It uses JUnit for testing and ensures that the logic in `Ex1` is correct. The tests include:
- **Testing `number2Int`**: Validates conversions from base-n numbers to decimal integers.
- **Testing `isNumber`**: Ensures the input strings conform to the correct number format for various bases.
- **Testing `int2Number`**: Verifies correct conversion from decimal integers to numbers in different bases.
- **Testing `maxIndex`**: Checks that the maximum value from an array of number strings is correctly identified.
- **Testing `equals`**: Compares numbers in different formats to ensure they represent the same value.

## Usage

1. Clone the repository to your local machine.
2. Compile the Java files.
3. Run `Ex1Main` to start the program.
4. The program will prompt you to enter two numbers in a valid base format (e.g., "1011b2" for binary or "123bA" for decimal).
5. The program will ask you to enter the base for the output (from 2 to 16).
6. The program will display the sum, product, and the maximum number from the results, all in the selected base format.

## Example

Enter a string as Number #1 (or "quit" to exit the program):
1011b2
num1 = 1011b2 is a valid number: true, value: 11

Enter a string as Number #2 (or "quit" to exit the program):
123bA
num2 = 123bA is a valid number: true, value: 123

Enter the output base (number [2,16]):
10

1011b2 + 123bA = 134b10
1011b2 * 123bA = 135b10
The maximum number from [1011b2, 123bA, 134b10, 135b10] is:
135b10



