package com.example.studentmanager;

import java.util.Comparator;

public class SortById implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getId().compareTo(person2.getId());
    }
}