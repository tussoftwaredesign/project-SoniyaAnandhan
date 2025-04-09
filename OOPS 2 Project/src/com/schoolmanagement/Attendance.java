package com.schoolmanagement;

import java.time.LocalDate;



import java.time.LocalDate;

public class Attendance {
    private int studentId;
    private LocalDate date;
    private boolean present;

    public Attendance(int studentId, LocalDate date, boolean present) {
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    public int getStudentId() {
        return studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }


    public int studentId() {
        return studentId;
    }

    public LocalDate date() {
        return date;
    }

    public boolean present() {
        return present;
    }
}
