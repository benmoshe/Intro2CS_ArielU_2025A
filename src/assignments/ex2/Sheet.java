package assignments.ex2;

import java.io.IOException;

/**
 * ArielU. Intro2CS, Ex2: https://docs.google.com/document/d/1-18T-dj00apE4k1qmpXGOaqttxLn-Kwi/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 * DO NOT CHANGE THIS INTERFACE:
 *
 * This interface represents a simple SpreadSheet, which include a 2D
 * array of Cells, with get & set methods for each cell (int x, int y), as well as width, height of this SpreadSheet.
 * The main methods of the interface are:
 *
 * String eval(int x, int y), computes the actual String which should be presented in the x,y cell.
 *
 * eval(), computes the actual 2D array of Strings which should be presented of the SpreadSheet.
 *
 * int[][] depth(), computes a 2D array of the same dimension as this SpreadSheet, each entry holds its dependency depth.
 */
public interface Sheet {
    /**
     * Check is the x,y coordinate is with in this table.
     * @param x - integer, x-coordinate of the table (starts with 0).
     * @param y - integer, y-coordinate of the table (starts with 0).
     * @return true iff the x,y coordinate is a valid entry (cell) with in this spreadsheet.
     */
    boolean isIn(int x, int y);

    /**
     * @return the dimension (length) of the x-coordinate of this spreadsheet.
     *
     */
    public int width();

    /**
     * @return the dimension (length) of the y-coordinate of this spreadsheet.
     */
    public int height();

    /**
     * This method changes the x,y cell to a cell with the data c.
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @param c - the string representation of the cell.
     */
    public void set(int x, int y, String c);

    /**
     * Return the Cell in the x,y, position (or null if not in).
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @return the cell in the x,y coordinate.
     */
    public Cell get(int x, int y);
    /**
     * Return the cell @ the coordinate (entry). E.g., the String "B3" will be translated to [1][3].
     * @param entry
     * @return the cell at the X.Y coordinate, or null if cords is an illegal coordinate or is out of this SprayedSheet.
     */
    public Cell get(String entry); // G12

    /**
     *
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @return the string that will be presented in the x,y entry.
     */
    public String value(int x, int y);
    /**
     * Evaluates (computes) the value of the cell in the x,y coordinate.
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @return the string that will be presented in the x,y cell
     */
    public String eval(int x, int y);

    /**
     * Evaluates (computes) all the values of all the cells in this spreadsheet.
     */
    public void eval();
    /**
     *  Computes a 2D array of the same dimension as this SpreadSheet, each entry holds its dependency depth.
     *  if a cell is not dependent on any other cell its depth is 0.
     *  else assuming the cell depends on cell_1, cell_2... cell_n, the depth of a cell is
     *  1+max(depth(cell_1), depth(cell_2), ... depth(cell_n)).
     *  In case a cell os a circular dependency (e.g., c1 depends on c2 & c2 depends on c1) its depth should be -1.
     */
    public int[][] depth();

    /**
     * Saves this SpreadSheet into a text file.
     * Only none empty cells should be saved.
     * You can assume that the width and the height of the loaded SpreadSheet are as defined in
     * Ex2Utils WIDTH & HEIGHT.
     * The text file has the following format:
     * "First line: just a header line - should not be parsed.
     * "Line 1: <x>,<y>, The cell String, remarks (not to be parsed).
     *
     * E.g.,
     * I2CS ArielU: SpreadSheet (Ex2) assignment - this line should be ignored in the load method
     * 0,0,1
     * 0,1,=2+a0
     * 0,2,=a1*1.4,remark(optional)
     * 0,3,a string without a comma
     *
     * @param fileName a String representing the full (an absolute or relative path tp the saved file).
     * @throws IOException an exception might be throed if the flie can not be saved.
     */
    public void save(String fileName) throws IOException;
    /**
     * Load the content of a saved SpreadSheet into this SpreadSheet.
     * Note: all the old cells in before the load operation will be cleared.
     * "First line: just a header line - should not be parsed.
     * "Line 1: <x>,<y>, The cell String, remarks (not to be parsed).
     *
     * E.g.,
     * I2CS ArielU: SpreadSheet (Ex2) assignment - this line should be ignored in the load method
     * 0,0,1
     * 0,1,=2+a0
     * 0,2,=a1*1.4,remark
     * 0,3,a string without a comma
     * 11=3, this line should be ignored as it is in the wrong format
     * 1,2,3, this cell should be loaded to the table.
     *
     * @param fileName a String representing the full (an absolute or relative path to the loaded file).
     * @throws IOException an exception might be throed if the file can not be loaded.
     */
    public void load(String fileName) throws IOException;
}
