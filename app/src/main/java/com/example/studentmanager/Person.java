package com.example.studentmanager;

import java.io.Serializable;

public class Person implements Serializable {
    private String id;
    private String name;
    private String birth;
    private String address;

    private  Person(){

    }

    public Person(String id, String name, String birth, String address) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
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

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
