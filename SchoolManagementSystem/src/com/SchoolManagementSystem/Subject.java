package com.SchoolManagementSystem;
// here i am using enum to maintain subjects name
public enum Subject {
    MATHEMATICS, SCIENCE, HISTORY, ENGLISH, ART;

    // we can easily handle subjects method from here
    public String getSubjects() {

        switch (this) {
            case MATHEMATICS -> System.out.println("Mathematics");
            case SCIENCE -> System.out.println("Science");
            case HISTORY -> System.out.println("History");
            case ENGLISH -> System.out.println("English");
            case ART -> System.out.println("Art");
            default -> System.out.println("Unknown subject");


        }
        return "";
    }
}