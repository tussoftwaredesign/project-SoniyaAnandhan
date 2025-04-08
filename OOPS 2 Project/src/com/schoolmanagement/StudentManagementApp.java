package com.schoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentManagementApp {

    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static JTextArea studentArea;
    private static JTextArea teacherArea;

    public static void main(String[] args) {
        // Create the main frame for the Swing UI
        JFrame frame = new JFrame("School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Set up panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // --- Student Input Section ---
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(4, 2));
        studentPanel.add(new JLabel("Student Name:"));
        JTextField studentNameField = new JTextField();
        studentPanel.add(studentNameField);
        studentPanel.add(new JLabel("Student ID:"));
        JTextField studentIdField = new JTextField();
        studentPanel.add(studentIdField);
        studentPanel.add(new JLabel("Student DOB (YYYY-MM-DD):"));
        JTextField studentDobField = new JTextField();
        studentPanel.add(studentDobField);

        JButton addStudentButton = new JButton("Add Student");
        studentPanel.add(addStudentButton);
        panel.add(studentPanel);

        // --- Teacher Input Section ---
        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new GridLayout(3, 2));
        teacherPanel.add(new JLabel("Teacher Name:"));
        JTextField teacherNameField = new JTextField();
        teacherPanel.add(teacherNameField);
        teacherPanel.add(new JLabel("Teacher Subject:"));
        JTextField teacherSubjectField = new JTextField();
        teacherPanel.add(teacherSubjectField);

        JButton addTeacherButton = new JButton("Add Teacher");
        teacherPanel.add(addTeacherButton);
        panel.add(teacherPanel);

        // --- Display Areas ---
        studentArea = new JTextArea(10, 50);
        studentArea.setEditable(false);
        JScrollPane studentScrollPane = new JScrollPane(studentArea);
        panel.add(new JLabel("Students:"));
        panel.add(studentScrollPane);

        teacherArea = new JTextArea(10, 50);
        teacherArea.setEditable(false);
        JScrollPane teacherScrollPane = new JScrollPane(teacherArea);
        panel.add(new JLabel("Teachers:"));
        panel.add(teacherScrollPane);

        // --- Add Student Action ---
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = studentNameField.getText().trim();
                    int id = Integer.parseInt(studentIdField.getText().trim());
                    LocalDate dob = LocalDate.parse(studentDobField.getText().trim());
                    Map<Subject, Integer> marks = Map.of(
                            Subject.MATH, 0, Subject.SCIENCE, 0, Subject.ENGLISH, 0,
                            Subject.HISTORY, 0, Subject.PHYSICS, 0, Subject.CHEMISTRY, 0, Subject.COMPUTER_SCIENCE, 0
                    );
                    Student newStudent = new Student(name, id, dob, List.of(Subject.values()), marks);
                    students.add(newStudent);
                    updateStudentDisplay();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid data.");
                }
            }
        });

        // --- Add Teacher Action ---
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = teacherNameField.getText().trim();
                    String subjectName = teacherSubjectField.getText().trim().toUpperCase();
                    Subject subject = Subject.valueOf(subjectName); // Ensure it's a valid subject

                    Teacher newTeacher = new GenericTeacher<>(name, subject);
                    teachers.add(newTeacher);
                    updateTeacherDisplay();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid subject.");
                }
            }
        });

        // --- Fill In Sample Data ---
        fillStudentData();
        fillTeacherData();

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Update the student display area
    private static void updateStudentDisplay() {
        studentArea.setText("");  // Clear previous display
        for (Student student : students) {
            studentArea.append("ID: " + student.id() + ", Name: " + student.name() + ", DOB: " + student.dob() + "\n");
            student.marks().forEach((subject, mark) -> studentArea.append("  " + subject + ": " + mark + "\n"));
        }
    }

    // Update the teacher display area
    private static void updateTeacherDisplay() {
        teacherArea.setText("");  // Clear previous display
        for (Teacher teacher : teachers) {
            teacherArea.append(teacher.getName() + " teaches " + teacher.getSubject() + "\n");
        }
    }

    // Sample data to show when the app starts
    private static void fillStudentData() {
        students.add(new Student("Alice", 1, LocalDate.of(2005, 3, 15), List.of(Subject.values()), Map.of(
                Subject.MATH, 85, Subject.SCIENCE, 90, Subject.ENGLISH, 88,
                Subject.HISTORY, 78, Subject.PHYSICS, 92, Subject.CHEMISTRY, 80, Subject.COMPUTER_SCIENCE, 95
        )));
        students.add(new Student("Bob", 2, LocalDate.of(2006, 7, 22), List.of(Subject.values()), Map.of(
                Subject.MATH, 75, Subject.SCIENCE, 85, Subject.ENGLISH, 80,
                Subject.HISTORY, 70, Subject.PHYSICS, 88, Subject.CHEMISTRY, 76, Subject.COMPUTER_SCIENCE, 89
        )));
        updateStudentDisplay();
    }

    // Sample data to show when the app starts
    private static void fillTeacherData() {
        teachers.add(new GenericTeacher<>("Mr. Smith", Subject.MATH));
        teachers.add(new GenericTeacher<>("Dr. Brown", Subject.SCIENCE));
        teachers.add(new GenericTeacher<>("Ms. Green", Subject.ENGLISH));
        teachers.add(new GenericTeacher<>("Prof. White", Subject.COMPUTER_SCIENCE));
        updateTeacherDisplay();
    }
}
