package com.schoolmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.Printable;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class SchoolManagementApp {

    private static Map<String, Map<Subject, Integer>> studentMarks = new HashMap<>();
    private static Map<String, Subject> teacherSubjects = new HashMap<>();
    private static Map<String, Map<String, Boolean>> studentAttendance = new HashMap<>();
    private static Locale currentLocale = Locale.US;
    private static ResourceBundle messages;

    static {
        try {
            System.out.println("Classpath: " + System.getProperty("java.class.path"));
            messages = ResourceBundle.getBundle("com.schoolmanagement.resources.Messages", currentLocale);
            System.out.println("ResourceBundle loaded: " + messages.getString("title.schoolManagementSystem"));
        } catch (Exception e) {
            System.err.println("Failed to load ResourceBundle: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting application...");
        System.out.println("Locale: " + currentLocale);
        try {
            loadStudentDataFromFile();
            initializeDefaultData();
            SwingUtilities.invokeLater(() -> {
                try {
                    createLoginUI();
                } catch (Exception e) {
                    System.err.println("Error in createLoginUI: " + e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            });
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    saveStudentDataToFile();
                } catch (Exception e) {
                    System.err.println("Error saving data on shutdown: " + e.getMessage());
                    e.printStackTrace();
                }
            }));
        } catch (Exception e) {
            System.err.println("Error in main: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void initializeDefaultData() {
        Map<Subject, Integer> soniyaMarks = new HashMap<>();
        soniyaMarks.put(Subject.MATH, 85);
        soniyaMarks.put(Subject.SCIENCE, 90);
        soniyaMarks.put(Subject.ENGLISH, 88);
        soniyaMarks.put(Subject.CHEMISTRY, 95);
        soniyaMarks.put(Subject.COMPUTER_SCIENCE, 100);
        soniyaMarks.put(Subject.HISTORY, 50);
        soniyaMarks.put(Subject.PHYSICS, 98);
        studentMarks.put("Soniya", soniyaMarks);

        Map<Subject, Integer> anandMarks = new HashMap<>();
        anandMarks.put(Subject.MATH, 75);
        anandMarks.put(Subject.SCIENCE, 80);
        anandMarks.put(Subject.ENGLISH, 78);
        anandMarks.put(Subject.HISTORY, 90);
        anandMarks.put(Subject.PHYSICS, 56);
        anandMarks.put(Subject.CHEMISTRY, 60);
        anandMarks.put(Subject.COMPUTER_SCIENCE, 99);
        studentMarks.put("Anandhan", anandMarks);

        teacherSubjects.put("Mr. Thulir", Subject.MATH);
        teacherSubjects.put("Dr. Sam", Subject.SCIENCE);
        teacherSubjects.put("Mrs. Jeshmitha", Subject.CHEMISTRY);
        teacherSubjects.put("Ms. Sagunthala", Subject.COMPUTER_SCIENCE);
        teacherSubjects.put("Mr. Prasad", Subject.ENGLISH);
        teacherSubjects.put("Dr. Mathiyan", Subject.PHYSICS);

        Map<String, Boolean> anandAttendance = new HashMap<>();
        anandAttendance.put("2025-04-01", true);
        anandAttendance.put("2025-04-02", false);
        studentAttendance.put("Anandhan", anandAttendance);

        Map<String, Boolean> soniyaAttendance = new HashMap<>();
        soniyaAttendance.put("2025-04-01", true);
        soniyaAttendance.put("2025-04-02", true);
        studentAttendance.put("Soniya", soniyaAttendance);
    }

    private static void createLoginUI() {
        JFrame frame = new JFrame("\uD83C\uDFEB " + messages.getString("title.schoolManagementSystem"));
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
            imagePanel.add(new JLabel("\uD83D\uDCF8 " + messages.getString("message.imageNotFound")));
            System.err.println("Image loading failed: " + e.getMessage());
        }

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(30, 144, 255));
        loginPanel.setPreferredSize(new Dimension(400, 500));
        loginPanel.setLayout(null);

        JLabel titleLabel = new JLabel(messages.getString("label.adminLogin"));
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(130, 50, 200, 30);

        JLabel userLabel = new JLabel(messages.getString("label.username"));
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(70, 120, 100, 25);
        JTextField userField = new JTextField();
        userField.setBounds(160, 120, 150, 25);

        JLabel passLabel = new JLabel(messages.getString("label.password"));
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(70, 160, 100, 25);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(160, 160, 150, 25);

        JButton loginButton = new JButton(messages.getString("button.login"));
        loginButton.setBounds(140, 210, 100, 30);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(30, 144, 255));

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                frame.dispose();
                launchDashboard();
            } else {
                JOptionPane.showMessageDialog(frame, messages.getString("message.invalidCredentials"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        String[] languages = {"English", "Spanish"};
        JComboBox<String> languageComboBox = new JComboBox<>(languages);
        languageComboBox.setBounds(140, 260, 100, 30);
        languageComboBox.addActionListener(e -> {
            String selectedLang = (String) languageComboBox.getSelectedItem();
            switchLanguage(selectedLang);
            frame.dispose();
            createLoginUI();
        });

        loginPanel.add(titleLabel);
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);
        loginPanel.add(languageComboBox);

        frame.add(imagePanel, BorderLayout.WEST);
        frame.add(loginPanel, BorderLayout.EAST);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void switchLanguage(String language) {
        switch (language) {
            case "English":
                currentLocale = Locale.US;
                break;
            case "Spanish":
                currentLocale = new Locale("es", "ES");
                break;
        }
        try {
            messages = ResourceBundle.getBundle("com.schoolmanagement.resources.Messages", currentLocale);
            System.out.println("Switched to locale: " + currentLocale);
        } catch (Exception e) {
            System.err.println("Error switching language: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void launchDashboard() {
        JFrame dashboardFrame = new JFrame(messages.getString("title.schoolManagementSystem"));
        dashboardFrame.setSize(800, 500);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setLayout(new BorderLayout());

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton studentListButton = new JButton(messages.getString("button.studentList"));
        studentListButton.addActionListener(e -> showStudentList());
        JButton teacherListButton = new JButton(messages.getString("button.teacherList"));
        teacherListButton.addActionListener(e -> showTeacherList());
        JButton attendanceButton = new JButton(messages.getString("button.attendanceRecord"));
        attendanceButton.addActionListener(e -> showAttendanceRecord());

        dashboardPanel.add(studentListButton);
        dashboardPanel.add(teacherListButton);
        dashboardPanel.add(attendanceButton);

        JPanel studentActionPanel = new JPanel();
        JButton addButton = new JButton(messages.getString("button.addStudent"));
        JButton editButton = new JButton(messages.getString("button.editStudent"));
        JButton deleteButton = new JButton(messages.getString("button.deleteStudent"));
        JButton printButton = new JButton(messages.getString("button.printReport"));

        addButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog(messages.getString("prompt.enterStudentName"));
            if (studentName != null) {
                Map<Subject, Integer> marks = getStudentMarks();
                addStudent(studentName, marks);
            }
        });

        editButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog(messages.getString("prompt.enterStudentNameEdit"));
            if (studentName != null) {
                Map<Subject, Integer> marks = getStudentMarks();
                editStudent(studentName, marks);
            }
        });

        deleteButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog(messages.getString("prompt.enterStudentNameDelete"));
            deleteStudent(studentName);
        });

        printButton.addActionListener(e -> {
            String studentName = JOptionPane.showInputDialog(messages.getString("prompt.enterStudentNamePrint"));
            generateStudentReportCard(studentName);
        });

        studentActionPanel.add(addButton);
        studentActionPanel.add(editButton);
        studentActionPanel.add(deleteButton);
        studentActionPanel.add(printButton);

        dashboardFrame.add(dashboardPanel, BorderLayout.CENTER);
        dashboardFrame.add(studentActionPanel, BorderLayout.SOUTH);
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setVisible(true);
    }

    private static void showStudentList() {
        JFrame studentFrame = new JFrame(messages.getString("title.studentList"));
        studentFrame.setSize(800, 500);
        JTextArea studentArea = new JTextArea();
        updateStudentListDisplay(studentArea);

        JPanel marksPanel = new JPanel();
        JTextField studentNameField = new JTextField(10);
        JTextField marksField = new JTextField(10);
        JComboBox<Subject> subjectComboBox = new JComboBox<>(Subject.values());
        JButton addMarksButton = new JButton(messages.getString("button.addMarks"));

        addMarksButton.addActionListener(e -> {
            String studentName = studentNameField.getText();
            String marksText = marksField.getText();
            Subject subject = (Subject) subjectComboBox.getSelectedItem();
            if (!studentName.isEmpty() && !marksText.isEmpty() && subject != null) {
                try {
                    int marks = Integer.parseInt(marksText);
                    studentMarks.computeIfAbsent(studentName, k -> new HashMap<>()).put(subject, marks);
                    updateStudentListDisplay(studentArea);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(studentFrame, messages.getString("message.invalidMarks"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel optionsPanel = new JPanel();
        JButton printButton = new JButton(messages.getString("button.printList"));
        JButton exportCsvButton = new JButton(messages.getString("button.exportCsv"));

        printButton.addActionListener(e -> printStudentList(studentArea.getText()));
        exportCsvButton.addActionListener(e -> exportToCSV());

        marksPanel.add(new JLabel(messages.getString("label.studentName")));
        marksPanel.add(studentNameField);
        marksPanel.add(new JLabel(messages.getString("label.marks")));
        marksPanel.add(marksField);
        marksPanel.add(new JLabel(messages.getString("label.subject")));
        marksPanel.add(subjectComboBox);
        marksPanel.add(addMarksButton);

        studentFrame.add(new JScrollPane(studentArea), BorderLayout.CENTER);
        studentFrame.add(marksPanel, BorderLayout.SOUTH);
        studentFrame.add(optionsPanel, BorderLayout.NORTH);
        studentFrame.setVisible(true);
    }

    // Stream Implementation: Display student list
    private static void updateStudentListDisplay(JTextArea studentArea) {
        String studentList = studentMarks.entrySet().stream()
                .map(entry -> {
                    String studentName = entry.getKey();
                    Map<Subject, Integer> marks = entry.getValue();
                    String marksText = marks.entrySet().stream()
                            .map(markEntry -> "  " + markEntry.getKey() + ": " + markEntry.getValue())
                            .collect(Collectors.joining("\n"));
                    return studentName + ": \n" + marksText;
                })
                .collect(Collectors.joining("\n\n"));
        studentArea.setText(studentList);
    }

    private static void addStudent(String studentName, Map<Subject, Integer> marks) {
        if (studentMarks.containsKey(studentName)) {
            JOptionPane.showMessageDialog(null, messages.getString("message.studentExists"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
        } else {
            studentMarks.put(studentName, marks);
            JOptionPane.showMessageDialog(null, messages.getString("message.studentAdded"), messages.getString("title.success"), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void editStudent(String studentName, Map<Subject, Integer> newMarks) {
        if (studentMarks.containsKey(studentName)) {
            studentMarks.put(studentName, newMarks);
            JOptionPane.showMessageDialog(null, messages.getString("message.studentUpdated"), messages.getString("title.success"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, messages.getString("message.studentNotFound"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void deleteStudent(String studentName) {
        if (studentMarks.containsKey(studentName)) {
            studentMarks.remove(studentName);
            studentAttendance.remove(studentName);
            JOptionPane.showMessageDialog(null, messages.getString("message.studentDeleted"), messages.getString("title.success"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, messages.getString("message.studentNotFound"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void printStudentList(String studentList) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
            graphics.drawString(studentList, 100, 100);
            return Printable.PAGE_EXISTS;
        });

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, messages.getString("message.printError"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Stream Implementation: Export to CSV
    private static void exportToCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(messages.getString("title.saveAsCsv"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV Files", "csv"));
        fileChooser.setSelectedFile(new File("students.csv"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave)) {
                writer.append(messages.getString("csv.header.studentName")).append(",")
                        .append(messages.getString("csv.header.subject")).append(",")
                        .append(messages.getString("csv.header.marks")).append("\n");

                String csvContent = studentMarks.entrySet().stream()
                        .flatMap(entry -> {
                            String studentName = entry.getKey();
                            return entry.getValue().entrySet().stream()
                                    .map(markEntry -> studentName + "," + markEntry.getKey() + "," + markEntry.getValue());
                        })
                        .collect(Collectors.joining("\n"));
                writer.append(csvContent);

                JOptionPane.showMessageDialog(null, messages.getString("message.exportSuccess") + fileToSave.getAbsolutePath(),
                        messages.getString("title.exportSuccess"), JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, messages.getString("message.exportError") + e.getMessage(),
                        messages.getString("title.exportFailed"), JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, messages.getString("message.exportCancelled"), messages.getString("title.exportCancelled"), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Stream Implementation: Show teacher list
    private static void showTeacherList() {
        JFrame teacherFrame = new JFrame(messages.getString("title.teacherList"));
        teacherFrame.setSize(800, 500);
        JTextArea teacherArea = new JTextArea();

        String teacherList = teacherSubjects.entrySet().stream()
                .map(entry -> entry.getKey() + " " + messages.getString("label.teaches") + " " + entry.getValue().getSubjectDetails())
                .collect(Collectors.joining("\n"));
        teacherArea.setText(teacherList);

        JPanel subjectPanel = new JPanel();
        JTextField teacherNameField = new JTextField(10);
        JComboBox<Subject> subjectComboBox = new JComboBox<>(Subject.values());
        JButton assignSubjectButton = new JButton(messages.getString("button.assignSubject"));

        assignSubjectButton.addActionListener(e -> {
            String teacherName = teacherNameField.getText();
            Subject subject = (Subject) subjectComboBox.getSelectedItem();
            if (!teacherName.isEmpty() && subject != null) {
                teacherSubjects.put(teacherName, subject);
                teacherArea.append("\n" + messages.getString("message.assigned") + " " + subject + " " + messages.getString("label.to") + " " + teacherName);
            }
        });

        subjectPanel.add(new JLabel(messages.getString("label.teacherName")));
        subjectPanel.add(teacherNameField);
        subjectPanel.add(new JLabel(messages.getString("label.subject")));
        subjectPanel.add(subjectComboBox);
        subjectPanel.add(assignSubjectButton);

        teacherFrame.add(new JScrollPane(teacherArea), BorderLayout.CENTER);
        teacherFrame.add(subjectPanel, BorderLayout.SOUTH);
        teacherFrame.setVisible(true);
    }

    private static void showAttendanceRecord() {
        JFrame attendanceFrame = new JFrame(messages.getString("title.attendanceRecord"));
        attendanceFrame.setSize(800, 500);
        attendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea attendanceArea = new JTextArea();
        attendanceArea.setEditable(false);

        JPanel attendancePanel = new JPanel();
        JTextField studentNameField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{messages.getString("label.present"), messages.getString("label.absent")});
        JButton addAttendanceButton = new JButton(messages.getString("button.recordAttendance"));

        addAttendanceButton.addActionListener(e -> {
            String studentName = studentNameField.getText().trim();
            String date = dateField.getText().trim();
            String status = (String) statusComboBox.getSelectedItem();
            if (!studentName.isEmpty() && !date.isEmpty() && studentMarks.containsKey(studentName)) {
                studentAttendance.computeIfAbsent(studentName, k -> new HashMap<>())
                        .put(date, status.equals(messages.getString("label.present")));
                updateAttendanceDisplay(attendanceArea);
                JOptionPane.showMessageDialog(attendanceFrame, messages.getString("message.attendanceRecorded") + " " + studentName + " " + messages.getString("label.on") + " " + date);
            } else {
                JOptionPane.showMessageDialog(attendanceFrame, messages.getString("message.invalidStudentOrDate"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        });

        attendancePanel.add(new JLabel(messages.getString("label.studentName")));
        attendancePanel.add(studentNameField);
        attendancePanel.add(new JLabel(messages.getString("label.date")));
        attendancePanel.add(dateField);
        attendancePanel.add(new JLabel(messages.getString("label.status")));
        attendancePanel.add(statusComboBox);
        attendancePanel.add(addAttendanceButton);

        updateAttendanceDisplay(attendanceArea);

        attendanceFrame.add(new JScrollPane(attendanceArea), BorderLayout.CENTER);
        attendanceFrame.add(attendancePanel, BorderLayout.SOUTH);
        attendanceFrame.setLocationRelativeTo(null);
        attendanceFrame.setVisible(true);
    }

    // Stream Implementation: Display attendance
    private static void updateAttendanceDisplay(JTextArea attendanceArea) {
        String attendanceText = studentAttendance.entrySet().stream()
                .map(entry -> {
                    String studentName = entry.getKey();
                    Map<String, Boolean> records = entry.getValue();
                    String recordText = records.entrySet().stream()
                            .map(record -> "  " + record.getKey() + ": " + (record.getValue() ? messages.getString("label.present") : messages.getString("label.absent")))
                            .collect(Collectors.joining("\n"));
                    return studentName + ":\n" + recordText;
                })
                .collect(Collectors.joining("\n\n", messages.getString("label.studentWiseAttendance") + ":\n\n", ""));

        if (studentAttendance.isEmpty()) {
            attendanceText += "\n" + messages.getString("message.noAttendanceRecords");
        }
        attendanceArea.setText(attendanceText);
    }

    // Stream Implementation: Generate report card
    private static void generateStudentReportCard(String studentName) {
        if (!studentMarks.containsKey(studentName)) {
            JOptionPane.showMessageDialog(null, messages.getString("message.studentNotFound"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<Subject, Integer> marks = studentMarks.get(studentName);
        Map<String, Boolean> attendance = studentAttendance.getOrDefault(studentName, new HashMap<>());

        StringBuilder reportCard = new StringBuilder();
        reportCard.append(messages.getString("label.reportCardHeader")).append("\n");
        reportCard.append(messages.getString("label.student")).append(": ").append(studentName).append("\n\n");
        reportCard.append(messages.getString("label.subjectWiseMarks")).append("\n");

        // Stream to format marks
        String marksText = marks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
        reportCard.append(marksText).append("\n");

        // Stream to calculate total marks
        int totalMarks = marks.values().stream().mapToInt(Integer::intValue).sum();
        double averageMarks = marks.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
        reportCard.append("\n").append(messages.getString("label.totalMarks")).append(": ").append(totalMarks).append("\n");
        reportCard.append(messages.getString("label.averageMarks")).append(": ").append(String.format("%.2f", averageMarks)).append("\n\n");

        reportCard.append(messages.getString("label.attendanceRecord")).append("\n");
        // Stream to format attendance
        String attendanceText = attendance.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + (entry.getValue() ? messages.getString("label.present") : messages.getString("label.absent")))
                .collect(Collectors.joining("\n"));
        reportCard.append(attendanceText);

        // Stream to calculate attendance percentage
        long presentDays = attendance.values().stream().filter(Boolean::booleanValue).count();
        int totalDays = attendance.size();
        double attendancePercentage = totalDays > 0 ? (presentDays * 100.0 / totalDays) : 0;
        reportCard.append("\n\n").append(messages.getString("label.attendancePercentage")).append(": ").append(String.format("%.2f", attendancePercentage)).append("%\n");

        JTextArea reportArea = new JTextArea(reportCard.toString());
        reportArea.setEditable(false);

        JPanel reportPanel = new JPanel(new BorderLayout());
        reportPanel.add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JButton printButton = new JButton(messages.getString("button.printReportCard"));
        printButton.addActionListener(e -> printReportCard(reportCard.toString()));
        reportPanel.add(printButton, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, reportPanel, messages.getString("title.reportCard") + " " + studentName, JOptionPane.PLAIN_MESSAGE);
    }

    private static void printReportCard(String reportText) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.setFont(new Font("Monospaced", Font.PLAIN, 12));
            String[] lines = reportText.split("\n");
            int y = 20;
            for (String line : lines) {
                g2d.drawString(line, 20, y);
                y += 15;
            }
            return Printable.PAGE_EXISTS;
        });

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(null, messages.getString("message.printSuccess"), messages.getString("title.success"), JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, messages.getString("message.printError") + ": " + e.getMessage(), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static Map<Subject, Integer> getStudentMarks() {
        Map<Subject, Integer> marks = new HashMap<>();
        try {
            marks.put(Subject.MATH, Integer.parseInt(JOptionPane.showInputDialog(messages.getString("prompt.enterMathMarks"))));
            marks.put(Subject.SCIENCE, Integer.parseInt(JOptionPane.showInputDialog(messages.getString("prompt.enterScienceMarks"))));
            marks.put(Subject.ENGLISH, Integer.parseInt(JOptionPane.showInputDialog(messages.getString("prompt.enterEnglishMarks"))));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, messages.getString("message.invalidMarks"), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
        }
        return marks;
    }

    private static void loadStudentDataFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentData.ser"))) {
            studentMarks = (Map<String, Map<Subject, Integer>>) in.readObject();
            studentAttendance = (Map<String, Map<String, Boolean>>) in.readObject();
            teacherSubjects = (Map<String, Subject>) in.readObject();
            System.out.println(messages.getString("message.dataLoaded"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(messages.getString("message.noDataFound"));
            studentMarks = new HashMap<>();
            studentAttendance = new HashMap<>();
            teacherSubjects = new HashMap<>();
            initializeDefaultData();
        }
    }

    private static void saveStudentDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentData.ser"))) {
            out.writeObject(studentMarks);
            out.writeObject(studentAttendance);
            out.writeObject(teacherSubjects);
            System.out.println(messages.getString("message.dataSaved"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, messages.getString("message.saveError") + ": " + e.getMessage(), messages.getString("title.error"), JOptionPane.ERROR_MESSAGE);
        }
    }
}

