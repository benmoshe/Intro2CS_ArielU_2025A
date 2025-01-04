package classes.week7;

import classes.week6.Point2D;

public class Circle2D implements GeoShape{
	private Point2D center = null;
	private double _rad;
	private static int _counter =0;
	
	public Circle2D(Point2D c, double r) {
		this.center = new Point2D(c);
		this._rad = r;
		_counter++;
	}
	public static int get_counter() {return _counter;}
	public Circle2D(Circle2D c) {
		this(c.center, c._rad);
	}
	/**
	 * "1,2,3" ==> cen(1,2) radius(3)
	 * @param s
	 */
	public Circle2D(String s) {
		String[] a = s.split(",");//{"1","2","3"}
		double x = Double.parseDouble(a[1]);
    	double y = Double.parseDouble(a[2]);
    	double r = Double.parseDouble(a[3]);
    	center = new Point2D(x,y);
    	_rad = r;
		_counter++;
	}

	public double getRad() {return _rad;}
	public Point2D getCenter() {return new Point2D(center);} // new Point2D(_cen);
	/**
	 * 1,2,3 ==> Circle: _center: (1,2), radius: 3
	 * double r = Math.random(); [0,1);
	 */
	public String toString() {
		String ans = center.toString()+","+this.getRad();
		return ans;
	}public String toStringLong() {
		String ans = this.getClass().getSimpleName()+", " + center.toString()+","+this.getRad();
		return ans;
	}
	@Override
	public boolean contains(Point2D p) {
		return this.getRad() > p.distance(this.center);
	}
	public Point2D getRandomInnerPoint() {
		Point2D ans = null;
		double minX = this.center.x()-_rad;
		double minY = this.center.y()-_rad;
		while(ans==null) {
			double x = minX + Math.random()*2*_rad;
			double y = minY + Math.random()*2*_rad;
			Point2D p = new Point2D(x,y);
			if(this.contains(p)) {
				ans = p;
			}
		}
		return ans;
	}
	public Point2D getRandomInnerPoint2() {
		Point2D ans = new Point2D(this.center);
		double ang = Math.random()*2*Math.PI;// [0,360deg]
		double d = Math.random()*this._rad;  // [0,_radius]
		d = Math.pow(d, 0.5);
		double dx = d* Math.cos(ang);
		double dy = d* Math.sin(ang);
		Point2D dd = new Point2D(dx,dy);
		ans.move(dd);
		return ans;
	}
	public void move(Point2D p) {
		this.center.move(p);
	}
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this.getCenter());
	}
	@Override
	public double perimeter() {
			return 2*this.getRad() * Math.PI;
	}
	@Override
	public GeoShape copy() {
		// TODO Auto-generated method stub
		return new Circle2D(this);
	}
	@Override
	public double area() {
		return Math.pow(_rad, 2) * Math.PI;
	}
	@Override
	public boolean equals(Object c)
	{
		if(c==null || !(c instanceof Circle2D)) {return false;}
		Circle2D c2 = (Circle2D) c;
		return this.getRad()==c2._rad &&
			this.center.equals(c2.getCenter());
	}

}
