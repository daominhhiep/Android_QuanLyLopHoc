package com.example.studentmanager;

import java.util.Comparator;

public class SortByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
            Integer p1 = Integer.valueOf(person1.getAge());
            Integer p2 = Integer.valueOf(person2.getAge());
            return p1.compareTo(p2);
    }
}