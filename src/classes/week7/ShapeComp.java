package classes.week7;
import java.util.Comparator;
/**
 * This class represents a linear order over GeoShapes.
 * @author boaz.ben-moshe
 *
 */
public class ShapeComp implements Comparator<GeoShape> {
	public static final int ByToString = 0, ByArea = 2;
	private int _sortFlag;
	public static final Comparator<GeoShape> CompByString = 
			new ShapeComp(ByToString);
	public static final Comparator<GeoShape> CompByArea = 
			new ShapeComp(ByArea);
	private ShapeComp(int sf) {_sortFlag = sf;}
	@Override
	public int compare(GeoShape o1, GeoShape o2) {
		int ans = 0;
		if(this._sortFlag == ByArea) {
			double d1 = o1.area();
			double d2 = o2.area();
			if(d1>d2) {ans = 1;}
			if(d1<d2) {ans = -1;}
		}
		if(this._sortFlag == ByToString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		return ans;
	}
}
