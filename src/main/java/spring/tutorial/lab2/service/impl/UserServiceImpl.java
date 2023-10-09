package spring.tutorial.lab2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import spring.tutorial.lab2.model.Group;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.model.User;
import spring.tutorial.lab2.repository.GroupRepository;
import spring.tutorial.lab2.repository.RoleRepository;
import spring.tutorial.lab2.repository.UserRepository;
import spring.tutorial.lab2.service.RoleService;
import spring.tutorial.lab2.service.UserService;
import spring.tutorial.lab2.util.Util;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(Map<String, Object> request) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        List<Long> roleIds = (List<Long>) request.get("roleID");
        user.setEmail(request.get("email").toString());
        user.setFullName(request.get("fullName").toString());
        user.setPasswd(passwordEncoder.encode(request.get("passwd").toString()));
        if(roleIds != null){
            for (int i = 0 ;i< roleIds.size();i++){
                  Role role = roleRepository.findById(Long.parseLong(roleIds.get(i)+""));
                  roles.add(role);
            }
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

//    @Override
//    public User editUser(long id, long groupID, Map<String, Object> request) {
//        return null;
//    }


    @Override
    public User editUser(long id, long groupID, Map<String, Object> request) {

        List<Long> roleIds = (List<Long>) request.get("roleID");
        Set<Role> roles = new HashSet<>();
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(request.get("email").toString());
            user.setFullName(request.get("fullName").toString());
            user.setPasswd(passwordEncoder.encode(request.get("passwd").toString()));
            Optional<Group> groups = groupRepository.findById(groupID);
            if (groups.isPresent()){
                Group g = groups.get();
                if (Util.compareArray(new ArrayList<>(user.getRoles()), new ArrayList<>(g.getRole()))){
                    if(roleIds != null){
                        for (int i = 0 ;i< roleIds.size();i++){
                            Role role = roleRepository.findById(Long.parseLong(roleIds.get(i)+""));
                            roles.add(role);
                        }
                    }
                    user.setRoles(roles);
                }
            }
            return userRepository.save(user);
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



    @Override
    public List<User> finUserByRoleOrID(@Param("id1") long id1) {
        return userRepository.findUsersByIdAndRole(id1);
    }


}
