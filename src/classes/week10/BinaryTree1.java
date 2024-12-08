package classes.week10;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree1<T> implements BinaryTree<T>, Serializable{
	/**
	 * String s = "":
	 * for(int i=0;i<10000;i++){
	 * 		s = s = ""+i;
	 * }
	 */
	private static final long serialVersionUID = 1L;
	protected T _root;
	protected BinaryTree<T> _left, _right;
	protected int _modeCount;
	
	public BinaryTree1() {this(null);}
	public BinaryTree1(T a) {_root=a;_left=null;_right=null;_modeCount=0;}
	@Override
	public BinaryTree<T> getLeft() {
		return _left;
	}
	@Override
	public BinaryTree<T> getRight() {
		return _right;
	}
	@Override
	public T getRoot() {
		return _root;
	}

	@Override
	public boolean isEmpty() {
		return _root==null;
	}
	@Override
	public int size() {
		int ans = 0;
		if(!this.isEmpty()) {
			ans = 1;
			if(getLeft()!=null) {ans += getLeft().size();}
			if(getRight()!=null) {ans += getRight().size();}
		}
		return ans;
	}
	@Override
	public boolean isLeaf() {
		return !this.isEmpty() && _left==null && _right==null;
	}
	@Override
	public void add(T a) {
		// null is NOT a valid data (will not be inserted to this binary tree
		if(a!=null) {
			_modeCount++; // this is required as each recursive call uses a nother _modecount)
			if(this.isEmpty()) {_root = a;}
			else {
				double d = Math.random();
				if(d<0.5) {
					if(_left==null) {_left = new BinaryTree1<T>(a); _modeCount++;}
					else {_left.add(a);}
				}
				else {
					if(_right==null) {_right = new BinaryTree1<T>(a); _modeCount++;}
					else {_right.add(a);}
				}
			}
		}
	}
	public int getModeCount() {return _modeCount;}
	@Override
	public T find(T t) {
		T ans = null;
		if(!this.isEmpty()) {
			if(this.getRoot().equals(t)) {ans = getRoot();}
			else {
				BinaryTree<T> l = this.getLeft();
				if(l!=null) {ans = l.find(t);}
				if(ans==null) {
					BinaryTree<T> r = this.getRight();
					if(r!=null) {ans = r.find(t);}
				}
			}
		}
		return ans;
	}
	@Override
	public T get(int i) {
		T ans = null;
		int size = size(), l=0, r =0;
		if(i>=0 && i< size) {
			if(getLeft()!=null) {l = getLeft().size();}
			if(getRight()!=null) {r = getRight().size();}
			if(i<l) { return getLeft().get(i);}
			if(i==l) {return this.getRoot();}
			if(i>l) { return getRight().get(i-(l+1));}
		}
		return ans;
	}
	@Override
	public Iterator<T> iterator() {
	//	return new InOrderIeterator();
		return iterator2();
	}
	//@Override
	public Iterator<T> iterator2() {
		ArrayList<T> arr = BinaryTreeAlgo.toArrayList(this);
		return arr.iterator();
	}
	/////////////////// Slow (very slow) iterator - implemented using the get method) /////////////////
	private class InOrderIeterator implements Iterator<T> {
		private int _ind=0;
		private int _mc;
		
		InOrderIeterator() {
			_mc = getModeCount();
		}
		@Override
		public boolean hasNext() {
			if(!isValid()) {throw new RuntimeException("In valid iterator - The BinaryTree was changed sience the iterator was constructed");}
			return _ind < size();
		}

		@Override
		public T next() {
			if(!isValid()) {throw new RuntimeException("In valid iterator - The BinaryTree was changed sience the iterator was constructed");}
			T ans = get(_ind);
			_ind++;
			return ans;
		}
		public boolean isValid() {
			return _mc == getModeCount();
		}	
	}
	@Override
	/**
	 * Removes the first element that equals to t.
	 */
	public T remove(T t) {
		T ans = null;
		ArrayList<T> tt = BinaryTreeAlgo.byLevel(this);
	//	ArrayList<T> tt = BinaryTreeAlgo.toArrayList(this);
		Iterator<T> iter = tt.iterator();
		while(iter.hasNext() && ans==null) {
			T curr = iter.next();
			if(curr.equals(t)) {iter.remove(); ans=curr;}
		}
		if(ans!=null) {
			_root = null; _left=null; _right=null;
			iter = tt.iterator();
			while(iter.hasNext()) {this.add(iter.next());}
		}
		return ans;
	}
	/**
	 * 				1
	 * 			2		3
	 * 		4		  5    6
	 * 				7     8
	 *  0. if(!isEmpty()) {
	 *  1. 	q = newQ<T>(); // ArrayList<T> //{}
	 *  2.  q.add(_root);  // {1}
	 *  3.  while(!q.isEmpty()) {
	 *  4. 		BT curr = q.remove(0); // q.get(0); //{}, {3}, {4}
	 *  5.		SOP(curr.getRoot());	//1.2,3. 
	 *  6. 		if(curr.getLeft()!=null) {q.add(curr.getLeft());} // {2}, {3,4},{4,5} 
	 *  7. 		if(curr.getRight()!=null) {q.add(curr.getRight());} // {2,3}, {4,5,6}
	 *  8. 	}
	 *  
	 *  
	 * @return
	 */
	@Override
	public Iterator<T> iteratorByLevel() {
		return BinaryTreeAlgo.byLevel(this).iterator();
	}
}
