package com.SchoolManagementSystem;

/* -We can use record class instead of writing too many classes like class, constructor, getter,setter, tostringmethod
 hashcode, equals.
 -we can write this whole methods in one line with help of record class.
 -All the variables in the record class is final and private
 - Record class donot extend any other class. Only extend record class.

 - record constructor called "canonical constructor".*/

public final record Student(String name, int studentId, int age) {}
/*
public class Student{
    private final String name;
    private final int age;
    private final int studentId;

    public Student(String name, int age,int studentId){
        this.age = age;
        this.name = name;
        this.studentId = studentId;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getStudentId(){
        return studentId;
    }
}   */