package classes.week5;
public class MyArrayLibrary {

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
		boolean ans = true;
		for (int i = 1; i < arr.length  && ans; i++) {
			if (arr[i-1] > arr[i]) {
				ans = false; }
		}
		return ans;
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
	public static int[] copy(int[] arr) {
		int size = arr.length;
		int[] ans = new int[size];
		for(int i=0;i<size;i=i+1) {ans[i] = arr[i];}
		return ans;
	}
	public static int[] shuffle (int[] arr) {
		int size = arr.length;
		int[] ans = copy(arr);
		for(int i=0;i<size;i=i+1) {
			int i2 = random(i,size);
			swap(ans,i,i2);
		}
		return ans;
	}

	private static void swap(int[] ans, int i, int i2) {
		int t = ans[i];
		ans[i] = ans[i2];
		ans[i2] = t;
	}

	/**
	 * Compute a random integer in range [min, max)
	 * @param min
	 * @param max
	 * @return
	 */
	private static int random(int min, int max) {
		int dx = max-min;
		int ans = (int)(Math.random()*dx);
		ans += min;
		return ans;
	}
}
