package assignments.ex0;
import java.util.Scanner;

/**
 * Here is a nice documentation written by:  Orya Shlomo:
 *
 * a) We asked to write a code while given a natural even number greater than 4, n, find two prime numbers that the sum of both of them equal to n.
 * First of all, we should invent a function that know says which number is prime and which number is not a prime. This function will have to include all the options. (The explanation about this function is above its code).
 * stage 1: We will open a "for" loop, define p1 as an integer variable. The "for" loop will run over its block below from p1=3 ,while p1 < n/2. After everytime "for" do its block, the value of p1 gets more 2.
 * This "for" loop go over all the odd numbers, because all the even numbers aren't prime. (2 divide all the even numbers without a remainder).
 * Inside "for" we will define a new integer variable, p2, that equal to (n - p1), because want to find two numbers that the sum of both of them equal to n.
 * After this we will open an "if" and use the CheckPrime function to Check if p1 and p2 are prime numbers. If p1 and p2 are prime numbers, print "n = p1 + p2", do "break" and go out from the "for" loop.
 *
 * b) First of all, we define a new integer variable called "p4". We will open a "for" loop that began from p4=2, run while p4 > 0 and after everytime it go over its block, p4 gets 1 into its value.
 * Inside "for" we will define a new integer variable, called p3, such that p4-p3=n. Now, we want to check if p4 and p3 are prime, so we do it with using "if" and "CheckPrime".
 * If p4 and p3 are prime, we will say the program to print "n=p4-p3" and "break", exit from the loop (for). But if does not exist that p4 and p3 are prime, the computer will continue running in "for".
 *
 * c) First, we will define a new integer variable, called counter1, with a first value 0. (Counter1 will count for us all the prime number are between [2,n).
 * Second, we define a for loop and an integer variable i. "for" run from i=2, while i>n  and adding 1 to i after anytime it does the bloch below.
 * Now, we will use "if", because we want to know if i is prime. If i is prime, counter1=counter1+1. (everytime the computer will find
 * a prime number, the counter will rise by one.
 *
 * d) We want to find the composition to any ,"n", natural even number I get.
 * First, if n is prime, we don't need to look for any number, because the decomposition of a prime number is the number itself.
 * so, if I get number=2, I will print "2". If I don't get a prime number, I need to find two prime numbers such that
 * the multiple of these two numbers is "n" and both of them are prime. If I found two numbers that fit, I print the multiple of them. But
 * if I found only two number such that one of them doesn't prime, i will do enter into "n" the value of this number
 * and do the algorithm above until "n" become to a prime number and everytime I find a prime number that divide "n" without a remainder, I print this number.
 *
 * e) We will use "System.nanoTime()" in order to measure the time. I save the time before the program begin and do the sam at the end of the program. After the program finished running,
 * I compute the difference between them and print. (The measure at the start and at the end, will be with "long",
 * because I want the measure to be more precise.
 *
 * -----------------------------------------------------------------------
 *
 * Here is a nice pseudo-code solution written by:Yotam Shahak
 *  Pseudo-code:
 *  A. find if number is prime or not
 *  1. input (n)                           // assuming n is a natural number n>0
 *  2. if (n<2) return false               // if n<2 n is Not Prime
 *  3. if (n=2||3) return true             // if n=2 or n=3 n is Prime
 *  4. if (n%2=0 || n%3=0) return false    // if it is zero, n is Not Prime(divide by 2 or 3)
 *  5. for (i=5, i*i<=n, i+6){             // loop over all numbers 5<=i<=n^0.5 increment i by 6
 *  6. if (n%i=0 || n%(i+2)=0 return false // if it is zero, n is Not Prime
 *  7. }                                   // the end of for loop
 *  8. return true                         // n is Prime
 *
 *  B. find two Prime numbers p1+p2=N
 *  1. int p1=2
 *  2. while p1< N-1                       // loop over all number (2,N-1)
 *  3. if p1 (isPrime){                    // check if p1 is Prime number or not
 *  4. int p2=N-p1                         // the value of p2
 *  5. if p2 is Prime                      // check if p2 is Prime number or not
 *  6. print (N=p1+p2)}                    // print the answer
 *  7. Break                               // end of while loop
 *  8. p1++                                // increment p1 by 1
 *
 *  C. find two Prime numbers p4-p3=N
 *  1. int p3=2
 *  2. while p3< Max value of Int0         // loop over all number (2, Max value of Int)
 *  3. if p1 (isPrime){                    // check if p1 is Prime number or not
 *  4. int p4= N+p3                        // the value of p3
 *  5. if p4 is Prime                      // check if p4 is Prime number or not
 *  6. print (N=p4-P3)}                    // print the answer
 *  7. Break                               // end of while loop
 *  8. p3++                                // increment p1 by 1
 *
 *  D. find how many Prime numbers (2,N)
 *  1. int y=0                             // Value of Prime numbers
 *  2. int p5=2                            // first bumber to check if Prime
 *  3. while (p5<N-1) {                    // loop over all number (2,N-1)
 *  4. if p5 isPrime                       // check if p5 is Prime or not
 *  5. Y++ & p5++                          // increment y by 1 and p5 by 1
 *  6. else p5++                           // increment p5 by 1
 *  7. }                                   // end of while loop
 *  8. print y number between (2,N)        // print answer
 *
 *  E. Find which prime numbers are needed by multiplication
 *  to get q1*q1....=N
 *  1. int q1= 2                           // first number to check
 *  2. print N=                            // print first value of N
 *  3. while (q1>1) {                      // loop untill q1=1
 *  4. if (N%q1=0)  {                      // if it is zero N divides by q1
 *  5. N= N/q1                             // new value of N
 *  6. if N!=1                             // check value of N
 *  7. print q1*                           // print value of q1
 *  8. else                                // if N=1
 *  9. print q1 }                          // print value of q1
 *  10. q1 ++                              // increment q1 by 1
 *
 *  F. find system running time
 *  1. startTime = nanoTime               // check system time
 *  2. system run                         // letting all Function to run
 *  3. endTime = nanoTime                 // check system time
 *  4. print endTime-startTime            // print Time diffrence
 *
 * -----------------------------------------------------------------------
 *
 * This is an output example of Ex0.
 *
 * Example ("toy"):
 * Enter a natural even number (n>4): 20
 * a) 20 = 3 + 17
 * b) 20 = 23 - 3
 * c) 8 prime numbers in [2,20)
 * d) 20 = 2*2*5
 * e) 0.019 seconds, the program runtime
 * f) 987654321 change to your ID, this is a class solution for Ex0 (Intro2CS 2025A)
 *
 * Large example:
 * Enter a natural even number (n>4): 60119912
 * a) 60119912 = 1093 + 60118819
 * b) 60119912 = 60119923 - 11
 * c) 3568738 prime numbers in [2,60119912)
 * d) 60119912 = 2*2*2*31*242419
 * e) 12.122 seconds, the program runtime
 * f) 987654321 change to your ID, this is a class solution for Ex0 (Intro2CS 2025A)
 * -----------------------------------------------------------------------
 * General Remark:
 * The Code is not the nicest - it is written as good Student solution (e.g., too long main) - and not as an expert solution.
 *
 */
