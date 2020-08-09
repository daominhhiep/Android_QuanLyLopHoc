package com.example.studentmanager.commom;

import java.util.Comparator;

public class SortByIdToUp implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        Integer p1 = Integer.valueOf(person1.getId());
        Integer p2 = Integer.valueOf(person2.getId());
        return p1.compareTo(p2);
    }
}