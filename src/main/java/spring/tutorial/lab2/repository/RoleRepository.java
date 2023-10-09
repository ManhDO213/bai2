package spring.tutorial.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.lab2.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);

}
