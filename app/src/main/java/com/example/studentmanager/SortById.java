package com.example.studentmanager;

import java.util.Comparator;

public class SortById implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getId().compareTo(student2.getId());
    }
}