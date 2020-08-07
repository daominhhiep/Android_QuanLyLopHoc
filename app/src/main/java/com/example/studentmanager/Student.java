package com.example.studentmanager;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private String gpa;
    private int avatarStudent;


    public Student(String id, String name, String birth, String address, String gpa) {
        super(id, name, birth, address);
        this.gpa = gpa;
    }

    public Student(String id, String name, String birth, String address, String gpa, int avatar) {
        super(id, name, birth, address);
        this.gpa = gpa;
        this.avatarStudent = avatar;
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
