package com.schoolmanagement;

import java.util.ArrayList;
import java.util.List;

// ✅ School Management Class
class School {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public List<Student> getStudents() {
    return students;
    }

    public List<Teacher> getTeachers() {
    return teachers;
    }


    public void displayStudents() {
        System.out.println("\n📚 Student List:");
        for (Student student : students) {
            System.out.println("ID: " + student.id() + ", Name: " + student.name() + ", DOB: " + student.dob());
            System.out.println("Subjects and Marks:");
            student.marks().forEach((subject, mark) ->
                System.out.println("  " + subject + ": " + mark)
            );
        }
    }

    // ✅ Display Teachers
    public void displayTeachers() {
        System.out.println("\n👨‍🏫 Teacher List:");
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getName() + ", Subject: " + teacher.getSubject());
        }
    }
}
