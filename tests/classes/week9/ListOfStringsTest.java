package classes.week9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListOfStringsTest {

	@Test
	void testListOfStrings() {
		ListOfStrings l = new ListOfStrings();
		assertTrue(l.isEmpty());
	}

	@Test
	void testAdd() {
		String s = "abc";
		ListOfStrings l = new ListOfStrings();
		l.add(s);
		assertTrue(l.contains(s));
		l.add(s);
		l.removeElementAt(0);
		assertTrue(l.contains(s));
	}	

	@Test
	void testContains() {
		String s = "abc";
		ListOfStrings l = new ListOfStrings();
		assertFalse(l.contains(s));
		l.add(s);
		assertTrue(l.contains(s));
		l.removeElementAt(0);
		assertFalse(l.contains(s));
	}

	@Test
	void testIsEmpty() {
		ListOfStrings l = new ListOfStrings();
		assertTrue(l.isEmpty());
		l.add("123");
		assertFalse(l.isEmpty());
	}

	@Test
	void testSize() {
		ListOfStrings l = new ListOfStrings();
		assertEquals(l.size(),0);
		l.add("123");
		assertEquals(l.size(),1);
		l.add("123");
		l.add("123");
		assertEquals(l.size(),3);
	}
//////////// Make sure you can implement the JUnits below //////////
	/*
	@Test
	void testToString() {
		fail("Not yet implemented");
	}
	@Test
	void testGet() {
		fail("Not yet implemented");
	}
	@Test
	void testAddAt() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveElementAt() {
		fail("Not yet implemented");
	}
	
	@Test
	void testListOfStringsListOfStrings() {
		fail("Not yet implemented");
	}
	*/
}

