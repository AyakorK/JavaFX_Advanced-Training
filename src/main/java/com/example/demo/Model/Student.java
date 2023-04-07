package com.example.demo.Model;

public class Student {
    private final String name;
    private final boolean isStudent;
    private final int age;
    private final String school;

    public Student(String name, boolean isStudent, int age, String school) {
        this.name = name;
        this.isStudent = isStudent;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public int getAge() {
        return age;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s", name, isStudent ? "student" : "not a student", age, school);
    }
}

