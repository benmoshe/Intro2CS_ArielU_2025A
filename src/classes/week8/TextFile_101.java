package classes.week8;
import classes.week6.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Output:
 * 0) Text file named: file_.txt
1) This is a multi String file,
2) second line ...
3)  3dr...
4) end of file

Exception in thread "main" java.io.FileNotFoundException: file_123.txt (No such file or directory)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:211)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:153)
	at java.base/java.util.Scanner.<init>(Scanner.java:639)
	at week9.TextFile_101.load(TextFile_101.java:44)
	at week9.TextFile_101.main(TextFile_101.java:23)


 * @author boaz.benmoshe
 *
 */
public class TextFile_101 {
	public static void main(String[] a)  {
		String str = "file_123.txt";
		String data = "This is a multi String file,\n"
				+ "second line ...\n ";
		save(str, data);
		try {
			load(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");
		
	}
	public static void save(String file, String data) {
		 try {
		      FileWriter myWriter = new FileWriter(file);
		      myWriter.write("Text file named: "+file+"\n");
			   myWriter.write(data+"\n");
			 Point2D p1 = new Point2D(1,2);
		      myWriter.write("Point "+p1.toString());
		      myWriter.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	public static void load(String file) throws FileNotFoundException {
		//try {
			File myObj = new File(file);
		    Scanner myReader = new Scanner(myObj);
		    int i=0;
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(i+") "+data);
		        i=i+1;
		    }
		    myReader.close();
		//}
	//	catch(Exception e) {
	//		e.printStackTrace();
	//	}
	}


}
