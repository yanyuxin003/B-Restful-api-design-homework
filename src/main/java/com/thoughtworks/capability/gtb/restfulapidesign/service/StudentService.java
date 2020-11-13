package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    public List<Student> students = new ArrayList<>();


    public StudentService() {
        students.add(new Student(1, "yyx", "female", "dev"));
        students.add(new Student(2, "ytj", "male", "qa"));
        students.add(new Student(3, "cjq", "female", "pm"));
        students.add(new Student(4, "dy", "male", "hr"));
        students.add(new Student(5, "ess", "female", "xu"));
        students.add(new Student(6, "zw", "male", "ba"));
    }


    public void addStudent(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    public void deleteStudentById(int id) {
        Student student = findStudentById(id);
        this.students.remove(student);
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
            throw new IllegalArgumentException("没有这个学生");
    }



    public List<Student> getStudents(String gender) {
        if (gender == null) {
            return this.students;
        }
        List<Student> genderStudents = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getGender().equals(gender)){
                    genderStudents.add(students.get(i));
                }
            }
        return genderStudents;
    }

    public Student updateStudentById(Student student,int id) {
        Student newStudent = findStudentById(student.getId());
        newStudent.setName(student.getName());
        newStudent.setGender(student.getGender());
        newStudent.setNote(student.getNote());
        return newStudent;
    }
}
