package com.example;

import lombok.Data;

@Data
class Student {

    private static Long counter = 1L;
    private final Long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = counter++;
        this.name = name;
        this.groupName = groupName;
    }
}