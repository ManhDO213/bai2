package spring.tutorial.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.tutorial.lab2.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {


}
