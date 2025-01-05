/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 6.
 */
package Tirgul.week6_questions;

public class Student {
    private String address;
    private int MolecularBiologyGrade;
    private String name;
    private static int numOfStudents = 0;

    /**
     * Constructs a new Tirgul.Student.
     *
     * @param address The address of the student.
     * @param MolecularBiologyGrade The grade of the student in Molecular Biology.
     * @param name The name of the student.
     */
    public Student(String address, int MolecularBiologyGrade, String name) {
        this.address = address;
        this.MolecularBiologyGrade = MolecularBiologyGrade;
        this.name = name;
        numOfStudents++;
    }

    /**
     * Displays the information of the student.
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Molecular Biology Grade: " + MolecularBiologyGrade);
    }

    /**
     * @return The number of Tirgul.Student objects that have been created.
     */
    public static int getNumOfStudents() {
        return numOfStudents;
    }

    /**
     * Sets the student's grade in Molecular Biology.
     *
     * @param grade The new grade.
     */
    public void setMolecularBiologyGrade(int grade) {
        this.MolecularBiologyGrade = grade;
    }

    /**
     * @return The student's grade in Molecular Biology.
     * this function used in the test class, not required in the question
     */
    public int getMolecularBiologyGrade() {
        return this.MolecularBiologyGrade;
    }
    public String getName(){return name;}
}