package com.schoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.Printable;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class SchoolManagementApp {

    private static Map<String, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private static Map<String, Subject> teacherSubjects = new HashMap<>();

    public static void main(String[] args) {
        loadStudentDataFromFile();
        initializeDefaultData();
        SwingUtilities.invokeLater(SchoolManagementApp::createLoginUI);
    }

    private static void initializeDefaultData() {
        Map<Subject, Integer> aliceMarks = new HashMap<>();
        aliceMarks.put(Subject.MATH, 85);
        aliceMarks.put(Subject.SCIENCE, 90);
        aliceMarks.put(Subject.ENGLISH, 88);
        studentMarks.put("Alice", aliceMarks);

        Map<Subject, Integer> bobMarks = new HashMap<>();
        bobMarks.put(Subject.MATH, 75);
        bobMarks.put(Subject.SCIENCE, 80);
        bobMarks.put(Subject.ENGLISH, 78);
        studentMarks.put("Bob", bobMarks);

        teacherSubjects.put("Mr. Smith", Subject.MATH);
        teacherSubjects.put("Dr. Brown", Subject.SCIENCE);
    }

    private static void createLoginUI() {
        JFrame frame = new JFrame("\uD83C\uDFEB School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setPreferredSize(new Dimension(400, 500));
        try {
            ImageIcon schoolIcon = new ImageIcon("C:\\Users\\35389\\IdeaProjects\\OOPS 2 Project\\src\\com\\schoolmanagement\\school.jpg");
            Image scaledImage = schoolIcon.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imagePanel.add(imageLabel);
        } catch (Exception e) {
            imagePanel.add(new JLabel("\uD83D\uDCF8 Image not found!"));
        }

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(30, 144, 255));
        loginPanel.setPreferredSize(new Dimension(400, 500));
        loginPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Admin Login");
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(130, 50, 200, 30);
        loginPanel.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.white);
        userLabel.setBounds(70, 120, 100, 25);
        JTextField userField = new JTextField();
        userField.setBounds(160, 120, 150, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(70, 160, 100, 25);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(160, 160, 150, 25);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 210, 100, 30);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(30, 144, 255));

        loginButton.addActionListener((ActionEvent e) -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                frame.dispose();
                launchDashboard();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);

        frame.add(imagePanel, BorderLayout.WEST);
        frame.add(loginPanel, BorderLayout.EAST);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void launchDashboard() {
        JFrame dashboardFrame = new JFrame("School Management Dashboard");
        dashboardFrame.setSize(800, 500);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setLayout(new BorderLayout());

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton studentListButton = new JButton("\uD83D\uDCDA Student List");
        studentListButton.addActionListener(e -> showStudentList());
        JButton teacherListButton = new JButton("\uD83D\uDC68‍\uD83C\uDFEB Teacher List");
        teacherListButton.addActionListener(e -> showTeacherList());
        JButton attendanceButton = new JButton("\u2705 Attendance Record");
        attendanceButton.addActionListener(e -> showAttendanceRecord());

        dashboardPanel.add(studentListButton);
        dashboardPanel.add(teacherListButton);
        dashboardPanel.add(attendanceButton);

        dashboardFrame.add(dashboardPanel, BorderLayout.CENTER);

        JPanel studentActionPanel = new JPanel();
        JButton addButton = new JButton("Add Student");
        JButton editButton = new JButton("Edit Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton printButton = new JButton("Print Report");

        addButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name:");
            if (studentName != null) {
                Map<Subject, Integer> marks = getStudentMarks();
                addStudent(studentName, marks);
            }
        });

        editButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to edit:");
            if (studentName != null) {
                Map<Subject, Integer> marks = getStudentMarks();
                editStudent(studentName, marks);
            }
        });

        deleteButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to delete:");
            deleteStudent(studentName);
        });

        printButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to print report:");
            generateStudentReportCard(studentName);
        });

        studentActionPanel.add(addButton);
        studentActionPanel.add(editButton);
        studentActionPanel.add(deleteButton);
        studentActionPanel.add(printButton);

        dashboardFrame.add(studentActionPanel, BorderLayout.SOUTH);
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setVisible(true);
    }

   // Method to show Student List with Option to Add Marks and Print/Download CSV
    private static void showStudentList() {
    JFrame studentFrame = new JFrame("Student List");
    studentFrame.setSize(800, 500);
    JTextArea studentArea = new JTextArea();

    // Displaying the student marks (default data)
    updateStudentListDisplay(studentArea);

    // Add options to input marks for students
    JPanel marksPanel = new JPanel();
    JTextField studentNameField = new JTextField(10);
    JTextField marksField = new JTextField(10);
    JComboBox<Subject> subjectComboBox = new JComboBox<>(Subject.values());
    JButton addMarksButton = new JButton("Add Marks");

    addMarksButton.addActionListener(e -> {
        String studentName = studentNameField.getText();
        String marksText = marksField.getText();
        Subject subject = (Subject) subjectComboBox.getSelectedItem();
        if (!studentName.isEmpty() && !marksText.isEmpty() && subject != null) {
            try {
                int marks = Integer.parseInt(marksText);

                // Update existing marks for the student or add new marks if student doesn't exist
                studentMarks.computeIfAbsent(studentName, k -> new HashMap<>()).put(subject, marks);

                // After updating the marks, refresh the JTextArea to show updated list
                updateStudentListDisplay(studentArea);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(studentFrame, "Invalid Marks!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Add print and CSV export options
    JPanel optionsPanel = new JPanel();
    JButton printButton = new JButton("Print List");
    JButton exportCsvButton = new JButton("Download as CSV");

    printButton.addActionListener(e -> printStudentList(studentArea.getText()));
    exportCsvButton.addActionListener(e -> exportToCSV());

    optionsPanel.add(printButton);
    optionsPanel.add(exportCsvButton);

    marksPanel.add(new JLabel("Student Name:"));
    marksPanel.add(studentNameField);
    marksPanel.add(new JLabel("Marks:"));
    marksPanel.add(marksField);
    marksPanel.add(new JLabel("Subject:"));
    marksPanel.add(subjectComboBox);
    marksPanel.add(addMarksButton);

    studentFrame.add(new JScrollPane(studentArea), BorderLayout.CENTER);
    studentFrame.add(marksPanel, BorderLayout.SOUTH);
    studentFrame.add(optionsPanel, BorderLayout.NORTH);
    studentFrame.setVisible(true);
    }

    private static void updateStudentListDisplay(JTextArea studentArea) {
        // Display the updated student marks in the JTextArea
        StringBuilder studentList = new StringBuilder();
        for (Map.Entry<String, Map<Subject, Integer>> entry : studentMarks.entrySet()) {
            String studentName = entry.getKey();
            Map<Subject, Integer> marks = entry.getValue();
            studentList.append(studentName).append(": \n");
            for (Map.Entry<Subject, Integer> markEntry : marks.entrySet()) {
                studentList.append("  ").append(markEntry.getKey()).append(": ").append(markEntry.getValue()).append("\n");
            }
            studentList.append("\n");
        }
        studentArea.setText(studentList.toString());  // Set the updated student list in the JTextArea
    }

    private static void addStudent(String studentName, Map<Subject, Integer> marks) {
    // Check if student already exists
    if (studentMarks.containsKey(studentName)) {
        JOptionPane.showMessageDialog(null, "Student already exists!", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        studentMarks.put(studentName, marks);
        JOptionPane.showMessageDialog(null, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    }

    private static void editStudent(String studentName, Map<Subject, Integer> newMarks) {
        // Check if student exists
        if (studentMarks.containsKey(studentName)) {
            studentMarks.put(studentName, newMarks);
            JOptionPane.showMessageDialog(null, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void deleteStudent(String studentName) {
        // Check if student exists
        if (studentMarks.containsKey(studentName)) {
            studentMarks.remove(studentName);
            JOptionPane.showMessageDialog(null, "Student deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Method to print the student list
    private static void printStudentList(String studentList) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            graphics.drawString(studentList, 100, 100);
            return Printable.PAGE_EXISTS;
        });

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "Error while printing!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // Method to export student list to a CSV file
    private static void exportToCSV() {
        // Open a file chooser dialog to let the user choose where to save the file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as CSV");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV Files", "csv"));
        fileChooser.setSelectedFile(new File("students.csv"));  // Default file name

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

            // Write the student data to the selected file
            try (FileWriter writer = new FileWriter(fileToSave)) {
                // Write CSV header
                writer.append("Student Name,Subject,Marks\n");

                // Write each student's marks
                for (Map.Entry<String, Map<Subject, Integer>> entry : studentMarks.entrySet()) {
                    String studentName = entry.getKey();
                    Map<Subject, Integer> marks = entry.getValue();
                    for (Map.Entry<Subject, Integer> markEntry : marks.entrySet()) {
                        writer.append(studentName).append(",")
                                .append(markEntry.getKey().toString()).append(",")
                                .append(String.valueOf(markEntry.getValue())).append("\n");
                    }
                }

                // Show confirmation message with the file path
                JOptionPane.showMessageDialog(null, "File saved successfully: " + fileToSave.getAbsolutePath(),
                        "Export Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage(),
                        "Export Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Export cancelled", "Export Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to show Teacher List with Option to Assign Subjects
    private static void showTeacherList() {
        JFrame teacherFrame = new JFrame("Teacher List");
        teacherFrame.setSize(800, 500);
        JTextArea teacherArea = new JTextArea();

        // Display the teacher subjects (default data)
        StringBuilder teacherList = new StringBuilder();
        for (Map.Entry<String, Subject> entry : teacherSubjects.entrySet()) {
            teacherList.append(entry.getKey()).append(" teaches ").append(entry.getValue().getSubjectDetails()).append("\n");
        }
        teacherArea.setText(teacherList.toString());

        // Add option to assign subjects to teachers
        JPanel subjectPanel = new JPanel();
        JTextField teacherNameField = new JTextField(10);
        JComboBox<Subject> subjectComboBox = new JComboBox<>(Subject.values());
        JButton assignSubjectButton = new JButton("Assign Subject");

        assignSubjectButton.addActionListener(e -> {
            String teacherName = teacherNameField.getText();
            Subject subject = (Subject) subjectComboBox.getSelectedItem();
            if (!teacherName.isEmpty() && subject != null) {
                teacherSubjects.put(teacherName, subject);
                teacherArea.append("\nAssigned " + subject + " to " + teacherName);
            }
        });

        subjectPanel.add(new JLabel("Teacher Name:"));
        subjectPanel.add(teacherNameField);
        subjectPanel.add(new JLabel("Subject:"));
        subjectPanel.add(subjectComboBox);
        subjectPanel.add(assignSubjectButton);

        teacherFrame.add(new JScrollPane(teacherArea), BorderLayout.CENTER);
        teacherFrame.add(subjectPanel, BorderLayout.SOUTH);
        teacherFrame.setVisible(true);
    }

    // Method to show Attendance Record (Placeholder for now)
    private static void showAttendanceRecord() {
        JFrame attendanceFrame = new JFrame("Attendance Record");
        attendanceFrame.setSize(800, 500);
        JTextArea attendanceArea = new JTextArea();
        attendanceArea.setText("Student 1: Present\nStudent 2: Absent");  // Add your attendance data here
        attendanceFrame.add(new JScrollPane(attendanceArea));
        attendanceFrame.setVisible(true);
    }

    private static void generateStudentReportCard(String studentName) {
        if (studentMarks.containsKey(studentName)) {
            Map<Subject, Integer> marks = studentMarks.get(studentName);
            int totalMarks = 0;
            StringBuilder reportCard = new StringBuilder();
            reportCard.append("Student: ").append(studentName).append("\n");
            reportCard.append("Subject-wise Marks:\n");

            for (Map.Entry<Subject, Integer> entry : marks.entrySet()) {
                reportCard.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                totalMarks += entry.getValue();
            }

            double averageMarks = totalMarks / (double) marks.size();
            reportCard.append("\nTotal Marks: ").append(totalMarks).append("\n");
            reportCard.append("Average Marks: ").append(String.format("%.2f", averageMarks)).append("\n");

            JOptionPane.showMessageDialog(null, reportCard.toString(), "Report Card", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void showStudentTable() {
    // Create a frame for the JTable
    JFrame tableFrame = new JFrame("Student Data");

    // Column names for the table
    String[] columnNames = {"Student Name", "Subject", "Marks"};

    // Prepare data for JTable
    Object[][] data = new Object[studentMarks.size()][3];
    int row = 0;

    // Iterate over the studentMarks map to populate the table data
    for (Map.Entry<String, Map<Subject, Integer>> entry : studentMarks.entrySet()) {
        String studentName = entry.getKey();
        Map<Subject, Integer> marks = entry.getValue();

        for (Map.Entry<Subject, Integer> markEntry : marks.entrySet()) {
            data[row][0] = studentName;
            data[row][1] = markEntry.getKey();
            data[row][2] = markEntry.getValue();
            row++;
        }
    }

    // Create the JTable with the data and column names
    JTable table = new JTable(data, columnNames);

    // Put the JTable inside a JScrollPane for scrolling
    JScrollPane scrollPane = new JScrollPane(table);

    // Add the scroll pane (with the table inside) to the frame
    tableFrame.add(scrollPane);

    // Set frame properties
    tableFrame.setSize(800, 500);  // Set size of the window
    tableFrame.setLocationRelativeTo(null);  // Center the window
    tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close on disposal
    tableFrame.setVisible(true);  // Show the frame
}

    // Example frame setup with buttons for actions
    private static void setupStudentActions(JFrame frame) {
        // Create buttons for Add, Edit, Delete, and Print
        JButton addButton = new JButton("Add Student");
        JButton editButton = new JButton("Edit Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton printButton = new JButton("Print Report");

        // Add ActionListener for Add Student
        addButton.addActionListener(e -> {
            // Get student name and marks (this can be a dialog or a form)
            String studentName = JOptionPane.showInputDialog("Enter student name:");
            Map<Subject, Integer> marks = getStudentMarks();  // Assume this is a method that gets marks

            addStudent(studentName, marks);  // Call the addStudent method
        });

        // Add ActionListener for Edit Student
        editButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to edit:");
            Map<Subject, Integer> newMarks = getStudentMarks();  // Assume this is a method that gets new marks

            editStudent(studentName, newMarks);  // Call the editStudent method
        });

        // Add ActionListener for Delete Student
        deleteButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to delete:");
            deleteStudent(studentName);  // Call the deleteStudent method
        });

        // Add ActionListener for Print Report
        printButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog("Enter student name to print report:");
            generateStudentReportCard(studentName);  // Call the generateStudentReportCard method
        });

        // Layout buttons in the frame
        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(printButton);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.SOUTH);
    }

        private static Map<Subject, Integer> getStudentMarks() {
        Map<Subject, Integer> marks = new HashMap<>();

        // Simple example, assume input for marks is given via a dialog
        marks.put(Subject.MATH, Integer.parseInt(JOptionPane.showInputDialog("Enter Math marks:")));
        marks.put(Subject.SCIENCE, Integer.parseInt(JOptionPane.showInputDialog("Enter Science marks:")));
        marks.put(Subject.ENGLISH, Integer.parseInt(JOptionPane.showInputDialog("Enter English marks:")));

        return marks;
    }

    private static void loadStudentDataFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentData.ser"))) {
            studentMarks = (Map<String, Map<Subject, Integer>>) in.readObject();
            System.out.println("Student data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found. Starting fresh...");
        }
    }

    private static void saveStudentDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentData.ser"))) {
            out.writeObject(studentMarks);  // Serialize and save the data to a file
            System.out.println("Student data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving student data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
