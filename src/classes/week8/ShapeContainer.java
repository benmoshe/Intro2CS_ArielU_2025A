package classes.week8;
import classes.week7.GeoShape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShapeContainer {
	private ArrayList<GeoShape> _shapes;
	public ShapeContainer() {
		_shapes = new ArrayList<GeoShape>();
	}
	public int size() {return _shapes.size();}
	public void add(GeoShape g) {_shapes.add(g);}
	public GeoShape get(int i) {
		GeoShape ans = null;
		if(i<0 || i>= size()) {
			throw new RuntimeException("Err: got index "+i+", size = "+size());
		}
		ans = _shapes.get(i);
		return ans;
	}
	public GeoShape remove(int i) {
		return _shapes.remove(i);
	}
	public void sort(Comparator<GeoShape> comp) {
		Collections.sort(_shapes, comp);
	}
}
