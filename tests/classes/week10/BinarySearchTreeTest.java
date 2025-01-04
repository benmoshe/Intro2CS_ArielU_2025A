package classes.week10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
	private BinarySearchTree<String> _bst1;
	private BinarySearchTree<Double> _bst2;
	@BeforeEach
	void setUp() {
		Comparator<String> c = Comparator.comparing(String::toString);
		// _bst1 = new BinarySearchTree<String>(c);
		_bst1 = new BinarySearchTree<String>(new StringComp());
		
		// this is a "trick" of using anonymous class (out of scope for I2CS)
		//_bst2 = new BinarySearchTree<Double>(new DoubleComp());
		_bst2 = new BinarySearchTree<Double>(new Comparator<Double>(){
		       public int compare(Double o1, Double o2) {
		           if(o1<o2) {return -1;}
		           if(o1>o2) {return 1;}
		           return 0;
		        }
		    }); 
	}

	@Test
	void testAdd() {
		int s = BinaryTreeAlgo.size(_bst1);
		assertEquals(s,0);
		_bst1.add("1");
		s = BinaryTreeAlgo.size(_bst1);
		assertEquals(s,1);
		_bst1.add("0");
		_bst1.add("2");
		s = BinaryTreeAlgo.size(_bst1);
		assertEquals(s,3);
		boolean isBST = BinaryTreeAlgo.isInOrder(_bst1, _bst1.getComp());
		assertTrue(isBST);
	}
	@Test
	void testAdd2() {
		int s = BinaryTreeAlgo.size(_bst1);
		assertEquals(s,0);
		int size = 10;
		for(int i=0;i<size;i++) {
			double d = Math.random();
			int rr = (int)(d*size);
			_bst1.add(""+rr);
		}
		s = BinaryTreeAlgo.size(_bst1);
		assertEquals(s,size);
		BinaryTreeAlgo.inOrderFullPrint(_bst1);
		ArrayList<String> arr = BinaryTreeAlgo.toArrayList(_bst1);
	
		boolean isBST = BinaryTreeAlgo.isInOrder(_bst1, _bst1.getComp());
		assertTrue(isBST);
	}
	@Test
	void testAdd3() {
		int s = BinaryTreeAlgo.size(_bst2);
		assertEquals(s,0);
		int size = 100;
		for(int i=0;i<size;i++) {
			double d = Math.random();
			_bst2.add(d);
		}
		s = BinaryTreeAlgo.size(_bst2);
		assertEquals(s,size);
		ArrayList<Double> arr = BinaryTreeAlgo.toArrayList(_bst2);
		for(int i=1;i<arr.size();i++) {
			if(arr.get(i-1)>arr.get(i)) {
				fail();
			}
		//	System.out.println(i+") "+arr.get(i));
		}
	}
	@Test
	void testFind() {
		String r = _bst1.find("4");
		assertNull(r);
		
		_bst1.add("123");
		r = _bst1.find("4");
		assertNull(r);
		r = _bst1.find("123");
		assertNotNull(r);
	}
	@Test
	@Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
	void testFind2() {
		int size = 1000;
		for(int i=0;i<size;i++) {
			double dd = (int)(Math.random()*size);
			_bst2.add(dd);
		}
		int t = 0;
		for(int i=0;i<size;i++) {
			double d = i;
			Double s = _bst2.find(d);
			if(s!=null) {t++;}
		}
		assertTrue(t>size*0.55);
		assertTrue(t<size*0.75);
	}
	@Test
	void testFind4() {
		int s = BinaryTreeAlgo.size(_bst2);
		assertEquals(s,0);
		int size = 100;
		for(int i=0;i<size;i++) {
			double d = (int)(Math.random()*size);
			_bst2.add(d);
		}
		s = BinaryTreeAlgo.size(_bst2);
		assertEquals(s,size);
		int t =0;
		for(int i=0;i<size;i++) {
			double dd = i;
			Double d = _bst2.find(dd);
			if(d!=null) {t=t+1;}
		}
		assertTrue(t>50);
		assertTrue(t<80);
		System.out.print(t);
	}
	//////////////////////////////////
	private static class DoubleComp implements Comparator<Double> {
		@Override
		public int compare(Double o1, Double o2) {
			// TODO Auto-generated method stub
			// o1<o2 --> -1
			if(o1!=null || o2!= null ) {
				if(o1==null) {return 1;}
				if(o2==null) {return -1;}
				if(o1<o2) {return -1;}
				if(o1>o2) {return 1;}
			}
			return 0;
		}
	}
	private static class StringComp implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			// o1<o2 --> -1
			if(o1!=null || o2!= null ) {
				if(o1==null) {return 1;}
				if(o2==null) {return -1;}
				return o1.compareTo(o2);
			}
			return 0;
		}
	}
}
