package Tirgul.week8_questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example);
        if (args.length > 0) {
            String filePath = args[0];
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Please provide a file path as an argument.");
        }
    }
    /**
     * Checks if a line of text is a permutation of a list of words.
     *
     * @param words The list of words.
     * @param line The line of text.
     * @return true if the line is a permutation of the words, false otherwise.
     */
    public static boolean isPer(ArrayList<String> words, String line) {
        for (String word : words) {
            if (!line.contains(word)) {
                return false;
            }
            line = line.replace(word, "");
        }

        for (int i = 0; i < words.size() - 1; i++) {
            line = line.replace(" ", "");
        }

        return line.isEmpty();
    }
}
