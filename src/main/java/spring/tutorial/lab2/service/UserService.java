package spring.tutorial.lab2.service;

import spring.tutorial.lab2.model.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {

     List<User> getAll();

     User saveUser(Map<String, Object> request);

     User editUser(long id, Map<String, Object> request);

     Boolean deleteUser(long id);

     User findById(long id);

     User finUserByEmail(String email);


}
