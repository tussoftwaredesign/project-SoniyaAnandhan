package com.schoolmanagement;

// Enum for Subjects
enum Subject {
    MATH, SCIENCE, ENGLISH, HISTORY, PHYSICS, CHEMISTRY, COMPUTER_SCIENCE;

    public String getSubjectDetails() {
        return switch (this) {
            case MATH -> "Mathematics: Algebra, Geometry, and Calculus";
            case SCIENCE -> "Science: Biology, Physics, and Chemistry";
            case ENGLISH -> "English: Literature and Grammar";
            case HISTORY -> "History: World History and Civics";
            case PHYSICS -> "Physics: Mechanics and Electromagnetism";
            case CHEMISTRY -> "Chemistry: Organic and Inorganic Chemistry";
            case COMPUTER_SCIENCE -> "Computer Science: Programming and Data Structures";
        };
    }
}
