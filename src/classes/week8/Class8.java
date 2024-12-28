package classes.week8;

public class Class8 {
    public static boolean isNumber(String s) {
        boolean ans = true;
        try {
            double d = Double.parseDouble(s);
        }
        catch (Exception e) {
            ans = false;
        }
        return ans;
    }
    public static double getNumber(String s) throws Exception{
        return Double.parseDouble(s);
    }
    public static void main(String[] a) {
        try {
            double d = getNumber("123");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main1(String[] a) throws Exception {

        double d = getNumber("123");

    }
}
