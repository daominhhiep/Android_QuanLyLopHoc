package com.example.studentmanager;

public class Teacher extends Person {
    private String roles;
    private int avatarTeacher;


    public Teacher(String id, String name, String birth, String address) {
        super(id, name, birth, address);
    }


    public Teacher(String id, String name, String birth, String address, String roles) {
        super(id, name, birth, address);
        this.roles = roles;
    }

    public Teacher(String id, String name, String birth, String address, String roles, int avatarTeacher) {
        super(id, name, birth, address);
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
