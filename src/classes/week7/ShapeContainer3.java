package classes.week7;

/**
 * This class represents a simple collection of GeoShape.
 * @author boaz.benmoshe
 *
 */
public class ShapeContainer3 {
	public static final int INIT_SIZE = 10;
	private GeoShape[] _ps = null;
	private int _ind;
	
	public ShapeContainer3() {
		_ps = new GeoShape[INIT_SIZE];
		_ind = 0;
	}
	public int size() {return _ind;}
	public int capacity() {return _ps.length;}
	public GeoShape get(int i) {
		if(i<0 || i>= size()) {
			//System.exit(-1);
			throw new RuntimeException("ERR: ");
			//return null;
		}
		
		return _ps[i];
	}
	public void add(GeoShape p) {
		if(p!=null) {
			if(isFull()) {resize(size()*2);}
			_ps[_ind] = p;
			_ind += 1;
		}
		else {
			System.err.println("FUYA: null is not a valid entry for the Point Container");
		}
	}
	public GeoShape remove(int i) {
		GeoShape ans = null;
		if(i>=0 && i<size()) {
			ans = get(i);
			for(int j=i;j<size()-1;j++) {
				this._ps[j] = this._ps[j+1];
			}
			this._ind--;
			if(size()*2<this.capacity() && this.capacity()>INIT_SIZE) {
				int n = (size()*2);
				this.resize(n);
			}
		}
		return ans;
	}
	/**
	 * additional methods:
	 * Point removeAt(int i) {...}
	 * void sort() {...} // according to the distance from (0,0)
	 */
	//////////// Private Methods ////////////
	private boolean isFull() {
		return size() == capacity();
	}
	private void resize(int s) {
		GeoShape[] tmp = new GeoShape[s];
		for(int i=0;i<size() && i<s ;i=i+1) {
			tmp[i] = _ps[i];
		}
		_ps = tmp;
	}
	
}
