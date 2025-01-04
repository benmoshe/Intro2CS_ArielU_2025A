package classes.week7;

import classes.week6.Point2D;
import classes.week7.PointContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PointContainerTest {
/**
 * 
 */
	@Test
	void testPoints() {
		PointContainer ps = new PointContainer();
		assertNotNull(ps);
	}

	@Test
	void testSize() {
		int size = 10;
		PointContainer ps = new PointContainer();
		for(int i=0;i<size;i=i+1) {
			Point2D p = randomPoint(100,100);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}

	@Test
	void testGet() {
		Point2D p = randomPoint(100,100);
		PointContainer ps = new PointContainer();
		ps.add(new Point2D(p));
		Point2D p0 = ps.get(0);
		//ps.get(2);  // debug only
		assertEquals(p,p0);
	}

	@Test
	void testAdd() {
		int size = 1000;
		PointContainer ps = new PointContainer();
		for(int i=0;i<size;i=i+1) {
			Point2D p = randomPoint(10,10);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}
	private static Point2D randomPoint(double x, double y) {
		double x0 = Math.random()*x;
		double y0 = Math.random()*y;
		Point2D ans = new Point2D(x0,y0);
		return ans;
	}
}
