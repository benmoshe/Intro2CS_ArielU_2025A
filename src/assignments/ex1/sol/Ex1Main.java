package assignments.ex1.sol;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main test"
 * Make sure you implement all needed functions.
 * Make sure you have no errors running the main function.
 * Implement an Ex1Test.java (JUnit tester class).
 * output example:
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                boolean isNum1 = Ex1_sol.isNumber(num1);
                int n1 = Ex1_sol.number2Int(num1);
                System.out.println("num1= " + num1 + " is number: " + isNum1 + " , value: " + n1);
                if (!isNum1) {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                } else {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (!num2.equals(quit)) {
                        boolean isNum2 = Ex1_sol.isNumber(num2);
                        int n2 = Ex1_sol.number2Int(num2);
                        System.out.println("num2= " + num2 + " is number: " + isNum2 + " , value: " + n2);
                        if (isNum2) {
                            System.out.println("Enter a base for output: (a number [2,16] ");
                            int base = sc.nextInt();
                            if (base >= 2 && base <= 16) {
                                String n1_plus_n2 = Ex1_sol.int2Number(n1 + n2, base);
                                String n1_mul_n2 = Ex1_sol.int2Number(n1 * n2, base);
                                System.out.println(num1 + " + " + num2 + " = " + n1_plus_n2);
                                System.out.println(num1 + " * " + num2 + " = " + n1_mul_n2);
                                String[] numbers = {num1, num2, n1_plus_n2, n1_mul_n2};
                                String nums = "[" + num1 + "," + num2 + "," + n1_plus_n2 + "," + n1_mul_n2 + "]";
                                int maxInd = Ex1_sol.maxIndex(numbers);
                                System.out.println("Max number over " + nums + " is: " + numbers[maxInd]);
                            } else {
                                System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                            }
                        } else {
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        }
                    }
                }
            }
        }
        System.out.println("quiting now...");
    }
}
