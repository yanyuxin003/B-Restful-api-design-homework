package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
    }

    public void addStudent(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    public void deleteStudentById(int id) {
        students.remove(id);
    }


    public List<Student> getStudents(String gender) {
        List<Student> genderStudents = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getGender().equals(gender)){
                    genderStudents.add(students.get(i));
                }
            }
        return genderStudents;
    }
}