public class Ex0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=3;
        long id = 987654321;    // This is a fake ID for the class solution
        final long K = 1000;
        long max = 100*K*K;     // Max number (10^8)
        long small_max = K*K;   // 10^6
        System.out.print("Enter a natural even number (n>4): ");
        long n = sc.nextLong(); // input of an integer (long) number
        if(n<=4 || n%2!=0 || n>=max) { // testing the input - should be natural even number > 4.
            System.err.println("Error: you should enter a natural even > 4, ans smaller than "+max+" yet, you have entered "+n+" quiting!");
            System.exit(-1); // quiting the program
        }
        // This code was part of the original (jar) solution
        //if(n>small_max) {
        //    System.err.println("Limited solution: class solution is not working for numbers larger than "+small_max+". Make sure your solution works for numbers up to "+max);
        //    System.exit(-2); // quiting the program
        //}

        long start = System.currentTimeMillis(); // starting the "timer" for computing the runtime
        ///////////// section a /////////////
        // computing two prime numbers p1, p2, such that p1+p2=n, p1 is minimal
        boolean found_a = false;
        long p1 = 3; // minimal value, p1 can NOT be 2.
        while (!found_a && p1 < n) {
            long p2 = n - p1;
            if(isPrime(p2) & isPrime(p1)) {
                found_a = true;
                System.out.println("a) "+n+" = "+p1+" + "+p2);
            }
            else {
                p1 = p1 + 2;
            }
        }
        ///////////// section b /////////////
        // computing two prime numbers p3, p4, such that p4-p3=n, p3 is minimal
        boolean found_b = false;
        long p3 = 3; // minimal value (p3 can NOT be 2).
        while (!found_b) {
            long p4 = p3 + n;
            if(isPrime(p4) & isPrime(p3)) {
                found_b = true;
                System.out.println("b) "+n+" = "+p4+" - "+p3);
            }
            else {
                p3 = p3 + 2;
            }
        }
        ///////////// section c /////////////
        // computes the number of primes in [2,n)
        long p = 3;
        long count = 1;
        while (p < n) {
            if(isPrime(p)) {count +=1;}
            p = p + 2;
        }
        System.out.println("c) "+count+" prime numbers in [2,"+n+")");
        ///////////// section d /////////////
        // computes the prime decomposition of n
        System.out.print("d) "+n+" = ");
        p = 2;
        long n1 = n;
        while (p<=n1) {
            if(isPrime(p) && n1%p==0) {
                if(n1<n) {System.out.print("*");}
                System.out.print(p);
                n1 /= p;
            }
            else {
                if(p==2) {p=3;}
                else {p = p + 2;}
            }
        }
        System.out.println();
        ///////////// sections e & f /////////////
        long end = System.currentTimeMillis();
        double dt_sec = (end - start) / 1000.0;
        System.out.println("e) "+dt_sec+" seconds, the program runtime");
        System.out.println("f) "+id+" change to your ID, this is a class solution for Ex0 (Intro2CS 2025A)");
    }

    static boolean isPrime(long n) {
        boolean ans = true;
        if(n==2) {ans = true;}
        else {if(n<2 || n%2==0) {ans = false;}}
        long p = 3;
        double rn = Math.sqrt(n);
        while (ans && p<=rn) {
            if(n%p==0) {ans = false;}
            p = p + 2;
        }
        return ans;
    }
}
