/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 6.
 */
package Tirgul.week6_questions;

public class Class {
    private Student student;

    /**
     * Constructs a new Class with a single student.
     *
     * @param student The student in the class.
     */
    public Class(Student student) {
        this.student = student;
    }

    /**
     * Changes the grade of the student in the class.
     *
     * @param grade The new grade.
     */
    public void changeStudentGrade(int grade) {
        this.student.setMolecularBiologyGrade(grade);
    }

    public static void main(String[] args) {
        System.out.println("Number of students: " + Student.getNumOfStudents());
        Student student1 = new Student("Address 1", 85, "Tirgul.Student 1");
        Student student2 = new Student("Address 2", 90, "Tirgul.Student 2");
        student1.displayInfo();
        student2.displayInfo();
        Class class1 = new Class(student2);
        class1.changeStudentGrade(100);
        student2.displayInfo();
        System.out.println("Number of students: " + Student.getNumOfStudents());
    }
}
