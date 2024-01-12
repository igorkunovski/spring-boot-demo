package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //GET http://localhost:8080/students/3
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.getById(id);
    }

    //GET http://localhost:8080/students/
    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

    //GET http://localhost:8080/students/search?name=Alex
    @GetMapping("/search")
    public Stream<Student> searchStudents(@RequestParam String name) {
        return studentRepository.getByName(name);
    }

    //GET http://localhost:8080/students/group/art
    @GetMapping("/group/{groupName}")
    public Stream<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentRepository.getByGroup(groupName);
    }

    //POST http://localhost:8080/students/add  ({ "name": "Igor", "groupName": "art" })
    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        studentRepository.addStudent(student);
        return student;
    }

    //DELETE http://localhost:8080/students/2
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteStudent(id);
    }
}
