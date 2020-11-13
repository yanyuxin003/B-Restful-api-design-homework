package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping("groups/")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PutMapping("/groups/{id}")
    public Group updateGroupName(@PathVariable int id, @RequestBody String name) {
//        groupService.groupStudents();
//
        return  groupService.updateGroupById(id, name);
    }
}
