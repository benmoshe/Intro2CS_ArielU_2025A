package classes.week7;

import classes.week6.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Circle2DTest {

    @Test
    void get_counter() {
        int z0 = Circle2D.get_counter();
        double rad = 3.5;
        int s = 100;
        for(int i=0;i<s;i++) {
            Circle2D c1 = new Circle2D(Point2D.ORIGIN, rad);
            Circle2D c2 = new Circle2D(c1);
            Circle2D c3 = new Circle2D(c1.toStringLong());
        }
        int z1 = Circle2D.get_counter();
        assertEquals(z0+s*3, z1);
    }

    @Test
    void getRad() {
        double rad = 3.5;
        Circle2D c1 = new Circle2D(Point2D.ORIGIN, rad);
        assertEquals(rad,c1.getRad(),0.001);
    }

    @Test
    void getCenter() {
    }
}