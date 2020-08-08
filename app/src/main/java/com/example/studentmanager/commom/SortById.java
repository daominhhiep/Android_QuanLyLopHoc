package com.example.studentmanager.commom;

import com.example.studentmanager.commom.Person;

import java.util.Comparator;

public class SortById implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        Integer p1 = Integer.valueOf(person1.getId());
        Integer p2 = Integer.valueOf(person2.getId());
        return p1.compareTo(p2);
    }
}