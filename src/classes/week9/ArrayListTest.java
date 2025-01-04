package classes.week9;
/**
0) a
1) bb
2) ccc
a
bb
ccc

 */
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] a) {
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("a");
		a1.add("bb");
		a1.add("ccc");
		
		for(int i=0;i<a1.size();i++) {
			System.out.println(i+") "+a1.get(i));
		}
		
		Iterator<String> itr1 = a1.iterator();
	//	for( ; itr1.hasNext() ; ) {
		while(itr1.hasNext()) {
			String s1 = itr1.next();
			System.out.println(s1);
		}
	}
}
