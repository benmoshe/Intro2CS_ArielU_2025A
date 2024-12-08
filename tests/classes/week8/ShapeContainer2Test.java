package classes.week8;

import classes.week6.Point2D;
import classes.week7.Circle2D;
import classes.week7.Rect2D;
import classes.week7.ShapeComp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

class ShapeContainer2Test {
	private ShapeContainer2 sc;
	private int size;
	@BeforeEach
	void setup() {
		sc= new ShapeContainer2();
		size = 10;
		for(int i=0;i<size;i++) {
			double x = Math.random();
			double y = Math.random();
			double r = Math.random();
			Point2D p = new Point2D(x,y);
			Circle2D c = new Circle2D(p,r);
			sc.add(c);
			double x1 = Math.random();
			double y1 = Math.random();
			double x2 = Math.random();
			double y2 = Math.random();
			Point2D p1 = new Point2D(x1,y1);
			Point2D p2 = new Point2D(x2,y2);
			Rect2D rr = new Rect2D(p1,p2);
			sc.add(rr);
			//System.out.println(i+") "+c);
		}
	}
	@Test
	void testSortByArea() {
		sc.sort(ShapeComp.CompByArea);
		//for(int i=0;i<sc.size();i++) {
		//	System.out.println(i+") "+sc.get(i));
		//}
		for(int i=1;i<size;i++) {
			double d0 = sc.get(i-1).area();
			double d1 = sc.get(i).area();
			if(d0>d1) {fail("Not sorted by area");}
		}
	}
	@Test
	void testSortBy2String() {
		sc.sort(ShapeComp.CompByString);
		System.out.println();
		for(int i=0;i<sc.size();i++) {
			System.out.println(i+") "+sc.get(i));
		}
		for(int i=1;i<size;i++) {
			String s1 = sc.get(i-1).toString();
			String s2 = sc.get(i).toString();
			int d = s1.compareTo(s2);
			if(d>0) {fail("Not sorted by toString");}
		}
		
	}

}
