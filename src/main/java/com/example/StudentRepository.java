package com.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository(){
        this.students = new ArrayList<>();
        students.add(new Student("Alex", "math"));
        students.add(new Student("Andrew", "programming"));
        students.add(new Student("Bob", "biology"));
        students.add(new Student("Dan", "engineering"));
        students.add(new Student("Clare", "biology"));
        students.add(new Student("Ann", "programming"));
        students.add(new Student("Sam", "cyber security"));
        students.add(new Student("Natali", "engineering"));
        students.add(new Student("Megan", "art"));
        students.add(new Student("Alex", "art"));

    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public Student getById(Long id){
        return students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Stream<Student> getByName(String name){
        return students.stream()
                .filter(student -> Objects.equals(student.getName(), name));
    }

    public Stream<Student> getByGroup(String groupName){
        return students.stream()
                .filter(student -> Objects.equals(student.getGroupName(), groupName));
    }

    public void deleteStudent(Long id) {
        students.removeIf(s -> s.getId().equals(id));
        System.out.println("Deleted Successfully");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println(student + " added successfully");
    }
}
