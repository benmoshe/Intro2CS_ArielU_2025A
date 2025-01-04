package classes.week7;

import classes.week6.Point2D;
import org.junit.jupiter.api.Test;
import classes.week6.Circle2D;

import java.util.ArrayList;

public class SortTest{
    @Test
    public void sortTest() {
        Point2D p1 = new Point2D(1,2);
        Circle2D c1 =  new Circle2D(Point2D.ORIGIN, 1);
        Circle2D c2 =  new Circle2D(p1, 2);
        Circle2D c3 =  new Circle2D(p1, 3);
        ArrayList<Circle2D> arr = new ArrayList<Circle2D>();
        arr.add(c1);
        arr.add(c3);
        arr.add(c2);
        CircleComp cp = new CircleComp(0);
        arr.sort(cp);
         cp = new CircleComp(1);
        arr.sort(cp);
    }
}
