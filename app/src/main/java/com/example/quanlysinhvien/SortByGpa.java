package com.example.quanlysinhvien;

import java.util.Comparator;

public class SortByGpa implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        Float s1 = Float.valueOf(student1.getGpa());
        Float s2 = Float.valueOf(student2.getGpa());
        return s2.compareTo(s1);
    }
}