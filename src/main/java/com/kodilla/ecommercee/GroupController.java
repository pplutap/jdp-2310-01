package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createGroup(GroupDto groupDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "groupId")
    public GroupDto getGroupById(@PathVariable long groupId) {
        return new GroupDto(1001L, "Biżuteria");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public GroupDto updateGroup(GroupDto groupDto) {
        return new GroupDto(1010L, "Nakrycia Głowy");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "groupId")
    public void deleteGroup(@PathVariable Long groupId) {
    }
}
