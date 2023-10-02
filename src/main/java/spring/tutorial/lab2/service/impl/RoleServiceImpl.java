package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.repository.RoleRepository;
import spring.tutorial.lab2.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveRole(Role group) {
        if (group != null) {
            return roleRepository.save(group);
        }
        return null;
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
