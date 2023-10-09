package spring.tutorial.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.lab2.model.Group;
import spring.tutorial.lab2.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/all")
    public ResponseEntity<List<Group>> getAll(){
        List<Group> u =groupService.getAll();
        return ResponseEntity.ok(u);
    }

    @PostMapping("/save")
    public ResponseEntity<Group> saveGroup(@RequestBody Group groupUser){
        Group u = groupService.saveGroup(groupUser);
        return ResponseEntity.ok(u);
    }



}
