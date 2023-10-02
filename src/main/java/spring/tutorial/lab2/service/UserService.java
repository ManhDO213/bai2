package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {

    public List<User> getAll();

    public User saveUser(Map<String, Object> request);

    public User editUser(long id, Map<String, Object> request);

    public Boolean deleteUser(long id);

    public User findById(long id);

}
