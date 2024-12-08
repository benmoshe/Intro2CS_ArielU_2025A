package classes.week8;

import classes.week6.Point2D;
import classes.week7.PointContainer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TextFileTester {
    @Test
    public void testPointContainer() {
        int size = 10;
        PointContainer pc = randomPoints(size);
        String file = "a12.txt";
        save(pc, file);
        PointContainer pc2 = load(file);
        assertEquals(pc, pc2);
    }
    @Test
    public void testPointContainer8() {
        int size = 10;
        PointContainer pc = randomPoints(size);
        String file = "a1.txt";
      //  save(pc, file);
        PointContainer pc2 = load(file);
        pc2.add(new Point2D(1,3));
        assertNotEquals(pc, pc2);
    }

    @Test
    public void testPointContainer2() {
        int size = 10;
        PointContainer pc = randomPoints(size);
        String file = "a1.txt";
        try {
            save2(pc, file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        PointContainer pc2 = null;
        try {
            pc2 = load2(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        assertEquals(pc, pc2);
    }

    private PointContainer randomPoints(int size) {
        PointContainer ans = new PointContainer();
        for (int i = 0; i < size; i = i + 1) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            ans.add(p);
        }
        return ans;
    }

    private static void save(PointContainer pc, String file) {
        try {
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < pc.size(); i = i + 1) {
                myWriter.write(pc.get(i) + "\n");
            }
            myWriter.close();
        } catch (Exception e) {
            System.err.println("Error: the save function failed!");
            e.printStackTrace();
        }
    }

    private static PointContainer load(String file) {
        PointContainer ans = null;
        File myObj = new File(file);
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
            int i = 0;
            ans = new PointContainer();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    Point2D p = new Point2D(data);
                    ans.add(p);
                    i = i + 1;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            myReader.close();

        return ans;
    }

    private static void save2(PointContainer pc, String file) throws IOException {
        FileWriter myWriter = new FileWriter(file);
        for (int i = 0; i < pc.size(); i = i + 1) {
            myWriter.write(pc.get(i) + "\n");
        }
        myWriter.close();
    }

    private static PointContainer load2(String file) throws FileNotFoundException {
        PointContainer ans = null;
        File myObj = new File(file);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        ans = new PointContainer();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Point2D p = new Point2D(data);
            ans.add(p);
            i = i + 1;
        }
        myReader.close();
        return ans;
    }
}
