package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.GroupDefinitionException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) throws GroupNotFoundException {
        return groupRepository.findById(id).orElseThrow(() ->
                new GroupNotFoundException("Group was not found by id: " + id));
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(final Group group, final Long id) throws GroupNotFoundException{
        Optional<Group> groupEntity = groupRepository.findById(id);
        Group groupToUpdate = groupEntity.orElseThrow(() ->
                new GroupDefinitionException("Group was not found by id: " + id));

        groupToUpdate.setName(group.getName());
        return groupRepository.save(groupToUpdate);
    }

    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }

}
