package classes.week5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class StringFunctions {
	public static void main(String[] a) {
		String t = "12321";
		boolean v = isSymmetric(t);
		String s = "12345";
		String rev_s = reverse(s);
		String rev2_s = reverse(rev_s);
		System.out.println("str: "+t+" isSimetric: "+v);
		System.out.println("s="+s+",  rev(s)="+rev_s+",  rev(rev(s))="+rev2_s);
		System.out.println(s.equals(rev2_s));
		String words = "these are few words ...";
		String[] ww = words.split(" ");
		for(int i=0;i<ww.length;i=i+1) {
			System.out.println(i+") "+ww[i]);
		}
	}
	/*
	 * 3, (4*2), (2-((4*2)*(4*2)))
	 * 2-((4*2)*(4*2))
	 * 
	 */
	public static boolean isSymmetric(String s) {
		boolean ans = false;
		String t = reverse(s);
		//boolean r = (t==s);  // Huge BUG!!
		ans = t.equals(s);
		return ans;
	}
	public static String reverse(String s) {
		String ans = "";
		for(int i=s.length()-1; i>=0;i=i-1) {
			ans=ans+s.charAt(i);
		}
		return ans;
	}

	public static class MyArrayLibrary {

		public static int[] randomIntArray(int size, int range){
			int[]arr = new int[size];
			++range;
			for(int i=0; i<size; i=i+1)
				arr[i] = (int)(Math.random()*range);
			return arr;
		}

		public static int[] randomIntArray(int size, int a, int b){
			int[]arr = new int[size];
			++b;
			for(int i=0; i<size; i=i+1)
				arr[i] = (int)(Math.random()*(b-a)) + a;
			return arr;
		}
		public static double[] randomDoubleArray(int size, int min, int max){
			double[]arr = new double[size];
			double dx = max-min;
			for(int i=0; i<size; i=i+1)
				arr[i] = Math.random()*(dx) + min;
			return arr;
		}
		public static void printArray(int[] arr){
			int i;
			for(i=0; i<arr.length-1; i=i+1)
				System.out.print(arr[i]+", ");
			System.out.println(arr[i]);
		}

		public static void printArray(double[] arr){
			int i;
			for(i=0; i<arr.length-1; i=i+1)
				System.out.print(arr[i]+", ");
			System.out.println(arr[i]);
		}

		public static void printMatrix(int[][] mat){
			for (int i=0; i<mat.length; i++)
				printArray(mat[i]);
		}

		public static int[][] randomIntMatrix(int rows, int cols ,int a, int b){
			int[][] mat = new int[rows][cols];
			++b;
			for(int i=0; i<rows; i=i+1)
			{
				for (int j = 0; j < mat[0].length; j++)
					mat[i][j] = (int)(Math.random()*(b-a)) + a;
			}
			return mat;
		}

		public static boolean isSortedAscending(int[] arr){
			for (int i = 1; i < arr.length; i++) {
				if (arr[i-1] > arr[i]) {
					return false; }
			}
			return true;
		}
		public static boolean isSortedDescending(int[] arr){
			for (int i = 1; i < arr.length; i++) {
				if (arr[i-1] < arr[i]) {
					return false;}
			}
			return true;
		}
		public static boolean isSortedAscending(double[] arr){
			boolean ans = true;
			for (int i = 1; i < arr.length && ans; i++) {
				if (arr[i-1] > arr[i]) {
					ans = false; }
			}
			return ans;
		}
		public static boolean isSortedDescending(double[] arr){
			boolean ans = true;
			for (int i = 1; i < arr.length && ans; i++) {
				if (arr[i-1] < arr[i]) {
					ans = false;}
			}
			return ans;
		}
	}

	/**
	 * Java program for implementation of QuickSort
	 * @author Rajat Mishra, from: https://www.geeksforgeeks.org/quick-sort/
	 *
	 */

	static class QuickSort
	{
	 /* This function takes last element as pivot,
		places the pivot element at its correct
		position in sorted array, and places all
		smaller (smaller than pivot) to left of
		pivot and all greater elements to right
		of pivot */
	 public static int partition(double arr[], int low, int high)
	 {
		 double pivot = arr[high];
		 int i = (low-1); // index of smaller element
		 for (int j=low; j<high; j++)
		 {
			 // If current element is smaller than the pivot
			 if (arr[j] < pivot)
			 {
				 i++;
				 // swap arr[i] and arr[j]
				 double temp = arr[i];
				 arr[i] = arr[j];
				 arr[j] = temp;
			 }
		 }
		 // swap arr[i+1] and arr[high] (or pivot)
		 double temp = arr[i+1];
		 arr[i+1] = arr[high];
		 arr[high] = temp;

		 return i+1;
	 }
	 /* The main function that implements QuickSort()
	 arr[] --> Array to be sorted,
	 low  --> Starting index,
	 high  --> Ending index */
	public static void sort(double arr[]) {
		quickSort(arr, 0, arr.length-1);
	}

	 /* The main function that implements QuickSort()
	   arr[] --> Array to be sorted,
	   low  --> Starting index,
	   high  --> Ending index */
	 public static void quickSort(double arr[], int low, int high)
	 {
		 if (low < high)
		 {
			 /* pi is partitioning index, arr[pi] is
			   now at right place */
			 int pi = partition(arr, low, high);
			 // Recursively sort elements before
			 // partition and after partition
			 quickSort(arr, low, pi-1);
			 quickSort(arr, pi+1, high);
		 }
	 }

	 /* A utility function to print array of size n */
	 public static void printArray(double arr[])
	 {
		 int n = arr.length;
		 for (int i=0; i<n; ++i)
			 System.out.print(arr[i]+" ");
		 System.out.println();
	 }

	 // Driver program
	 public static void main(String args[])
	 {
		 double arr[] = {10, 7, 8, 9, 1, 5};
		 int n = arr.length;
		 sort(arr);
		 System.out.println("sorted array");
		 printArray(arr);
	 }
	}

	static class QuickSortTest {
		@Test
		void testSort() {
			double[] arr = {1,-3.2,1,5,-3.2};
			QuickSort.sort(arr);
			boolean b = MyArrayLibrary.isSortedAscending(arr);
			if(b!=true) {
				fail("ERR: the array should be sorted!");
			}
		}

	}

	/**
	 * output for 40,000 int array:
	 * Bubble sort time = 1.644 secs,  is sorted? true
	 * Selection sort time = 0.352 secs,  is sorted? true
	 * Insertion sort time = 0.585 secs,  is sorted? true
	 * My slow Insertion sort time = 2.881 secs,  is sorted? true
	 * Recursive Merge sort time = 0.014 secs,  is sorted? true
	 * Java sort time = 0.021 secs,  is sorted? true

	Found at index 20057 the item 20000

	Bubble sort time = 1.646 secs,  is sorted? true
	Selection sort time = 0.368 secs,  is sorted? true
	Insertion sort time = 0.643 secs,  is sorted? true
	My slow Insertion sort time = 2.882 secs,  is sorted? true
	Recursive Merge sort time = 0.018 secs,  is sorted? true
	Java sort time = 0.025 secs,  is sorted? true

	Bubble sort time = 1.668 secs,  is sorted? true
	Selection sort time = 0.363 secs,  is sorted? true
	Insertion sort time = 0.603 secs,  is sorted? true
	My slow Insertion sort time = 2.891 secs,  is sorted? true
	Recursive Merge sort time = 0.019 secs,  is sorted? true
	Java sort time = 0.027 secs,  is sorted? true
	 *
	 */
	public static class Sort {

		public static void swap(int[] arr, int i, int j)  {
			 int temp = arr[i];
			 arr[i] = arr[j];
			 arr[j] = temp;
		}


		public static void bubbleSort(int arr[]) {
			boolean hasChanged=true;
			for (int i=arr.length-1 ; i > 0 && hasChanged ; i-- )
			{
				hasChanged = false;
				for (int  j=0 ; j < i ; j++ )
				{
				   if (arr[j] > arr[j+1])
				   {
						 swap(arr, j, j+1);
						 hasChanged = true;
				   }
				}
			}
		}


		public static void selectionSort(int[] arr) {
			for (int i=0 ; i < arr.length ; i++)
			{
				 int minIndex = i;
				 for (int j=i+1 ; j < arr.length ; j++)
				 {
					 if (arr[j] < arr[minIndex])
						 minIndex = j;
				 }
				 swap(arr, i, minIndex);
			}
		}


		public static void selectionSortDescending(int[] arr) {
			int maxIndex;
			for (int i=0 ; i < arr.length ; i++)
			{
				maxIndex = findMaxIndex(arr,i);
				swap(arr, i, maxIndex);
			}
		}


		public static int findMaxIndex(int[] arr, int start) {
			int maxIndex = start;
			for(int i=start+1; i < arr.length ;i++)
			{
				if (arr[i] > arr[maxIndex])
					maxIndex = i;
			}
			return maxIndex;
		}


		public static void insertionSort(int[] arr) {
			for (int  i=1 ; i < arr.length ; i++)
			{
			  for (int  j=i ; j > 0 && arr[j-1] > arr[j] ; j--)
			  {
				  int  temp = arr[j];
				  arr[j] = arr[j-1];
				  arr[j-1] = temp;
			  }
		   }
		}
		/**
		 * This function uses a simple additional array to implement insertion sort
		 * @param arr
		 */
		public static void myInsertionSort(int[] arr) {
			int size = arr.length;
			int[] copy = new int[size];
			for (int  i=0 ; i < arr.length ; i++)	    {
				int index = findMySortedIndex(arr,i); // compute how many entries are smaller than arr[i]
				int sameIndx = findHowManyAreTheSame(arr,i);
				copy[index+sameIndx] = arr[i];
			}
			for(int i=0;i<size;i=i+1) {
				arr[i] = copy[i];
			}
		}
		// computes the proper index of ind in the array
		public static int findMySortedIndex(int[] a, int ind) {
			int ans = 0;
			for(int i=0;i<a.length;i=i+1) {
				if(a[i]<a[ind]) {ans = ans +1;}
			}
			return ans;
		}
		// computes the proper index of ind in the array
			public static int findHowManyAreTheSame(int[] a, int ind) {
				int ans = 0;
				for(int i=0;i<ind;i=i+1) {
					if(a[i]==a[ind]) {ans = ans +1;}
				}
				return ans;
			}

			//////////// MERGE SORT ////////////////
			public static void mergeSort(int[] a) {
				int len = a.length;
				double[] tmp = new double[len];
				for(int i=0;i<len;i=i+1) {tmp[i]=a[i];}
				mergeSort(tmp);
				for(int i=0;i<len;i=i+1) {a[i] = (int)tmp[i];}
			}
			public static void mergeSort(double[] a) {
				int size = a.length;
				if(size>=2) {
					int mid = size/2;
					double[] left = getSubArray(a,0,mid);
					double[] right = getSubArray(a,mid,size);
					mergeSort(left); // recursive call
					mergeSort(right); // recursive call
					double[] merge = mergeArrays(left,right);
					for(int i=0;i<merge.length;i=i+1) {
						a[i] = merge[i];
					}
				}
			}
			public static double[] getSubArray(double[] a, int min, int max) {
				double[] ans = new double[max-min];
				for(int i=min;i<max;i=i+1) {
					ans[i-min] = a[i];
				}
				return ans;
			}

			/**
			 * This function merges two sorted arrays into a single
			 * sorted array.
			 * @param arr1 a sorted a
			 * @param arr2
			 * @return
			 */
			public  static  double[]  mergeArrays(double arr1[],  double arr2[]) {
				double[]  res = new double[arr1.length + arr2.length];
				int i=0, j=0;
				while ( i < arr1.length && j < arr2.length )	{
					if (arr1[i] <= arr2[j]) {
						  res[i+j] = arr1[i]; i=i+1;
					}
					else {
						  res[i+j] = arr2[j]; j=j+1;
					}
				}
				while ( i < arr1.length) {res[i+j] = arr1[i++];}
				while ( j < arr2.length) {res[i+j] = arr2[j++];}
				 return res;
			}

		public static void main(String[] args) {
			final int SIZE = 40000; // then change upto 100000
			int[] arr1 = MyArrayLibrary.randomIntArray(SIZE, SIZE);
			int[] arr2 = Arrays.copyOf(arr1,arr1.length);
			int[] arr3 = Arrays.copyOf(arr1,arr1.length);
			int[] arr4 = Arrays.copyOf(arr1,arr1.length);
			int[] arr5 = Arrays.copyOf(arr1,arr1.length);
			int[] arr6 = Arrays.copyOf(arr1,arr1.length);

			//////// bubbleSort
			long start = System.currentTimeMillis();
			bubbleSort(arr1);
			long end = System.currentTimeMillis();
			System.out.println("Bubble sort time = "+(end-start)/1000.0+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr1));

			//////// selectionSort
			start = System.currentTimeMillis();
			selectionSort(arr2);
			end = System.currentTimeMillis();
			System.out.println("Selection sort time = "+(end-start)/1000.+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr2));

			//////// insertionSort
			start = System.currentTimeMillis();
			insertionSort(arr3);
			end = System.currentTimeMillis();
			System.out.println("Insertion sort time = "+(end-start)/1000.+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr3));

			///////// MyInsertionSort (should be slow!!)
			start = System.currentTimeMillis();
			myInsertionSort(arr4);
			end = System.currentTimeMillis();
			System.out.println("My slow Insertion sort time = "+(end-start)/1000.+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr4));

			/////////// Recursive Merge Sort
			start = System.currentTimeMillis();
			mergeSort(arr5);
			end = System.currentTimeMillis();
			System.out.println("Recursive Merge sort time = "+(end-start)/1000.+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr5));

			////////// Java  built-in sort (Dual-pivot Quicksort)
			start = System.currentTimeMillis();
			Arrays.sort(arr6);
			end = System.currentTimeMillis();
			System.out.println("Java sort time = "+(end-start)/1000.+" secs,  is sorted? "+ MyArrayLibrary.isSortedAscending(arr6));


			/// binary  search
			System.out.println();

			int found = binarySearch(arr4,arr4.length/2,0,arr4.length-1);
			if(found != -1) {
				System.out.println("Found at index " + found + " the item " + arr4[found]);
			}
			else {
				System.out.println("I didn't find it");
			}
		}


		public static int binarySearch(int[] arr, int item, int left, int right) {
			if(left>right)
				return -1;

			int middle = (left+right)/2;
			if(arr[middle]==item)
				return middle;
			if(arr[middle]>item)
				return binarySearch(arr,item,left,middle-1);
			else
				return binarySearch(arr,item,middle+1,right);
		}

		//sort array which contains numbers in the range [0,N]
		public static void countingSort(int[]arr, int N) {
			int index;
			N++;
			int freq[] = new int[N];
			for (int i = 0; i < arr.length; i++)
			{
				index = arr[i];
				freq[index]++;
			}
			int j = 0;
			for (int k=0; k<freq.length; k++)
				for (int i=0; i<freq[k]; i++)
					arr[j++] = k;
		}

		public static void countingSortV2(int[] arr) {
			int min = arr[0], max = arr[0];
			for (int i = 1; i < arr.length; i++)
			{
				if (arr[i]>max)
					max = arr[i];
				else if (arr[i]<min)
					min = arr[i];
			}
			int freq[] = new int[max-min+1];
			for (int i = 0; i < arr.length; i++)
				freq[arr[i]-min]++;
			int j = 0;
			for (int k=0; k<freq.length; k++)
				for (int i=0; i<freq[k]; i++)
					arr[j++] = k+min;
		}
	}

	static class SortTest {
		public static final int K = 1000, M = K*K;
		public static int[] arrK = null;
		public static int[] arrM = null;
		public static double[] arrDoubleM = null;
		@BeforeAll
		static void setUpBeforeClass() throws Exception {

		}
		@BeforeEach
		void setUp() {
			arrK = MyArrayLibrary.randomIntArray(K, K);
			arrM = MyArrayLibrary.randomIntArray(M, M);
			arrDoubleM = MyArrayLibrary.randomDoubleArray(M, 0, M);
			Arrays.sort(arrK);
		}
		@Test
		void testMergeSort() {
			int[] a1 = {3,1,2,1,42};
			Sort.mergeSort(a1);
			boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
			assertTrue(isSorted);
		}
		@Test
		void testMergeSort_large_array() {
			int[] a1 = MyArrayLibrary.randomIntArray(1000, 1000);
			Sort.mergeSort(a1);
			boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
			assertTrue(isSorted);
		}
		@Test
		void testMerge() {
			double[] a1 = {1,3,7,9};
			double[] a2 = {1,2,5,17,34};
			double[] a12 = Sort.mergeArrays(a1, a2);
			boolean isSorted = MyArrayLibrary.isSortedAscending(a12);
			assertTrue(isSorted);
		}
		@Test
		void testSwap() {
			int[] arr = {0,1,2,3,4};
			Sort.swap(arr, 1, 1);
			if(arr[1]!=1) {
				fail("arr[1] should be 1");} // hard coded!
			Sort.swap(arr, 0, 2);
			if(arr[0]!=2 || arr[2]!=0) {
				fail("arr[0] should be 2 and arr[2] should be 0");} // hard coded!
			Sort.swap(arr, 0, 2);
			if(arr[0]!=0 || arr[2]!=2) {
				fail("arr[0] should be 0 and arr[2] should be 2");} // hard coded!
		}

		@Test
		void testBubbleSort() {
			int[] arr = {5,1,2,0,9};
			Sort.bubbleSort(arr);
			if(MyArrayLibrary.isSortedAscending(arr)!=true) {
				fail("arr should be sorted");
			}
		}

		@Test
		void testSelectionSort() {
			int[] arr = {5,1,2,0,9};
			Sort.selectionSort(arr);
			if(MyArrayLibrary.isSortedAscending(arr)!=true) {
				fail("arr should be sorted");
			}
		}

		@Test
		void testSelectionSortDescending() {
			int[] arr = {5,1,2,0,9};
			Sort.selectionSortDescending(arr);
			if(MyArrayLibrary.isSortedAscending(arr)!=false) {
				fail("arr should NOT be sorted Ascending");
			}
			boolean is_sorted_descending = MyArrayLibrary.isSortedDescending(arr);
			assertTrue(is_sorted_descending);
		}


		@Test
		void testInsertionSort() {
			int[] arr = {5,1,2,0,9};
			Sort.insertionSort(arr);
			if(MyArrayLibrary.isSortedAscending(arr)!=true) {
				fail("arr should be sorted");
			}
		}
	/////////////// Performance Testing /////////////
		@Test
		void testMergeSort1() {
				/////////// Recursive Merge Sort
			long start = System.currentTimeMillis();
			Sort.mergeSort(arrM);
			long end = System.currentTimeMillis();
			double dt_sec = (end-start)/1000.0;
			boolean isSorted = MyArrayLibrary.isSortedAscending(arrM);
			System.out.println("Recursive Merge sort time = "+dt_sec+" secs,  is sorted? "+ isSorted);
			assertTrue(isSorted);
			assertTrue(dt_sec<1.0);
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		void testMergeSort2() {
			Sort.mergeSort(arrDoubleM);
			boolean isSorted = MyArrayLibrary.isSortedAscending(arrDoubleM);
			assertTrue(isSorted);
		}
		@Test
		@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
		void testQuickSort1() {
			QuickSort.sort(arrDoubleM);
			boolean isSorted = MyArrayLibrary.isSortedAscending(arrDoubleM);
			assertTrue(isSorted);
		}
	/** DIY: do complete the belowUnit Tests  (and many others) as shown above!
		@Test
		void testBinarySearch() {
			fail("Not yet implemented");
		}

		@Test
		void testCountingSort() {
			fail("Not yet implemented");
		}
		@Test
		void testFindMaxIndex() {
			fail("Not yet implemented");
		}
		@Test
		void testCountingSortV2() {
			fail("Not yet implemented");
		}
	*/
	}
}
