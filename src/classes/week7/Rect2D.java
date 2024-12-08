package classes.week7;
import classes.week6.Point2D;

public class Rect2D implements GeoShape{
/** 
 * This class represents a 2D (axis parallel) Rectangle in the plane. 
 * @author boaz.benmoshe
 */
	private Point2D _min;
	private Point2D _max;
	
	public Rect2D(Point2D p1, Point2D p2) {
		this._min = new Point2D(Math.min(p1.x(),p2.x()), Math.min(p1.y(),p2.y()));
		this._max = new Point2D(Math.max(p1.x(),p2.x()), Math.max(p1.y(),p2.y()));
	}
	 @Override
	    public String toString()
	    { return this.getClass().getName()+": "+_min+", "+_max;}
	@Override
	public boolean contains(Point2D ot) {
		boolean ans = ot.x()>=_min.x()&& ot.x()<=_max.x();
		ans &= ot.y()>=_min.y()&& ot.y()<=_max.y();
		return ans;
	}

	@Override
	public double area() {
		double ans = dx() *dy();
		return ans;
	}
	@Override
	public double perimeter() {
		double ans = dx()*2 + dy()*2;
		return ans;
	}
	@Override
	public void move(Point2D vec) {
		_min.move(vec);
		_max.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Rect2D(_min, _max);
	}
	@Override
	public Point2D centerOfMass() {
		return new Point2D(_min.x()+dx()/2, _min.y()+dy()/2);
	}
	public double dx() {return _max.x() - _min.x();}
	public double dy() {return _max.y() - _min.y();}
}

