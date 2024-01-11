package com.example.demo.leetcode;

public class Student {

    private String name;
    private double grade;
    private String color;

    public Student(String name, double grade, String color) {
        this.name = name;
        this.grade = grade;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String graduated() {
        String result = "fail";
        if(grade >= 80) {
            result = "pass";
        }
        return result;
    }
}
