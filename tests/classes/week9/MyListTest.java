package classes.week9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import classes.week6.Point2D;
import classes.week7.Circle2D;
import classes.week7.GeoShape;
import classes.week7.Rect2D;

class MyListTest {

	@Test
	void testMyList() {
		MyList<Point2D> l = new MyList<Point2D>();
		assertTrue(l.isEmpty());
		System.out.println(l);
	}
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	@Test
	void testAdd() {
		MyList<Point2D> l = new MyList<Point2D>();
		l.add(new Point2D(1,2.1));
		assertFalse(l.isEmpty());
		System.out.println(l);
	}

	@Test
	void testAddAt() {
		MyList<String> l = new MyList<String>();
		l.addAt("a",0);
		l.addAt("b",1);
		l.addAt("c",0);
		l.addAt("d",3);
		l.removeElementAt(3);
		assertTrue(l.size()==3);
		System.out.println(l);
	}

	@Test
	void testRemoveElementAt() {
		MyList<String> l = new MyList<String>();
		l.add("a");
		l.removeElementAt(0);
		assertTrue(l.isEmpty());
		System.out.println(l);
	}

	@Test
	void testContains() {
		MyList<String> l = new MyList<String>();
		l.add("a");
		assertFalse(l.contains("b"));
		assertTrue(l.contains("a"));
		System.out.println(l);
	}


	@Test
	void testSize() {
		MyList<Integer> l = new MyList<Integer>();
		int size = 1000;
		for(int i=0;i<size;i=i+1) {
			l.add(i);
		}
		assertTrue(l.size()==size);
	}
	
	@Test
	void testSize2() {
		MyList<GeoShape> l = new MyList<GeoShape>();
		int size = 1000;
		for(int i=0;i<size;i=i+1) {
			GeoShape g = getRandomGeoShape(i);
			l.add(g);
		}
		assertTrue(l.size()==size);
	}

	private static GeoShape getRandomGeoShape(int i) {
		GeoShape ans = null;
		double f = Math.random(); // [0,1)
		Point2D p1 = new Point2D(i,i*1.5);
			if(i<0.6) {ans = new Circle2D(p1,2.1);}
			else {
				Point2D p2 = new Point2D(p1);
				p2.move(p1);
				ans = new Rect2D(p1,p2);
			}
		return ans;
	}

	@Test
	void testToString() {
		MyList<Double> l = new MyList<Double>();
		int size = 10;
		for(int i=0;i<size;i=i+1) {
			l.add(i*1.0);
		}
		System.out.println(l);
	}
	@Test
	void testConnect() {
		MyList<String> l1 = new MyList<String>();
		MyList<String> l2 = new MyList<String>();
		int size = 10;
		for(int i=0;i<size;i=i+1) {
			l1.add(""+i);
			l2.add(""+i);
		}
		l1.connect(l2);
		assertTrue(l1.size()==size*2);
		System.out.println(l1);
	}
}
