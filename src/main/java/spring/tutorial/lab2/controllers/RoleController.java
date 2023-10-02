//package spring.tutorial.lab2.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import spring.tutorial.lab2.model.Role;
//import spring.tutorial.lab2.service.GroupService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/role")
//public class RoleController {
//
//    @Autowired
//    private GroupService groupService;
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Role>> getAllGroup(){
//        List<Role> list = groupService.getAll();
//        return ResponseEntity.ok(list);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<Role> saveGroup(@RequestBody Role group){
//        Role group1 = groupService.saveGroup(group);
//        return ResponseEntity.ok(group1);
//    }
//
//}
