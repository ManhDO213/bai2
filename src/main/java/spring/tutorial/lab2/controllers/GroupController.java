package spring.tutorial.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.lab2.model.GroupUser;
import spring.tutorial.lab2.model.User;
import spring.tutorial.lab2.service.GroupService;
import spring.tutorial.lab2.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/all")
    public ResponseEntity<List<GroupUser>> getAll(){
        List<GroupUser> u =groupService.getAll();
        return ResponseEntity.ok(u);
    }

    @PostMapping("/save")
    public ResponseEntity<GroupUser> saveGroup(@RequestBody GroupUser groupUser){
        GroupUser u = groupService.saveGroup(groupUser);
        return ResponseEntity.ok(u);
    }



}
