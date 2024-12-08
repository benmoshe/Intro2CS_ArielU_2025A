package classes.week8;
import classes.week6.Point2D;
import java.util.ArrayList;
/**
 * @author boazben-moshe
0) 0.0,0.0
1) 1.0,2.0
2) 2.0,4.0
3) 3.0,6.0
4) 4.0,8.0
5) 5.0,10.0
6) 6.0,12.0
7) 7.0,14.0
8) 8.0,16.0
9) 9.0,18.0
 */
public class PointSetMain {
	public static void main(String[] args) {
		ArrayList<Point2D> ps2 = new MySet<Point2D>();
		MySet2<Point2D> ps = new MySet2<Point2D>();
		for(int i=0;i<10;i++) {
			Point2D p = new Point2D(i,2*i);
			ps.add(p);
		}
		for(int i=0;i<ps.size();i++) {
			Point2D p = ps.get(i);
			System.out.println(i+") "+p.toString());
		}
	}
}
