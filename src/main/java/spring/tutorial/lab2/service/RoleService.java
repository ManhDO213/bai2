package spring.tutorial.lab2.service;

import org.springframework.web.bind.annotation.RequestBody;
import spring.tutorial.lab2.model.Role;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RoleService {
    public List<Role> getAll();

    public Role saveRole(@RequestBody Map<String, Object> request);

    public Optional<Role> findById(long id);


}
