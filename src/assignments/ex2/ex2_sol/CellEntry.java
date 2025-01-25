package assignments.ex2.ex2_sol;
/**
 * The documentation of this class was removed as of Ex4...
 */
public class CellEntry  implements Index2D {
    private String _data;
    private int x, y;
    public CellEntry(int x, int y) {
        if(x<0 | y<0 | x>= Ex2Utils.ABC.length) {_data = "ERROR!";}
        else {_data = Ex2Utils.ABC[x]+y;}
        init();
    }
    public String toString() {return _data;}
    public CellEntry(String c) {
        _data = c;
        init();
    }
    private void init() {
        x = -1; y= -1;
       if(_data!=null && _data.length()>=2) {
           _data = _data.toUpperCase();
            String s1 = _data.substring(0,1);
            String s2 = _data.substring(1);
            Integer yy = Ex2Sheet.getInteger(s2);
            if(yy!=null) {y=yy;}
            if(y>=0) {
                x = s1.charAt(0) - 'A';
                if(x<0 | x>25) {x=-1;}
          }
       }
       if(x==-1) {_data=null; y=-1;}
    }
    public String toCell() {
        String ans = null;
        if(x>=0 && y>=0) {
            ans = Ex2Utils.ABC[x]+y;
        }
        return ans;
    }
    private void cell2coord(String cell) {
        int x = -1, y=-1;
        if(cell!=null && cell.length()>=2) {
            cell = cell.toUpperCase();
            String s1 = cell.substring(0,1);
            String s2 = cell.substring(1);
            y = Ex2Sheet.getInteger(s2);
            x = s1.charAt(0) - 'A';
        }
    }
    public boolean isIn(Sheet t) {
        return t!=null && t.isIn(x,y);
    }
    @Override
    public boolean isValid() {
        return _data!=null;
    }

    @Override
    public int getX() {return x;}

    @Override
    public int getY() {return y;}
}
