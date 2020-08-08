package com.example.studentmanager;

import java.util.Comparator;

public class SortByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }
}