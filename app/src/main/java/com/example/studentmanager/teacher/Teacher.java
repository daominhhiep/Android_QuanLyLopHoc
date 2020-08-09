package com.example.studentmanager.teacher;

import com.example.studentmanager.commom.Person;

public class Teacher extends Person {
    private String roles;
    private int avatarTeacher;

    public Teacher(String id, String name, String birth, String address, String classroom) {
        super(id, name, birth, address, classroom);
    }

    public Teacher(String id, String name, String age, String address, String classroom, String roles) {
        super(id, name, age, address, classroom);
        this.roles = roles;
    }

    public Teacher(String id, String name, String age, String address, String classroom, String roles, int avatarTeacher) {
        super(id, name, age, address, classroom);
        this.roles = roles;
        this.avatarTeacher = avatarTeacher;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getAvatarTeacher() {
        return avatarTeacher;
    }

    public void setAvatarTeacher(int avatarTeacher) {
        this.avatarTeacher = avatarTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "roles='" + roles + '\'' +
                ", avatarTeacher=" + avatarTeacher +
                '}';
    }
}
