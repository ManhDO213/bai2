package spring.tutorial.lab2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.model.User;
import spring.tutorial.lab2.service.GroupService;
import spring.tutorial.lab2.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> u =userService.getAll();
        return ResponseEntity.ok(u);
    }

    @GetMapping("/find-user/{id1}")
    public ResponseEntity<List<User>> getUserByRoleID(@PathVariable long id1){
        List<User> u =userService.finUserByRoleOrID(id1);
        return ResponseEntity.ok(u);
    }



    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody Map<String, Object> request){
        User u = userService.saveUser(request);
        return ResponseEntity.ok(u);
    }
/////

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable(required = false) long id, @RequestParam(required = false) long groupUser, @RequestBody(required = false) Map<String, Object> request){
        User u = userService.editUser(id,groupUser,request);
        return  ResponseEntity.ok(u);
    }


}
