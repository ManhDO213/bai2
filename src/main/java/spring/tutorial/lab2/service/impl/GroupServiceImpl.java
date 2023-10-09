package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.tutorial.lab2.model.Group;
import spring.tutorial.lab2.repository.GroupRepository;
import spring.tutorial.lab2.service.GroupService;
import spring.tutorial.lab2.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group saveGroup(@RequestBody Group groupUser) {
        if (groupUser != null) {
            return groupRepository.save(groupUser);
        }
        return null;

    }

    @Override
    public Optional<Group> findById(long id) {
        Optional<Group> optional = groupRepository.findById(id);
        if (optional.isPresent()) {
            return groupRepository.findById(id);
        }
        return null;
    }
}
