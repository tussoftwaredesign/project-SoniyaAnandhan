package com.schoolmanagement;


// ✅ Generic Teacher Class
public class GenericTeacher<T extends Subject> implements Teacher {
    private final String name;
    private final T subject;

    public GenericTeacher(String name, T subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() { return name; }
    public T getSubject() { return subject; }

    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }
}


