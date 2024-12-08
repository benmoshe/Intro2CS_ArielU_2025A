package classes.week10;

import java.util.Comparator;
import java.util.Scanner;

public class TestingBT {
	public static void main(String[] args) {
		int size = 1000;
		BinaryTree<Integer> bt = new BinaryTree1<Integer>();
		for(int i=0;i<size;i++) {
			bt.add(i);
		}
		int h = BinaryTreeAlgo.height(bt);
		System.out.println("Height: "+h);
		Comparator<String> comp = new StringComparator();
		BinarySearchTree<String> bst = new BinarySearchTree<String>(comp);
		for(int i=0;i<size;i++) {
			int e = (int)(Math.random()*1000);
			bst.add("_"+e);
		}
		h = BinaryTreeAlgo.height(bst);
		System.out.println("Height: "+h);
		//	BinaryTreeAlgo.inOrderPrint(bst);	
		String str = "saved_bst.obj";
		BinaryTreeAlgo.save(bt, str);
		BinaryTree<Integer> bt2 = (BinaryTree<Integer>)BinaryTreeAlgo.load(str);
		System.out.println(bt.size()+" =?= "+bt2.size());
		demoGUI();
		
		
	}
	/** Use StdDraw to draw a Binary Tree */
	public static void demoGUI() {
		Comparator<String> comp = new StringComparator();
		BinarySearchTree<String> bst = new BinarySearchTree<String>(comp);
		String[] nodes = {"5","2","0","4","9"}; 
		for(int i=0;i<nodes.length;i++) {bst.add(nodes[i]);}
		BinaryTreeAlgo.draw(bst);
		Scanner sc = new Scanner(System.in);
		String d="";
		while(!d.equals("done")) {
			System.out.println("input a String: (done to quit) ");
			d = sc.next();
			if(!d.equals("done")) {
				bst.add(""+d);
				BinaryTreeAlgo.draw(bst);
				System.out.println(BinaryTreeAlgo.minLevelLeaf(bst));
			}
			
		}
		d="";
		while(!d.equals("done")) {
			System.out.println("input a String to delete: (done to quit) ");
			d = sc.next();
			if(!d.equals("done")) {
				bst.remove(""+d);
				BinaryTreeAlgo.draw(bst);
			}
		}
	}
}
class StringComparator implements Comparator<String> {
	public StringComparator(){;}
	public int compare(String obj1, String obj2) {
		if (obj1 == obj2) {
			return 0;
		}
		if (obj1 == null) {
			return -1;
		}
		if (obj2 == null) {
			return 1;
		}
		return obj1.compareTo(obj2);
	}
}
