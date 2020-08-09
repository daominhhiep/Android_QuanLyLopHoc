package com.example.studentmanager.student;

import com.example.studentmanager.commom.Person;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private String gpa;
    private int avatarStudent;


    public Student(String id, String name, String age, String address, String classroom, String gpa, int avatarStudent) {
        super(id, name, age, address, classroom);
        this.gpa = gpa;
        this.avatarStudent = avatarStudent;
    }

    public Student(String id, String name, String birth, String address, String classroom, String gpa) {
        super(id, name, birth, address, classroom);
        this.gpa = gpa;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public int getAvatarStudent() {
        return avatarStudent;
    }

    public void setAvatarStudent(int avatarStudent) {
        this.avatarStudent = avatarStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa='" + gpa + '\'' +
                ", avatarStudent=" + avatarStudent +
                '}';
    }
}
