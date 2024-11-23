package com.SchoolManagementSystem;

public class Attendence {
    private final Student student;
    private final boolean[] attendenceRecord;

    public Attendence(Student student, int totalDays) {
        this.student = student;
        this.attendenceRecord = new boolean[totalDays];
    }
// Maintain student attendance in array as a boolean type
    public Attendence(Student student, boolean[] attendenceRecord) {
        this.student = student;
        this.attendenceRecord = attendenceRecord;
    }

    public void markAttendence(int day, boolean status) {
        if (day >= 0 && day < attendenceRecord.length) {
            attendenceRecord[day] = status;
        } else {
            System.out.println("Invalid day: " + day);
        }
    }

    public void printAttendenceReport() {
        System.out.println("Attendance Report for " + student.name() + " (" + student.studentId() + "):");
        for (int i = 0; i < attendenceRecord.length; i++) {
            String status = attendenceRecord[i] ? "Present" : "Absent";
            System.out.println("Day " + (i + 1) + ": " + status);
        }
    }
}


