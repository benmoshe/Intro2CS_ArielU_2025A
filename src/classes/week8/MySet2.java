package classes.week8;
import java.util.ArrayList;
public class MySet2<T> {
    private ArrayList<T> _set;
    public MySet2() {
        _set = new ArrayList<>();
    }
    public boolean add(T t) {
        boolean b = false;
        boolean isMember = _set.contains(t);
        if(!isMember) {	b = _set.add(t);}
        return b;
    }
    public void add(int i, T t) {
        boolean isMember = _set.contains(t);
        if(!isMember) {	_set.add(i,t);}
    }

    public int size() {return _set.size();}

    public T get(int i) {return _set.get(i);}
    /**
     * Notes:
     * 1. Possible bugs: addAll (two methods).
     * 2. Additional possible methods for sets: union and intersection.
     * 3. Additional (sub) class: OrderedSet.
     */
}
