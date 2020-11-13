package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private StudentService studentService;
    private List<Group> groups = new ArrayList<>();
    private final int GroupsMaxLength = 6;
    
    public GroupService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Group> getGroups() {
        List<Student> students = studentService.getStudents(null);
        Collections.shuffle(students);
        for (int i = 0; i < GroupsMaxLength ; i++) {
            List<Student> studentsToGroup = new ArrayList<>();
            studentsToGroup.add(students.get(i));
            groups.add(new Group(i+1, "the"+(i+1)+"Group", "A team", studentsToGroup));
        }
        for (int i = GroupsMaxLength; i < students.size(); i++) {
            int groupId = i % GroupsMaxLength;
            groups.get(groupId).getStudents().add(students.get(i));
        }
        return groups;
    }

    public Group updateGroupById(Integer id, String name) {
        groups.get(id - 1).setName(name);
        return groups.get(id - 1);
    }
}
