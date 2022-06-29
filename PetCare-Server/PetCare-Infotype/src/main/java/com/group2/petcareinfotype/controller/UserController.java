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

    @GetMapping(value = "/searchById")
    public ResponseEntity<User> searchUserById(@RequestParam(name = "id", required = false) String id) {
        return ResponseEntity.accepted().body(userService.getUserById(id));
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<User>> searchAllUser() {
        return ResponseEntity.accepted().body(userService.getAllUsers());
    }

    @GetMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestParam(name = "id", required = true) Long id,
                                           @RequestParam(name = "username", required = false) String username,
                                           @RequestParam(name = "password", required = false) String password,
                                           @RequestParam(name = "mail", required = false) String mail,
                                           @RequestParam(name = "phone", required = false) String phone,
                                           @RequestParam(name = "address", required = false) String address,
                                           @RequestParam(name = "birthDate", required = false) String birthDate) {
        User updateUser = User.builder().id(id)
                .username(username)
                .password(password)
                .phone(phone)
                .address(address)
                .mail(mail)
                .birthDate(birthDate)
                .build();
        return ResponseEntity.accepted().body(userService.updateUser(updateUser));
    }

    @GetMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestParam(name = "username", required = false) String username,
                                           @RequestParam(name = "password", required = false) String password,
                                           @RequestParam(name = "mail", required = false) String mail,
                                           @RequestParam(name = "phone", required = false) String phone,
                                           @RequestParam(name = "address", required = false) String address,
                                           @RequestParam(name = "birthDate", required = false) String birthDate) {
        User createUser = User.builder()
                .username(username)
                .password(password)
                .phone(phone)
                .address(address)
                .mail(mail)
                .birthDate(birthDate)
                .build();
        return ResponseEntity.accepted().body(userService.createUser(createUser));
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "id", required = true) Long id,
                                             @RequestParam(name = "username", required = false) String username,
                                             @RequestParam(name = "password", required = false) String password,
                                             @RequestParam(name = "mail", required = false) String mail,
                                             @RequestParam(name = "phone", required = false) String phone,
                                             @RequestParam(name = "address", required = false) String address,
                                             @RequestParam(name = "birthDate", required = false) String birthDate) {
        User deleteUser = User.builder().id(id)
                .username(username)
                .password(password)
                .phone(phone)
                .address(address)
                .mail(mail)
                .birthDate(birthDate)
                .build();
        userService.deleteUser(deleteUser);
        return ResponseEntity.accepted().body("Delete user success");
    }
}
