package com.example.quanlysinhvien;

import java.io.Serializable;

public class Student implements Serializable {

    private String id;
    private String name;
    private String birth;
    private String address;
    private String gpa;
    private int avatar;

    public Student() {

    }

    public Student(String id, String name, String birth, String address, String gpa) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.gpa = gpa;
    }

    public Student(String id, String name, String age, String address, String gpa, int avatar) {
        this.id = id;
        this.name = name;
        this.birth = age;
        this.address = address;
        this.gpa = gpa;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", gpa='" + gpa + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}