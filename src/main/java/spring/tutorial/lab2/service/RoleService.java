package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public List<Role> getAll();

    public Role saveRole(Role group);

    public Optional<Role> findById(long id);
}
