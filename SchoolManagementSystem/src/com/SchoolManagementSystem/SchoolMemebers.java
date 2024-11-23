package com.SchoolManagementSystem;

sealed class SchoolMemebers permits Teacher{
    private final String name;
    private final int id;

    public SchoolMemebers(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
}
