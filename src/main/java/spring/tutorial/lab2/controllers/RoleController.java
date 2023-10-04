package spring.tutorial.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.lab2.model.Role;
import spring.tutorial.lab2.service.GroupService;
import spring.tutorial.lab2.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> list = roleService.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        Role role1 = roleService.saveRole(role);
        return ResponseEntity.ok(role1);
    }


}
