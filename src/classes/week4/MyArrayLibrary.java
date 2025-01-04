package classes.week4;

public class MyArrayLibrary {

	/**
	 * This function creates an array of random integers 
	 * each in the range of [0,range]
	 * @param size
	 * @param range
	 * @return
	 */
	public static int[] randomIntArray(int size, int range){
		return randomIntArray(size, 0, range);
	}
	/**
	 * This function creates an array of random integers 
	 * each in the range of [min,max]
	 * @param size
	 * @param min,max as a range
	 * @return
	 */
	public static int[] randomIntArray(int size, int min, int max){
		int[]arr = new int[size];
		++max;
		for(int i=0; i<size; i=i+1) {
			//double dx = max-min;
			//double t = Math.random()*dx; // [0,max-min)
			//t= t + min; // [min,max)
			double t = randomDouble(min, max);
			arr[i] = (int)t;
		}
		return arr;
	}
	public static double randomDouble(double min, double max) {
		double ans = Math.random(); // [0,1)
		double dx = max-min;
		ans = ans * dx; // [0,dx) == [0,max-min)
		ans += min; // [min. dx+min) = [min, max)
		return ans;
	}
	
	public static void printArray(int[] arr){
		int i;
		for(i=0; i<arr.length-1; i=i+1) {
			System.out.print(arr[i] + ", ");
		}
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
			int[] arr = randomIntArray(cols, a,b);
			mat[i] = arr;
		//	for (int j = 0; j < mat[0].length; j++)
		//		mat[i][j] = (int)(Math.random()*(b-a)) + a;
		}
		return mat;
	}
/**
 * This function computes the average of all the array values.
 * @param arr
 * @return
 */
	public static double average(int[] arr) {
		double sum = 0;
		for(int i=0;i<arr.length;i=i+1) {
			sum = sum +arr[i];
		}
		double ave = sum / arr.length;
		return ave;
	}
	/**
	 * search for the index of the maximal value in the array;
	 * @param arr
	 * @return the index of the max entry in the array
	 */
	public static int maxIndex(int[] arr) {
		int ans = 0;
		for(int i=1;i<arr.length;i=i+1) {
			if(arr[i]>arr[ans]) {ans = i;}
		}
		return ans;
	}/**
	 * search for the index of the minimal value in the array;
	 * @param arr
	 * @return the index of the minimum entry in the array
	 */
	public static int minIndex(int[] arr) {
		int ans = 0;
		for(int i=1;i<arr.length;i=i+1) {
			if(arr[i]<arr[ans]) {ans = i;}
		}
		return ans;
	}

	/**
	 * This static function finds the index of the smallest entry with in [start, arr.length)
	 * Example:
	 * arr = {4,-2,6,1,0,9}
	 * start = 2
	 * minInd = 4;
	 * @param arr
	 * @param start
	 * @return
	 */
	public static int minIndex(int[] arr, int start) {
		int ans = start;
		for(int i=start+1;i<arr.length;i=i+1) {
			if(arr[i]<arr[ans]) {ans = i;}
		}
		return ans;
	}
	public static void swap(int[] arr, int i1, int i2) {
		int t = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = t;
	}
	public static void sort(int[] arr) {
		if(arr!=null && arr.length>1) {
			for(int i=0;i<arr.length;i=i+1) {
				int minI = minIndex(arr,i);
				swap(arr, i, minI);
			}
		}
	}
}
