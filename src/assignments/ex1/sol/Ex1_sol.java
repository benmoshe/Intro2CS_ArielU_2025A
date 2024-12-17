package assignments.ex1.sol;
/**
 * This class represents a simple solution for Ex1.
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1_sol {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (isNumber(num)) {
            ans = 0;
            int basis = 10;
            int b_index = num.indexOf("b");
            if(b_index>0) {
               // String ba = num.substring(b_index+1);
                char base = num.charAt(b_index+1); // single char
                basis = char2int(base);
            }
            else {b_index = num.length();}
            for(int i=0;i<b_index;i++) {
                int digit = char2int(num.charAt(i));
                int p = b_index-(i+1);
                ans = ans + (int)(digit * Math.pow(basis,p));
            }
        }
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.length() < 1) {
            ans = false;
        } else {
            int b_ind = a.indexOf("b");
                int basis = 10;
                if (b_ind != -1) {
                    if (b_ind == 0 || b_ind != a.length() - 2) {
                        return false;}
                    char ba = a.charAt(b_ind + 1);
                    basis = char2int(ba);
                    if (basis < 2 || basis > 16) {
                        ans = false;
                    }
                }
                else {b_ind = a.length();}
                for (int i = 0; i < b_ind && ans; i++) {
                    char c = a.charAt(i);
                    int v = char2int(c);
                    if (v < 0 || v >= basis) {
                        ans = false;
                    }
                }
            }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in basis nase) equals to num.
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if(num==0) {
            ans = "0";
            if(base != 10) {
                char b = digit2char(base);
                ans += "b"+b;
            }
        }
        else {
            while (num > 0) {
                int d = num % base;
                char c = digit2char(d);
                ans = c + ans;
                num = num / base;
            }
            if(base !=10) {
                ans = ans + "b" + digit2char(base);
            }
        }
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = false;
        if(isNumber(n1) & isNumber(n2)) {
            int v1 = Ex1_sol.number2Int(n1);
            int v2 = Ex1_sol.number2Int(n2);
            if(v1 == v2) {ans = true;}
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int maxInd = 0;
        int v = Ex1_sol.number2Int(arr[maxInd]);
        for(int i=1;i<arr.length;i++) {
            int c = Ex1_sol.number2Int(arr[i]);
            if(c>v) {
                maxInd = i;
                v = c;
            }
        }
        return maxInd;
    }
    public static int char2int(char c) {
        int ans = -1;
        if (c >= '0' && c <= '9') {
            ans = c - '0';
        } else {
            if (c >= 'A' && c <= 'G') {
                ans = 10 + c - 'A';
            }
        }
        return ans;
    }
    public static char digit2char(int t) {
        char ans = '?';
        if(t>=0 && t<=16) {
            if(t<10) {
                ans = (char)('0'+t);
            }
            else {
                ans = (char)('A'+t-10);
            }
        }
        return ans;
    }

}
