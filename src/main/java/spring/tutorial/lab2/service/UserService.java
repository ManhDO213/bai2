package spring.tutorial.lab2.service;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import spring.tutorial.lab2.model.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {

     List<User> getAll();

     User saveUser(Map<String, Object> request);
    User editUser(long id, long groupID, Map<String, Object> request);

    Boolean deleteUser(long id);

     User findById(long id);

     User finUserByEmail(String email);

     List<User> finUserByRoleOrID(@Param("id1") long id1);



}
