package assignments.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    /**
     * Test the number2Int function.
     */
    @Test
    void computeNumberTest() {
        // Case 1: Binary number "1011b2", expected decimal value 11.
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11); // Check conversion to decimal.

        // Case 2: Base-10 representation "1011bA" to binary and back.
        String s10 = "1011bA";
        v = Ex1.number2Int(s10); // Convert base-10 number to decimal.
        s2 = Ex1.int2Number(v, 2); // Convert the decimal number to binary.
        int v2 = Ex1.number2Int(s2); // Convert binary back to decimal.
        assertEquals(v, v2); // Ensure the conversions are consistent.

        // Case 3: Check equality between the original and converted strings.
        assertTrue(Ex1.equals(s10, s2));
    }

    /**
     * Test the isNumber function.
     */

    @Test
    void isBasisNumberTest() {
        // Valid number cases.
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA",};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        // Invalid number cases.
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);  // All should be invalid numbers.

        }
    }

    /**
     * Test the int2Number function.
     */
    @Test
    void int2NumberTest() {
        // Case 1: Convert 10 to binary (base-2).
        String a = Ex1.int2Number(10, 2);
        String b = "1010b2";
        assertEquals(a, b); // Check binary representation.

        // Case 2: Convert 255 to hexadecimal (base-16).
        a = Ex1.int2Number(255,16);
        b = "FFbG";
        assertEquals(a, b); // Check hexadecimal representation.

        // Case 3: Edge case - Convert 0 to any base.
        a = Ex1.int2Number(0, 8);
        b = "0b8";
        assertEquals(a, b); // Check zero conversion.
    }

    /**
     * Test the number2Int function with various cases.
     */
    @Test
    void number2IntTest() {
        // Case 1: Convert "00050" (decimal with leading zeros).
        int n = Ex1.number2Int("00050");
        assertEquals(n, 50); // Ensure leading zeros are handled.

        // Case 2: Convert "123b5" (base-5).
        int w = Ex1.number2Int("123b5");
        assertEquals(w, 38); // Validate base-5 conversion.

        // Case 3: Invalid format "12bX".
        n = Ex1.number2Int("12bX");
        assertEquals(n, -1); // Check that invalid formats return -1.
    }

    /**
     * Test the maxIndex function.
     */
    @Test
    void maxIndexTest() {
        // Case 1: Simple array with unique maximum value.
        String[] s = {"10", "40", "50", "60"};
        int i = Ex1.maxIndex(s);
        assertEquals(i, 3); // Maximum is at index 3.

        // Case 2: Array with negative and null values.
        s = new String[]{"-10bA", null, "0", "1b2"};
        i = Ex1.maxIndex(s);
        assertEquals(i, 3); // Maximum is 1 (at index 3).

        // Case 3: Empty array.
        s = new String[]{};
        i = Ex1.maxIndex(s);
        assertEquals(i, -1); // No elements, return -1.
    }

    /**
     * Test the equals function.
     */
    @Test
    void equalsTest() {
        // Case 1: Equal values in different representations.
        assertTrue(Ex1.equals("1010b2", "10bA")); // Binary and decimal representations.

        assertTrue(Ex1.equals("A0bG", "160"));

        // Case 2: Different values.
        assertFalse(Ex1.equals("1010b2", "11bA")); // Binary and decimal mismatch.

        // Case 3: Invalid formats.
        assertFalse(Ex1.equals("1b2", "notANumber")); // Invalid string comparison.
    }

}
