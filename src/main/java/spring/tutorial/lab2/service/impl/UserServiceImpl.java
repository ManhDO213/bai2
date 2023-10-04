package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.model.User;
import spring.tutorial.lab2.repository.RoleRepository;
import spring.tutorial.lab2.repository.UserRepository;
import spring.tutorial.lab2.service.GroupService;
import spring.tutorial.lab2.service.RoleService;
import spring.tutorial.lab2.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(Map<String, Object> request) {
        User user = new User();
        // Set<Group> groups =new HashSet<>();
        Long roleID = Long.parseLong(request.get("roleID").toString());
        user.setEmail(request.get("email").toString());
        user.setFullName(request.get("fullName").toString());
        user.setPasswd(passwordEncoder.encode(request.get("passwd").toString()));
        user.setRole(roleService.findById(roleID).get());

        return userRepository.save(user);
    }

    @Override
    public User editUser(@PathVariable long id, @RequestBody Map<String, Object> request) {
        Long roleID = Long.parseLong(request.get("roleID").toString());

        Optional<User> u = userRepository.findById(id);
        if (u.isPresent()) {
            User u1 = u.get();
            u1.setEmail(request.get("email").toString());
            u1.setFullName(request.get("fullName").toString());
            u1.setPasswd(passwordEncoder.encode(request.get("passwd").toString()));
            u1.setRole(roleService.findById(roleID).get());
            return userRepository.save(u1);
        }

        return null;
    }

    @Override
    public Boolean deleteUser(@PathVariable long id) {
        if (id >= 1) {
            User u = userRepository.getById(id);
            if (u != null) {
                userRepository.delete(u);
                return true;
            }
        }
        return false;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User finUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
