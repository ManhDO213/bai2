package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.GroupUser;

import java.util.List;

public interface GroupService {
    public List<GroupUser> getAll();

    public GroupUser saveGroup(GroupUser group);

    public GroupUser findById(long id);

}
