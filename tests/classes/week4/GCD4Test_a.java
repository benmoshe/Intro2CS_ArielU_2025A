package classes.week4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCD4Test_a {

    @Test
    void sort() {
    }

    @Test
    void gcd1() {
        int x = 34;
        int y = 21;
        long res = GCD4.gcd1(x,y);
        if(res!=1) {
            fail("FUYA FUYA");
        }
    }
    @Test
    void gcd1_4() {
        int ans = 331;
        int x = 2*5*11*ans;
        int y = 3*3*7*7*ans;
        long res = GCD4.gcd1(x,y);
        long res4 = GCD4.gcd4(x,y);
        if(res!=ans) {
            fail("ERR, the gcd should have been :" +ans);
        }
        if(res!=res4) {
            fail("ERR, the gcd should have been :" +ans);
        }
    }

    @Test
    void gcd4() {
    }
}