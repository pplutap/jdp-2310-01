package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<GroupDto>> getGroups() {
        List<Group> groups = groupService.getGroups();
        return ResponseEntity.ok(groupMapper.mapToGroupDtoList(groups));
    }

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        groupService.saveGroup(group);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "groupId")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable Long groupId) throws GroupNotFoundException {
        return ResponseEntity.ok(groupMapper.mapToGroupDto(groupService.getGroupById(groupId)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDto> updateGroup(@PathVariable Long groupId, @RequestBody GroupDto groupDto) throws GroupNotFoundException {
        Group group = groupMapper.mapToGroup(groupDto);
        Group groupToUpdate = groupService.updateGroup(group, groupId);
        return ResponseEntity.ok(groupMapper.mapToGroupDto(groupToUpdate));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "groupId")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroupById(groupId);
        return ResponseEntity.ok().build();
    }
}