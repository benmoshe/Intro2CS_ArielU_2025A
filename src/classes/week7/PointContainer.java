package classes.week7;
import classes.week6.Point2D;

/**
 * This class represents a simple collection of Points.
 * @author boaz.benmoshe
 *
 */
public class PointContainer {
	public static final int INIT_SIZE = 10;
	private Point2D[] _ps = null;
	private int _ind;
	
	public PointContainer() {
		_ps = new Point2D[INIT_SIZE];
		_ind = 0;
	}
	public int size() {return _ind;}
	public int capacity() {return _ps.length;}
	public Point2D get(int i) {
		if(i<0 || i>= size()) {
			//System.exit(-1);
			throw new RuntimeException("ERR: got index of "+i+"  out of range :[0,"+size()+");" );
			//return null;
		}
		return _ps[i];
	}
	public void add(Point2D p) {
		if(p!=null) {
			if(isFull()) {resize(size()*2);}
			_ps[_ind] = p;
			_ind += 1;
		}
		else {
			System.err.println("FUYA: null is not a valid entry for the Point Container");
		}
	}
	public boolean equals(Object t) {
		boolean ans = false;
		if(t!=null && t instanceof PointContainer) {
			ans = true;
			PointContainer pc1 = (PointContainer)t;
			boolean a1 = this.contains(pc1);
			boolean a2 = pc1.contains(this);
			ans = a1 && a2;
		}
		return ans;
	}
	public boolean contains(PointContainer pc) {
		boolean ans = true;
		for(int i=0;i<pc.size() && ans;i=i+1) {
			ans = this.contains(pc.get(i));
		}
		return ans;
	}
	public boolean contains(Point2D p) {
		boolean ans = false;
		for(int i=0;i<this.size() && !ans ;i=i+1) {
			ans = p.equals(get(i));
		}
		return ans;
	}
	//////////// Private Methods ////////////
	private boolean isFull() {
		return size() == capacity();
	}
	private void resize(int s) {
		Point2D[] tmp = new Point2D[s];
		for(int i=0;i<size() && i<s ;i=i+1) {
			tmp[i] = _ps[i];
		}
		_ps = tmp;
	}
}
