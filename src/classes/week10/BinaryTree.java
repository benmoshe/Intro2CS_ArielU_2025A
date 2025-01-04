package classes.week10;
import java.util.Iterator;

/**
 * This is a simple interface for Binary Trees 
 * @author boaz.benmoshe
 *
 * @param <T>
 */
public interface BinaryTree<T> {
	/**
	 * @return the left (sub) tree - might be null. */
	public BinaryTree<T> getLeft();
	/**
	 * @return the right (sub) tree - might be null. */
	public BinaryTree<T> getRight();
	public T getRoot();
	public boolean isEmpty();
	/**
	 * 
	 * @return the number of elements in this binary tree.
	 */
	public int size();
	/**
	 * Adds the data "a" to this tree, in a regular BT can be implemented using a random (left/right)
	 * In Binary Search Tree - is done using the InOrder (natural) Order.
	 * @param a
	 */
	public void add(T a);
	/**
	 * @param i the index
	 * @return the element in the i'th position (inorder) in this binary tree 
	 */
	public T get(int i);
	public boolean isLeaf();
	/**
	 * search the binary tree for an element that equals to t. If exists - returns it.
	 * none - returns null.
	 * @param t
	 * @return
	 */
	public T find(T t);
	/** returns an in_order iterator */
	public Iterator<T> iterator();
	/**
	 * 				1
	 * 			2		3
	 * 		4		  5    6
	 * 				7     8
	 *  		
	 * @return
	 */
	public Iterator<T> iteratorByLevel();
	public T remove(T element);
	// public BinaryTree<T> copy();
	

}
