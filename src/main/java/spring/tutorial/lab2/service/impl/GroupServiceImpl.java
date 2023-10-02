package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.lab2.model.GroupUser;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.repository.GroupRepository;
import spring.tutorial.lab2.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<GroupUser> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public GroupUser saveGroup(GroupUser group) {
        if (group != null) {
            return groupRepository.save(group);
        }
        return null;
    }

    @Override
    public GroupUser findById(long id) {
        return groupRepository.findById(id).get();
    }
}
