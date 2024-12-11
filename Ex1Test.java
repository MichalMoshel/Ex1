package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 * */
public class Ex1Test {
    @Test
       void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
           String s10 = "1011bA";
           v = Ex1.number2Int(s10);
           s2 = Ex1.int2Number(v,2);
           int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

       @Test
        void isBasisNumberTest() {
           String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
               boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
           }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
               boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
        String a=  Ex1.int2Number(10,2);
        String b= "1010b2";
        assertEquals(a,b);
        }
        @Test
        void Number2intTest(){
            int n = Ex1.number2Int("00050");
            assertEquals(n, 50);

            int w = Ex1.number2Int("123b5");
            assertEquals(w,38);

        }
        @Test
       void maxIndexTest() {
        String[] s ={"10","40","50","60"};
        int i = Ex1.maxIndex(s);
assertEquals(i,3);

            // Add additional test functions - test as much as you can.
        }}
