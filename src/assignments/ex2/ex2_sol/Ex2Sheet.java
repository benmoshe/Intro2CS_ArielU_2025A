package assignments.ex2.ex2_sol;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The documentation of this class was removed as of Ex4...
 */
public class Ex2Sheet implements Sheet {
    private Cell[][] table;
    private Double[][] data;
    public Ex2Sheet(int x, int y) {
        table = new SCell[x][y];
        for(int i=0;i<x;i=i+1) {
            for(int j=0;j<y;j=j+1) {
                table[i][j] = new SCell("");
            }
        }
        eval();
    }
    public Ex2Sheet() {
        this(Ex2Utils.WIDTH, Ex2Utils.HEIGHT);
    }

    @Override
    public String value(int x, int y) {
        String ans = "";
        Cell c = get(x,y);
        ans = c.toString();
        int t = c.getType();
        if(t== Ex2Utils.ERR_CYCLE_FORM) {
            ans = Ex2Utils.ERR_CYCLE;
            c.setOrder(-1);
        } // BUG 345
      //  if(t==Ex2Utils.ERR_CYCLE_FORM) {ans = "ERR_CYCLE!";}
        if(t== Ex2Utils.NUMBER || t== Ex2Utils.FORM) {
            ans = ""+data[x][y];
        }
        if(t== Ex2Utils.ERR_FORM_FORMAT) {ans = Ex2Utils.ERR_FORM;}
        return ans;
    }

    @Override
    public Cell get(int x, int y) {
        return table[x][y];
    }

    @Override
    public Cell get(String cords) {
        Cell ans = null;
        Index2D c = new CellEntry(cords);
        int x = c.getX(), y= c.getY();
        if(isIn(x,y)) {ans = table[x][y];}
        return ans;
    }

    @Override
    public int width() {
        return table.length;
    }
    @Override
    public int height() {
        return table[0].length;
    }
    @Override
    public void set(int x, int y, String s) {
        Cell c = new SCell(s);
        table[x][y] = c;
      //  eval();
    }

    ///////////////////////////////////////////////////////////

    @Override
    public void eval() {
        int[][] dd = depth();
        data = new Double[width()][height()];
        for (int x = 0; x < width(); x = x + 1) {
            for (int y = 0; y < height(); y = y + 1) {
                Cell c = table[x][y];
              if (dd[x][y] != -1 && c!=null && (c.getType()!= Ex2Utils.TEXT)) {
                String res = eval(x, y);
                    Double d = getDouble(res);
                    if(d==null) {
                        c.setType(Ex2Utils.ERR_FORM_FORMAT);
                    }
                    else {
                        data[x][y] = d;
                    }
                }
                if (dd[x][y] == -1 ) {
                    c.setType(Ex2Utils.ERR_CYCLE_FORM);
                }
            }
        }
    }

    @Override
    public boolean isIn(int xx, int yy) {
        boolean ans = true;
        if(xx<0 |yy<0 | xx>=width() | yy>=height()) {ans = false;}
        return ans;
    }

