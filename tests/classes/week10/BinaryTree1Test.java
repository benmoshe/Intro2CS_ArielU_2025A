package classes.week10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTree1Test {
	private BinaryTree1<String> _bt1;
	@BeforeEach
	void setUp() throws Exception {
		_bt1 = new BinaryTree1<String>();
		
	}

	@Test
	void testBinaryTree1() {
		assertTrue(_bt1.isEmpty());
		assertEquals(_bt1.getLeft(), null);
		assertEquals(_bt1.getRight(), null);
	}

	@Test
	void testGetRoot() {
		String a = "123";
		_bt1.add(a);
		String b = _bt1.getRoot();
		assertEquals(a,b);
		
		
	}

	@Test
	void testIsEmpty() {
		assertTrue(_bt1.isEmpty()); 
		_bt1.add("123");
		assertFalse(_bt1.isEmpty()); 
	}

	@Test
	void testIsLeaf() {
		_bt1.add("123");
		assertTrue(_bt1.isLeaf()); 
		_bt1.add("123");
		assertFalse(_bt1.isLeaf()); 
	}

	@Test
	void testAdd() {
		int size = 1000;
		for(int i=0;i<size;i++) {
			_bt1.add(""+i);
		}
		int s = BinaryTreeAlgo.size(_bt1);
		assertEquals(s,size);
	}
	
	@Test
	void testFind() {
		String r = _bt1.find("4");
		assertNull(r);
		
		_bt1.add("123");
		r = _bt1.find("4");
		assertNull(r);
		r = _bt1.find("123");
		assertNotNull(r);
	}
	@Test
	void testRemove() {
		String r = _bt1.remove("4");
		assertNull(r);
		
		_bt1.add("123");
		r = _bt1.remove("4");
		assertNull(r);
		r = _bt1.remove("123");
		assertEquals(r,"123");
		assertEquals(_bt1.size(),0);
		_bt1.add("1");
		_bt1.add("2");_bt1.add("3");
		_bt1.add("2");_bt1.add("3");
		r = _bt1.remove("1");
		assertEquals(r,"1");
		assertEquals(_bt1.size(),4);
		r = _bt1.remove("2");
		assertEquals(r,"2");
		assertEquals(_bt1.size(),3);
	}
	@Test
	void testFind2() {
		int size = 1000;
		for(int i=0;i<size;i++) {
			_bt1.add(""+i);
		}
		int t = 0;
		for(int i=0;i<size;i++) {
			String s = _bt1.find(""+i);
			if(s!=null) {t++;}
		}
		assertTrue(t==size);
		t = 0;
		for(int i=0;i<size;i++) {
			String s = _bt1.find("_"+i);
			if(s!=null) {t++;}
		}
		assertTrue(t==0);
	}
	@Test
	void testGet() {
		int size = 10;
		for(int i=0;i<size;i++) {
			_bt1.add(""+i);
		}
		int t = 0;
		for(int i=0;i<size;i++) {
			String s = _bt1.get(i);
			if(s!=null) {t++;}
		//	System.out.println(i+") "+s);
		}
		assertTrue(t==size);
		t = 0;
		for(int i=0;i<size;i++) {
			String s = _bt1.find("_"+i);
			if(s!=null) {t++;}
		}
		assertTrue(t==0);
	}
	@Test
	void testIterator() {
		int size = 10;
		for(int i=0;i<size;i++) {
			_bt1.add(""+i);
		}
		Iterator<String> iter = _bt1.iterator();
		int i=0;
		while( iter.hasNext()) {
			String s1 = iter.next();
			String s2 = _bt1.get(i);
			assertEquals(s1, s2);
			i=i+1;
		}
	}
}
