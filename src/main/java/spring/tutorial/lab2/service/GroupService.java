package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
     List<Group> getAll();

     Group saveGroup(Group groupUser);

     Optional<Group> findById(long id);

}
