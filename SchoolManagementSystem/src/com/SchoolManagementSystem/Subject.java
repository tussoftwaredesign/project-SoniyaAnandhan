package com.SchoolManagementSystem;
// here i am using enum to maintain subjects name
public enum Subject {
    MATHEMATICS, SCIENCE, HISTORY, ENGLISH, ART;

    // we can easily handle subjects method from here
    public String getSubjects() {
        switch (this) {
            case MATHEMATICS: return "Mathematics";
            case SCIENCE: return "Science";
            case HISTORY: return "History";
            case ENGLISH: return "English";
            case ART: return "Art";
            default: return "Unknown Subject";

        }
    }
}