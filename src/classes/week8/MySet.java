package classes.week8;
import java.util.ArrayList;
public class MySet<T> extends ArrayList<T>{
	public MySet() {
		super();
	}
	@Override
	public boolean add(T t) {
		boolean b = false;
		boolean isMember = super.contains(t);
		if(!isMember) {	b = super.add(t);}
		return b;
	}
	@Override
	public void add(int i, T t) {
		boolean isMember = super.contains(t);
		if(!isMember) {	super.add(i,t);}
	}
	/**
	 * Notes:
	 * 1. Possible bugs: addAll (two methods).
	 * 2. Additional possible methods for sets: union and intersection.
	 * 3. Additional (sub) class: OrderedSet.
	 */
}
