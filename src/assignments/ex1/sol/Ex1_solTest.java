package assignments.ex1.sol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1_solTest {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1_sol.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1_sol.number2Int(s10);
        s2 = Ex1_sol.int2Number(v,2);
        int v2 = Ex1_sol.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1_sol.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
       String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
       for(int i=0;i<good.length;i=i+1) {
           boolean ok = Ex1_sol.isNumber(good[i]);
           assertTrue(ok);
       }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1_sol.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2BNumberTest() {
        String s2 = "1011b2";
        int v = Ex1_sol.number2Int(s2);
        String s2a = Ex1_sol.int2Number(v,2);
        assertEquals(s2,s2a);
    }
    @Test
    void maxIndexTest() {
        String[] arr = {"12b3", "12b5", "12b8", "12b4"};
        int maxInd = Ex1_sol.maxIndex(arr);
        assertEquals(maxInd,2);
    }
}