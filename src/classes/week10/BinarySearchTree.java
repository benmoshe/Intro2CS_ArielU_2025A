package classes.week10;
/**
 * 
LLL:1
LL:4
LLRL:6
LLR:6
LLRR:7
L:8
:8
RLL:9
RL:9
R:9

                       8
                 8           9
            4             9
         1     6        9
             6   7

 */
import java.util.Comparator;

public class BinarySearchTree<T> extends BinaryTree1<T> {

	/**
	 * 
	 */
	private Comparator<T> _comp;
	public BinarySearchTree(Comparator<T> c) {super(null);_comp=c;}
	//	public BinarySearchTree(Comparator<T> c) {this(c,null);}
	public BinarySearchTree(Comparator<T> c,T a) {super(a);_comp=c;}

	public Comparator<T> getComp() {
		return _comp;
	}
	@Override
	public void add(T a) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {_root = a;}
		else {
			//	double d = Math.random();
			if(_comp.compare(a, _root)<=0) {
				if(_left==null) {_left = new BinarySearchTree<T>(_comp,a);}
				else {_left.add(a);}
			}
			else {
				if(_right==null) {_right = new BinarySearchTree<T>(_comp,a);}
				else {_right.add(a);}
			}
		}
	}
	@Override
	public T find(T t) {
		T ans = null;
		if(!this.isEmpty()) {
			int dir = _comp.compare(t,this.getRoot());
			if(dir==0) {ans = getRoot();}
			if(dir<0) {
				BinaryTree<T> l = this.getLeft();
				if(l!=null) {ans = l.find(t);}
			}
			if(dir>0) {
				BinaryTree<T> r = this.getRight();
				if(r!=null) {ans = r.find(t);}
			}
		}
		return ans;
	}
	//@Override
	/**
	 * Removes the first element that equals to t.
	 */
	//public T remove(T t) {
		///// try implementing this method - efficiently!
	//	return null;
	//}
}
