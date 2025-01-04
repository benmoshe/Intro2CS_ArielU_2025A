package Tirgul.week6_questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Student_Test {
    @Test
    public void testStudent() {
        Student student1 = new Student("Address 1", 85, "Tirgul.Student 1");
        Student student2 = new Student("Address 2", 90, "Tirgul.Student 2");
        assertEquals(2, Student.getNumOfStudents());
        Class class1 = new Class(student2);
        class1.changeStudentGrade(100);
        assertEquals(100, student2.getMolecularBiologyGrade());
    }
}

