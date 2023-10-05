package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.tutorial.lab2.model.GroupUser;
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
    public List<GroupUser> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public GroupUser saveGroup(@RequestBody GroupUser groupUser) {
        if (groupUser != null) {
            return groupRepository.save(groupUser);
        }
        return null;

    }

    @Override
    public Optional<GroupUser> findById(long id) {
        Optional<GroupUser> optional = groupRepository.findById(id);
        if (optional.isPresent()) {
            return groupRepository.findById(id);
        }
        return null;
    }
}
