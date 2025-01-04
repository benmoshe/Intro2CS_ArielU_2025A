package classes.week10;
import classes.week4.StdDraw;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class BinaryTreeAlgo {
	public static <T> int height(BinaryTree<T> bt) {
		int ans = -1;
		if(bt!=null && !bt.isEmpty()) {
			return 1+ Math.max(height(bt.getLeft()), height(bt.getRight()));
		}
		return ans;
	}
	/**
	 * Counts the number of nodes in the binary tree
	 * @param bt
	 * @return
	 */
	public static <T> int size(BinaryTree<T> bt) {
		int ans = 0;
		if(bt !=null && !bt.isEmpty()) {
			ans = 1 + size(bt.getLeft())+ size(bt.getRight());
		}
		return ans;
	}
	public static <T> int inOrderPrint(BinaryTree<T> bt) {
		int ans = 0;
		if(bt!=null && !bt.isEmpty()) {
			int l = inOrderPrint(bt.getLeft());
			System.out.println(bt.getRoot());
			int r = inOrderPrint(bt.getRight());
			ans = 1+l+r;
		}
		return ans;
	}
	public static <T> int minLevelLeaf(BinaryTree<T> bt) {
		int ans = -1;
		if(bt!=null) {
			if(bt.size()==1) {ans = 0;}
			else {
				if(bt.getLeft()==null && bt.getRight()!=null ){
					return 1+minLevelLeaf(bt.getRight());}
				if(bt.getRight()==null && bt.getLeft()!=null) {
					return 1+minLevelLeaf(bt.getLeft());}
				if(bt.getLeft()!=null&&  bt.getRight()!=null) {
					return 1+ Math.min(minLevelLeaf(bt.getLeft()), minLevelLeaf(bt.getRight()));
				}
			}
		}
		
		return ans;
	}
	////////////////////////
	/* 0. if(!isEmpty()) {
		 *  1. 	q = newQ<T>(); // ArrayList<T>
		 *  2.  q.add(_root);  // {1}
		 *  3.  while(!q.isEmpty()) {
		 *  4. 		BT curr = q.first(); // q.get(0); //{}, {3}, {4}
		 *  5. 		if(curr.getLeft()!=null) {q.add(curr.getLeft());} // {2}, {3,4}, {4,5}
		 *  6. 		if(curr.getRight()!=null) {q.add(curr.getRight());} // {2,3}, , {4,5,6}
		 *  7. 	}
	*/
	public static <T> void byLevelPrint(BinaryTree<T> bt) {
		if(bt!=null && !bt.isEmpty()) {
			ArrayList<BinaryTree> q = new ArrayList<BinaryTree>();
			q.add(bt);
			while(!q.isEmpty()) {
				BinaryTree<T> curr = q.remove(0);
				System.out.println(curr.getRoot()+", ");
				if(curr.getLeft()!=null) {q.add(curr.getLeft());}
				if(curr.getRight()!=null) {q.add(curr.getRight());}
			}
		}
	}
	/**
	 * 				1
	 * 			2		3
	 * 		4		  5    6
	 * 				7     8
	 * 
	 * ArrayList<T> byLevel(BinaryTree<T> bt) {
	 *  0. if(bt!=null && !bt.isEmpty()) {
	 *  1. 	q = new ArrayList<BinaryTree<T>>();
	 *  2.  ans = new ArrayList<T>();
	 *  2.  q.add(bt);  // {1}
	 *  3.  while(!q.isEmpty()) {
	 *  4. 		curr = q.remove(0); // q.get(0); //{}, {3}, {4}
	 *  5.		ans.add(curr.getRoot());	//1.2,3. 
	 *  6. 		if(curr.getLeft()!=null) {q.add(curr.getLeft());} // {2}, {3,4},{4,5} 
	 *  7. 		if(curr.getRight()!=null) {q.add(curr.getRight());} // {2,3}, {4,5,6}
	 *  8. 	}
	 */
	public static <T> ArrayList<T> byLevel(BinaryTree<T> bt) {
		ArrayList<T> ans = new ArrayList<T>();
		if(bt!=null && !bt.isEmpty()) {
			ArrayList<BinaryTree<T>> q = new ArrayList<BinaryTree<T>>();
			q.add(bt);
			while(!q.isEmpty()) {
				BinaryTree<T> curr = q.remove(0);
				//System.out.println(curr.getRoot()+", ");
				ans.add(curr.getRoot());
				if(curr.getLeft()!=null) {q.add(curr.getLeft());}
				if(curr.getRight()!=null) {q.add(curr.getRight());}
			}
		}
		return ans;
	}
	///////////////////////
	public static <T> int inOrderFullPrint(BinaryTree<T> bt) {
		return inOrderFullPrint(bt, "");
	}
	public static <T> int inOrderFullPrint(BinaryTree<T> bt, String path) {
		int ans = 0;
		if(bt!=null && !bt.isEmpty()) {
			int l = inOrderFullPrint(bt.getLeft(), path+"L");
			System.out.println(path+":"+bt.getRoot());
			int r = inOrderFullPrint(bt.getRight(), path+"R");
			ans = 1+l+r;
		}
		return ans;
	}
	public static <T> ArrayList<T> toArrayList(BinaryTree<T> bt) {
		ArrayList<T> ans = new ArrayList<T>();
		toArrayList(bt, ans);
		return ans;
	}
	private static <T> void toArrayList(BinaryTree<T> bt, ArrayList<T> arr) {
		if(bt!=null && !bt.isEmpty()) {
			ArrayList<T> l = toArrayList(bt.getLeft());
			ArrayList<T> r = toArrayList(bt.getRight());
			arr.addAll(l);
			arr.add(bt.getRoot());
			arr.addAll(r);
		}
	}
	public static <T> T rightMost(BinaryTree<T> binaryTree) {
		T ans = null;
		BinaryTree<T> tmp = binaryTree;
		while(tmp!=null && !tmp.isEmpty()) {
			ans = tmp.getRoot();
			tmp = tmp.getRight();
		}
		return ans;
	}
	public static <T> T leftMost(BinaryTree<T> bt) {
		T ans = null;
		BinaryTree<T> tmp = bt;
		while(tmp!=null && !tmp.isEmpty()) {
			ans = tmp.getRoot();
			tmp = tmp.getLeft();
		}
		return ans;
	}
	public static <T>boolean isInOrder(BinaryTree<T> bt, Comparator<T> comp) {
		boolean ans = true;
		if(bt!=null && !bt.isEmpty() && !bt.isLeaf()) {
			ans &= isInOrder(bt.getLeft(), comp);
			ans &= isInOrder(bt.getRight(), comp);
			if( bt.getLeft()!=null) {
				int cc = comp.compare( rightMost(bt.getLeft()), bt.getRoot());
				if(cc>0) {ans = false;}
			}
			if( bt.getRight()!=null) {
				int cc = comp.compare( bt.getRoot(), leftMost(bt.getRight()));
				if(cc>=0) {ans = false;}
			}
		}
		return ans;
	}
	/**
	 *  A nice trick for save and load objects
	 * @param ob - the object to be saved
	 * @param name - the name of the file/
	 */
	public static void save(Object ob, String name) {
		try{
			FileOutputStream f = new FileOutputStream(name);
			ObjectOutputStream s = new ObjectOutputStream(f);
				    s.writeObject(ob);
				} 
		catch (IOException error) {
			error.printStackTrace();
		}
		System.out.println("Successfully saved to file "+name+" the Object "+ob);
	}
	public static Object load(String name) {
		Object ans = null;
		try{
			FileInputStream f = new FileInputStream(name);
			ObjectInputStream s = new ObjectInputStream(f);
				    ans = s.readObject();
				} 
		catch (Exception error) {
			error.printStackTrace();
		}
		System.out.println("Successfully loaded the file "+name+" the Object "+ans);
		return ans;
	}
	/////////////////////////////////////////////////

	public static <T> void draw(BinaryTree<T> t) {
		double scale = 10;
		StdDraw.setScale(0, scale);
		StdDraw.clear();
		printGUI(t, scale/2, scale-1, scale/4);
		StdDraw.show();
	}
	public static <T> void printGUI(BinaryTree<T> bt, double x, double y, double scale) {
		if(bt!=null && !bt.isEmpty()) {
			if(bt.getLeft()!=null) {
				printGUI(bt.getLeft(), x-scale, y-1, scale/2);
				StdDraw.line(x, y-0.4, x-scale, y-0.6);
			}
			//System.out.println(bt.getRoot());
			StdDraw.text(x, y, bt.getRoot().toString());
			StdDraw.circle(x, y, 0.4);
			
			//printGUI(bt.getRight(), x+scale, y-1, scale/2);
			if(bt.getRight()!=null) {
				printGUI(bt.getRight(), x+scale, y-1, scale/2);
				StdDraw.line(x, y-0.4, x+scale, y-0.6);
			}
		}
	}
}
