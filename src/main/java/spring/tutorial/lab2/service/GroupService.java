package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.GroupUser;

import java.util.List;
import java.util.Optional;

public interface GroupService {
     List<GroupUser> getAll();

     GroupUser saveGroup(GroupUser groupUser);

     Optional<GroupUser> findById(long id);

}
