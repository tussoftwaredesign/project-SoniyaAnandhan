package com.schoolmanagement;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

// Record Class for Student Information
record Student(String name, int id, LocalDate dob, List<Subject> subjects, Map<Subject, Integer> marks) {}
