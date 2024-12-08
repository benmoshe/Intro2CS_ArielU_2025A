package classes.week7;

import classes.week6.Point2D;
import classes.week7.Circle2D;
import classes.week7.Rect2D;
import classes.week7.ShapeComp;
import classes.week7.ShapeContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
/**
 * 
 * @author boazben-moshe
 *
0) week8.Circle2D: 0.08586236792357071,0.8215288163960485,0.2295975405583881
1) week8.Circle2D: 0.1464227030821892,0.08161699928228294,0.08662909222580772
2) week8.Circle2D: 0.22690451082556506,0.3410270091868808,0.9559620352594203
3) week8.Circle2D: 0.25143342845809913,0.009565803880132173,0.26994860005669186
4) week8.Circle2D: 0.5434706514183332,0.0036320063974544237,0.4211542305150203
5) week8.Circle2D: 0.640140036763458,0.28038963583719556,0.9363553780870062
6) week8.Circle2D: 0.7634437105047835,0.0983553755538149,0.5425940839232634
7) week8.Circle2D: 0.8315428548936767,0.4905200895859707,0.509167248291684
8) week8.Circle2D: 0.8885710085811717,0.8572685374231772,0.8555235838673302
9) week8.Circle2D: 0.9563273010924397,0.385478003438279,0.04440673045021215
10) week8.Rect2D: 0.11537515454084457,0.6833125873154342, 0.7870522798615661,0.9025001741381105
11) week8.Rect2D: 0.13410268287253824,0.20563019997164467, 0.4773840503551139,0.6674732977452809
12) week8.Rect2D: 0.1973752002328769,0.427136100242809, 0.505422435269977,0.6170402496977326
13) week8.Rect2D: 0.22509810654934437,0.24380788155716215, 0.984983520128692,0.6821367288856148
14) week8.Rect2D: 0.22616011280061843,0.20064907286299238, 0.4247362382612432,0.4068923004309628
15) week8.Rect2D: 0.2503247966074983,0.4836305097821534, 0.7504142615272873,0.5824571985239119
16) week8.Rect2D: 0.33560807257041214,0.04035340353242667, 0.8698184772331818,0.6513608409196638
17) week8.Rect2D: 0.3929189205254954,0.6285499777680738, 0.7255450888931744,0.6782042085577471
18) week8.Rect2D: 0.5327818433497339,0.21265178708330756, 0.5362006949313227,0.7328040068038392
19) week8.Rect2D: 0.854800994849455,0.08799420200299068, 0.9211660654312753,0.32353963121550644



 */
class ShapeContainerTest {
	private ShapeContainer sc;
	private int size;
	@BeforeEach
	void setup() {
		sc= new ShapeContainer();
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
		for(int i=0;i<sc.size();i++) {
			System.out.println(i+") "+sc.get(i));
		}
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
			String s1 = sc.get(i - 1).toString();
			String s2 = sc.get(i).toString();
			int d = s1.compareTo(s2);
			if (d > 0) {
				fail("Not sorted by toString");
			}
		}
	}

}
