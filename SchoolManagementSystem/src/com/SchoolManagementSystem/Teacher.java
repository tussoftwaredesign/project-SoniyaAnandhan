package com.SchoolManagementSystem;

public final class Teacher extends SchoolMemebers {
    private final Subject subject;

//    we can get teacher name and id methods from schoolmember class. Because, teacher class inherits memeber class.
    public Teacher(String name, int id, Subject subject){
        super(name, id);
        this.subject = subject;
    }
    public String getName(){

        return super.getName()+ " (Teacher of " + getSubject() + ")";
    }
    public Subject getSubject(){
        return subject;
    }

}
