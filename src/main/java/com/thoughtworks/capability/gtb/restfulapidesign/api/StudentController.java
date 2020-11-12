package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getStudentList(@RequestParam(required = false) String gender) {
        return studentService.getStudents(gender);
    }

    @GetMapping("students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student findStudent(@PathVariable int id) {
        return studentService.findStudentById(id);
    }


    @PutMapping("students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable Student student,int id) {
        return studentService.updateStudentById(student,id);
    }
}
