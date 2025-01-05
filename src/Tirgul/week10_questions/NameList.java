package Tirgul.week10_questions;

import java.util.*;

public class NameList {

    // Function to count names starting with a specific letter
    public static int countNamesStartingWith(LinkedList<String> names, char letter) {
        int count = 0;
        for (String name : names) {
            if (name.charAt(0) == letter) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> names = new LinkedList<>();

        // Get names from user input
        System.out.println("Enter names (type 'done' to finish):");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            names.add(name);
        }

        // Ask user for the starting letter to search for
        System.out.print("Enter the starting letter to count: ");
        char letter = scanner.nextLine().charAt(0);

        // Count and display the number of names starting with the specified letter
        int count = countNamesStartingWith(names, letter);
        System.out.println("Number of names starting with '" + letter + "': " + count);
    }
}

