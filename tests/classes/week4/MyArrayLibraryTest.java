package classes.week4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MyArrayLibraryTest {

	/**
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
*/
	@Test
	void testMax() {
		int[] arr = {0,10,2,3,4,5,16,1,2,3,4};
		int maxInd = MyArrayLibrary.maxIndex(arr);
		if(maxInd!=6) {
			fail("Wrong maxIndex  - should be 6");
		}
	}
	@Test
	void testMin() {
		int[] arr = {0,1,2,3,4,-7,5,6,1,2,3,4};
		int maxInd = MyArrayLibrary.minIndex(arr);
		if(maxInd!=5) {
			fail("Wrong maxIndex  - should be 6");
		}
	}
	@Test
	void testMinInd2() {
		 int[] arr = {4,2,6,1,0,9};
		 int minInd = 2;
		 int right = 4;
		 int minI = MyArrayLibrary.minIndex(arr,minInd);
		 if(right!=minI) {
			 fail("Fichsa Fichsa");
		 }
	}
	@Test
	void testAve1() {
		int[] arr = {1};
		double ave = MyArrayLibrary.average(arr);
		assertEquals(ave, 1, 0.000001);
	}
	@Test
	void testAve2() {
		int[] arr = {1,2};
		double ave = MyArrayLibrary.average(arr);
		assertEquals(ave, 1.5, 0.000001);
	}
	@Test
	void testRandomIntArrayIntInt() {
		int max_value = 100, size = 1000;
		int[]  arr1 = MyArrayLibrary.randomIntArray(size, max_value);
		double ave = MyArrayLibrary.average(arr1);
		double exp_ave = max_value/2.0;
		double err = Math.abs(exp_ave - ave);
		assertEquals(exp_ave, ave, 1);
		// if(err>max_value/10.0) {
			// fail("Wrong average");}
	}

	@Test
	void testRandomIntArrayIntIntInt() {
		int size = 1000, min = 1, max = 6;
		int[]  arr1 = MyArrayLibrary.randomIntArray(size, min, max);
		double ave = MyArrayLibrary.average(arr1);
		double exp_ave = (max+min)/2.0;
		double err = Math.abs(exp_ave - ave);
		assertEquals(exp_ave, ave, 0.1);
		// if(err>max_value/10.0) {
			// fail("Wrong average");}
	}
	@Test
	public void testSort() {
		int[] a1= {17,3,-2,12,9};
		MyArrayLibrary.sort(a1);
		boolean ok = true;
		for(int i=0;i<a1.length-1;i=i+1) {
			if(a1[i]>a1[i+1]) {ok = false;}
		}
		if(!ok) {
			fail("Error: a the array is not sorted!");}
	}

	@Test
	void minIndex() {
	}
	@Test
	void testSort3() {
		int[] aa = {1,1,1};
		boolean b1 = isSorted(aa);
		assertTrue(b1);
		MyArrayLibrary.sort(aa);
		b1 = isSorted(aa);
		assertTrue(b1);
		int[] a2 = {1};
		b1 = isSorted(a2);
		assertTrue(b1);
	}
	@Test
	void testSort_isNotSorted() {
		int[] aa = {1,3,1};
		boolean b1 = isSorted(aa);
		assertFalse(b1);
		MyArrayLibrary.sort(aa);
		aa[0]= 12;
		b1 = isSorted(aa);
		assertFalse(b1);
		int[] a2 = {4,1};
		b1 = isSorted(a2);
		assertFalse(b1);
	}
	boolean isSorted(int[] a){
		boolean ans = true;
		if(a!=null && a.length>1) {
			for(int i=0;i<a.length-1;i=i+1) {
				if(a[i]>a[i+1]) {ans = false;}
			}
		}
		String a1 = "123";
		return ans;
	}
}
