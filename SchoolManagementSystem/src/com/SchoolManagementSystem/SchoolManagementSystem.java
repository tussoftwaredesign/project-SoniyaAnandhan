package com.SchoolManagementSystem;

public class SchoolManagementSystem {
    // Static array to hold all students and teachers information
    private static final Student[] students = new Student[2];
    private static final Teacher[] teachers = new Teacher[1];
    private static int studentIndex = 0;
    private static int teacherIndex = 0;

    // Static method to add a student
    public static void addStudent(Student student) {
        if (studentIndex < students.length) {
            students[studentIndex++] = student;
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Static method to add a teacher
    public static void addTeacher(Teacher teacher) {
        if (teacherIndex < teachers.length) {
            teachers[teacherIndex++] = teacher;
        } else {
            System.out.println("Teacher list is full.");
        }
    }

    // Main method to demonstrate the features
    public static void main(String[] args) {
        try { // I am using try and catch method to handle exceptions
            // Create students and teachers
            Student student1 = new Student("Alice", 101, 16);
            Student student2 = new Student("Bob", 102, 17);
            Teacher teacher1 = new Teacher("Mr. Smith", 201, Subject.MATHEMATICS);

            // Add students and teachers in the array
            addStudent(student1);
            addStudent(student2);
            addTeacher(teacher1);

            // Create Attendance for student1
            Attendence attendance1 = new Attendence(student1, 5);
            attendance1.markAttendence(0, true);
            attendance1.markAttendence(1,true);
            attendance1.markAttendence(2,false);
            attendance1.markAttendence(3,true);
            attendance1.markAttendence(4,false);
            attendance1.printAttendenceReport();

            // create attendance for student2
            Attendence attendance2 = new Attendence(student2, 5);
            attendance2.markAttendence(0, true);
            attendance2.markAttendence(1,true);
            attendance2.markAttendence(2,true);
            attendance2.markAttendence(3,true);
            attendance2.markAttendence(4,true);
            attendance2.printAttendenceReport();


            // Show teacher's name, and the subject
            System.out.println("Teacher: " + teacher1.getName());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}


