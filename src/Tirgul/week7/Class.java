/**
 * Author: Avi Rahimov. week 7 update - Doron
 * This class contains solutions to various exercises from week 6. extention on week 7.
 */
package Tirgul.week7;

import Tirgul.week6_questions.Student;

public class Class {
    private Student[] learning = new Student[3];

    /**
     * Constructs a new Class with three students.
     *
     * @param student1,student2,student3 The students in the class.
     */
    public Class(Student student1, Student student2, Student student3) {
        // shallow copy
        learning[0] = student1;
        learning[1] = student2;
        learning[2] = student3;
    } //notice we didn't create copy of the students. This is only a pointer to the original student.

    /**
     * Changes the grade of the student in the class.
     *
     * @param grade The new grade.
     * @param name The name of student
     */
    public void changeStudentGrade(int grade, String name) {
        for (int i=0; i<learning.length; i++)
            if (learning[i].getName().equals(name))
                learning[i].setMolecularBiologyGrade(grade);
    }

    public static void main(String[] args) {
        System.out.println("Number of students: " + Student.getNumOfStudents());
        Student student1 = new Student("Address 1", 85, "Tirgul.Student 1");
        Student student2 = new Student("Address 2", 90, "Tirgul.Student 2");
        Student student3 = new Student("Address 3", 74, "Tirgul.Student 3");
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        Class class1 = new Class(student1, student2, student3);
        class1.changeStudentGrade(100,"Tirgul.Student 2");
        student2.displayInfo();
        System.out.println("Number of students: " + Student.getNumOfStudents());
    }
}
