package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.User;
import com.group2.petcareinfotype.repository.UserRepository;
import com.group2.petcareinfotype.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/user")
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(name = "username", required = false) String username,
                                                 @RequestParam(name = "mail", required = false) String mail,
                                                 @RequestParam(name = "phone", required = false) String phone,
                                                 @RequestParam(name = "address", required = false) String address) {
        return ResponseEntity.accepted().body(userService.getUser(username, mail, phone, address));
    }

    @PostMapping(value = "/searchById")
    public ResponseEntity<User> searchUserById(@RequestBody String id) {
        return ResponseEntity.accepted().body(userService.getUserById(id));
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<User>> searchAllUser() {
        return ResponseEntity.accepted().body(userService.getAllUsers());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.accepted().body(userService.updateUser(user));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.accepted().body(userService.createUser(user));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return ResponseEntity.accepted().body("Delete user success");
    }
}
