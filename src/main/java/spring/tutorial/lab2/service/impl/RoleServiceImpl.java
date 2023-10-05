package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.repository.GroupRepository;
import spring.tutorial.lab2.repository.RoleRepository;
import spring.tutorial.lab2.service.RoleService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GroupRepository groupRepository;
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveRole( @RequestBody  Map<String, Object> request) {
        Role role = new Role();
        Long groupID = Long.parseLong(request.get("groupID").toString());
        role.setName(request.get("name").toString());
        role.setGroupUser(groupRepository.findById(groupID).get());
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(long id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            return roleRepository.findById(id);
        }
        return null;
    }
}
