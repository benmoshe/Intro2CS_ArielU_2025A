package classes.week7;

import classes.week6.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
	private static Point2D _oo, _p1, _p2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {;}

	@BeforeEach
	void setUp() throws Exception {
		_oo = Point2D.ORIGIN;
		_p1 = new Point2D(3,4);
		_p2 = new Point2D(9,12);
		Point2D a1;
	}

	@Test
	void testPoint2DDoubleDouble() {
		double x=1,y=-2.3;
		_p1 = new Point2D(x,y);
		assertEquals(_p1.x(), x, Point2D.EPS);
		assertEquals(_p1.y(), y, Point2D.EPS);
	}

	@Test
	void testPoint2DPoint2D() {
		_p2 = new Point2D(_p1);
		assertEquals(_p1,_p2);
		
	}

	@Test
	void testPoint2DString() {
		String p_str = _p2.toString(); 	// p_str = "9.0,12.0"
		_p1 = new Point2D(p_str);     	// 
		String t = _p1.toString();
		assertEquals(_p1,_p2);
		assertEquals(t, p_str);
		boolean b = _p1==_p2; // false;
		assertFalse(b);
		
	}

	
	@Test
	void testAdd() {
		Point2D t1 = new Point2D(_p1);
		_p1 = _p1.add(_p2);
		assertNotEquals(_p1.x(),_p2.x(), Point2D.EPS);
		assertNotEquals(_p1.y(),_p2.y(), Point2D.EPS);
		Point2D t = new Point2D(-t1.x(), -t1.y());
		_p1 = _p1.add(t);
		assertEquals(_p2,_p1);  //  _p1 should be equals to the original _p2;
	}

	@Test
	void testToString() {
		String p_str = _p2.toString();
		_p1 = new Point2D(p_str);
		String t = _p1.toString();
		assertEquals(t,p_str);
	}

	@Test
	void testDistance() {
		double x = _p1.x(), y = _p1.y();
		double d1 = _p1.distance();
		double d2 = Math.sqrt(x*x+y*y);
		assertEquals(d1,d2, Point2D.EPS);
	}

	@Test
	void testDistancePoint2D() {
		double dx = _p2.x() - _p1.x(), dy = _p2.y()-_p1.y();
		double d1 = _p1.distance(_p2);
		double d2 = Math.sqrt(dx*dx+dy*dy);
		assertEquals(d1,d2, Point2D.EPS);
	}

	@Test
	void testEqualsObject() {
		double x = _p1.x(), y = _p1.y();
		Point2D t1 = new Point2D(_p1);
		assertEquals(_p1,t1);
		assertNotEquals(_p2, t1);
	}

	@Test
	void testClose2equals() {
		double eps1 = Point2D.EPS;
		Point2D eps = new Point2D(eps1, eps1);
		Point2D t1 = _p1.add(eps);
		assertFalse(_p1.close2equals(t1, eps1));
		assertTrue(_p1.close2equals(t1, eps1*2));
	}

}
