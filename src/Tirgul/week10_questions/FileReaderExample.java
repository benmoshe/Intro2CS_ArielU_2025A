package Tirgul.week10_questions;

import java.io.*;

public class FileReaderExample {

    // Function to create a file and write some content
    public static void createFile(String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("This is a sample file.\n");
            writer.write("This file contains some text content.\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file.");
        }
    }

    // Function to read the content of a file with exception handling
    public static String readFileWithExceptionHandling(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            return "Error: File not found!";
        } catch (IOException e) {
            return "Error: An IO exception occurred!";
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";

        // Create a file and write content to it
        createFile(filePath);

        // Read the file content
        String fileContent = readFileWithExceptionHandling(filePath);
        System.out.println(fileContent);
    }
}