    @Override
    public int[][] depth() {
        int[][] ans = new int[width()][height()];
        for (int x = 0; x < width(); x = x + 1) {
            for (int y = 0; y < height(); y = y + 1) {
                Cell c = this.get(x, y);
                int t = c.getType();
                if(Ex2Utils.TEXT!=t) {
                    ans[x][y] = -1;
                }
            }
        }
        int count = 0, all = width()*height();
        boolean changed = true;
        while (changed && count<all) {
            changed = false;
            for (int x = 0; x < width(); x = x + 1) {
                for (int y = 0; y < height(); y = y + 1) {
                    if(ans[x][y]==-1) {
                        Cell c = this.get(x, y);
                     //   ArrayList<Coord> deps = allCells(c.toString());
                        ArrayList<Index2D> deps = allCells(c.getData());
                        int dd = canBeComputed(deps, ans);
                        if (dd!=-1) {
                            ans[x][y] = dd;
                            count++;
                            changed = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public void load(String fileName) throws IOException {
            Ex2Sheet sp = new Ex2Sheet();
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            String s0 = myReader.nextLine();
            if(Ex2Utils.Debug) {
                System.out.println("Loading file: "+fileName);
                System.out.println("File info (header:) "+s0);
            }
            while (myReader.hasNextLine()) {
                s0 = myReader.nextLine();
                String[] s1 = s0.split(",");
               try {
                   int x = Ex2Sheet.getInteger(s1[0]);
                   int y = Ex2Sheet.getInteger(s1[1]);
                   sp.set(x,y,s1[2]);
               }
               catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Line: "+data+" is in the wrong format (should be x,y,cellData)");
               }
        }
            sp.eval();
            table = sp.table;
            data = sp.data;
    }

    @Override
    public void save(String fileName) throws IOException {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("I2CS ArielU: SpreadSheet (Ex2) assignment - this line should be ignored in the load method\n");
            for(int x = 0;x<this.width();x=x+1) {
                for(int y = 0;y<this.height();y=y+1) {
                    Cell c = get(x,y);
                    if(c!=null && !c.getData().equals("")) {
                        String s = x+","+y+","+c.getData();
                        myWriter.write(s+"\n");
                    }
                }
            }
            myWriter.close();
    }

    private int canBeComputed(ArrayList<Index2D> deps, int[][] tmpTable) {
        int ans = 0;
        for(int i=0;i<deps.size()&ans!=-1;i=i+1) {
            Index2D c = deps.get(i);
            int v = tmpTable[c.getX()][c.getY()];
            if(v==-1) {ans=-1;} // not yet computed;
            else {ans = Math.max(ans,v+1);}
        }
        return ans;
    }
    @Override
    public String eval(int x, int y) {
        Cell c = table[x][y];
        String line = c.getData();
        if(c==null || c.getType()== Ex2Utils.TEXT ) {
            data[x][y] = null;
            return line;
        }
        int type = c.getType();
        if(type== Ex2Utils.NUMBER) {
            data[x][y] = getDouble(c.toString());
            return line;
        }
        if (type == Ex2Utils.FORM | type == Ex2Utils.ERR_CYCLE_FORM || type== Ex2Utils.ERR_FORM_FORMAT) {
            line = line.substring(1); // removing the first "="
            if (isForm(line)) {
                Double dd = computeForm(x,y);
                data[x][y] = dd;
                if(dd==null) {
                    c.setType(Ex2Utils.ERR_FORM_FORMAT);
                }
                else {c.setType(Ex2Utils.FORM);}
        }
        else {data[x][y] = null;}
        }
        String ans = null;
        if(data[x][y]!=null) {ans = data[x][y].toString();}
        return ans;
    }
    /////////////////////////////////////////////////
    public static Integer getInteger(String line) {
        Integer ans = null;
        try {
            ans = Integer.parseInt(line);
        }
        catch (Exception e) {;}
        return ans;
    }
    public static Double getDouble(String line) {
        Double ans = null;
        try {
            ans= Double.parseDouble(line);
        }
        catch (Exception e) {;}
        return ans;
    }
    public static String removeSpaces(String s) {
        String ans = null;
        if (s!=null) {
            String[] words = s.split(" ");
            ans = new String();
            for(int i=0;i<words.length;i=i+1) {
                ans+=words[i];
            }
        }
        return ans;
    }

    public int checkType(String line) {
        line = removeSpaces(line);
        int ans = Ex2Utils.TEXT;
        double d = getDouble(line);
        if(d>Double.MIN_VALUE) {ans= Ex2Utils.NUMBER;}
        else {
            if(line.charAt(0)=='=') {
                ans = Ex2Utils.ERR_FORM_FORMAT;
                int type = -1;
                String s = line.substring(1);
                if(isForm(s)) {ans = Ex2Utils.FORM;}
            }
        }
        return ans;
    }
    public boolean isForm(String form) {
        boolean ans = false;
        if(form!=null) {
            form = removeSpaces(form);
            try {
                ans = isFormP(form);
            }
            catch (Exception e) {;}
        }
        return ans;
    }
    private Double computeForm(int x, int y) {
        Double ans = null;
        String form = table[x][y].getData();
        form = form.substring(1);// remove the "="
        if(isForm(form)) {
            form = removeSpaces(form);
            ans = computeFormP(form);
        }
        return ans;
    }
    private boolean isFormP(String form) {
        boolean ans = false;
        while(canRemoveB(form)) {
            form = removeB(form);
        }
        Index2D c = new CellEntry(form);
        if(isIn(c.getX(), c.getY())) {ans = true;}
        else{
            if(isNumber(form)){ans = true;}
            else {
                int ind = findLastOp(form);// bug
                if(ind==0) {  // the case of -1, or -(1+1)
                    char c1 = form.charAt(0);
                    if(c1=='-' | c1=='+') {
                        ans = isFormP(form.substring(1));}
                    else {ans = false;}
                }
                else {
                    String f1 = form.substring(0, ind);
                    String f2 = form.substring(ind + 1);
                    ans = isFormP(f1) && isFormP(f2);
                }
            }
        }
        return ans;
    }
    public static ArrayList<Index2D> allCells(String line) {
        ArrayList<Index2D> ans = new ArrayList<Index2D>();
        int i=0;
        int len = line.length();
        while(i<len) {
            int m2 = Math.min(len, i+2);
            int m3 = Math.min(len, i+3);
            String s2 = line.substring(i,m2);
            String s3 = line.substring(i,m3);
            Index2D sc2 = new CellEntry(s2);
            Index2D sc3 = new CellEntry(s3);
            if(sc3.isValid()) {ans.add(sc3); i+=3;}
            else{
                if(sc2.isValid()) {ans.add(sc2); i+=2;}
                else {i=i+1;}
            }

        }
        return ans;
    }

    private Double computeFormP(String form) {
        Double ans = null;
        while(canRemoveB(form)) {
            form = removeB(form);
        }
        CellEntry c = new CellEntry(form);
        if(c.isValid()) {

            return getDouble(eval(c.getX(), c.getY()));
        }
        else{
            if(isNumber(form)){ans = getDouble(form);}
            else {
                int ind = findLastOp(form);
                int opInd = opCode(form.substring(ind,ind+1));
                if(ind==0) {  // the case of -1, or -(1+1)
                    double d = 1;
                    if(opInd==1) { d=-1;}
                    ans = d*computeFormP(form.substring(1));
                }
                else {
                    String f1 = form.substring(0, ind);
                    String f2 = form.substring(ind + 1);

                    Double a1 = computeFormP(f1);
                    Double a2 = computeFormP(f2);
                    if(a1==null || a2 == null) {ans=null;}
                    else {
                        if (opInd == 0) {
                            ans = a1 + a2;
                        }
                        if (opInd == 1) {
                            ans = a1 - a2;
                        }
                        if (opInd == 2) {
                            ans = a1 * a2;
                        }
                        if (opInd == 3) {
                            ans = a1 / a2;
                        }
                    }
                }
            }
        }
        return ans;
    }
    private static int opCode(String op){
        int ans =-1;
        for(int i = 0; i< Ex2Utils.M_OPS.length; i=i+1) {
            if(op.equals(Ex2Utils.M_OPS[i])) {ans=i;}
        }
        return ans;
    }
    private static int findFirstOp(String form) {
        int ans = -1;
        int s1=0,max=-1;
        for(int i=0;i<form.length();i++) {
            char c = form.charAt(i);
            if(c==')') {s1--;}
            if(c=='(') {s1++;}
            int op = op(form, Ex2Utils.M_OPS, i);
            if(op!=-1){
                if(s1>max) {max = s1;ans=i;}
            }
        }
        return ans;
    }
    public static int findLastOp(String form) {
        int ans = -1;
        double s1=0,min=-1;
        for(int i=0;i<form.length();i++) {
            char c = form.charAt(i);
            if(c==')') {s1--;}
            if(c=='(') {s1++;}
            int op = op(form, Ex2Utils.M_OPS, i);
            if(op!=-1){
                double d = s1;
                if(op>1) {d+=0.5;}
                if(min==-1 || d<=min) {min = d;ans=i;}
            }
        }
        return ans;
    }
    private static String removeB(String s) {
        if (canRemoveB(s)) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }
    private static boolean canRemoveB(String s) {
        boolean ans = false;
        if (s!=null && s.startsWith("(") && s.endsWith(")")) {
            ans = true;
            int s1 = 0, max = -1;
            for (int i = 0; i < s.length()-1; i++) {
                char c = s.charAt(i);
                if (c == ')') {
                    s1--;
                }
                if (c == '(') {
                    s1++;
                }
                if (s1 < 1) {
                    ans = false;
                }
            }
        }
        return ans;
    }
    private static int op(String line, String[] words, int start) {
        int ans = -1;
        line = line.substring(start);
        for(int i = 0; i<words.length&&ans==-1; i++) {
            if(line.startsWith(words[i])) {
                ans=i;
            }
        }
        return ans;
    }

    public static boolean isNumber(String line) {
        boolean ans = false;
        try {
            double v = Double.parseDouble(line);
            ans = true;
        }
        catch (Exception e) {;}
        return ans;
    }
}
