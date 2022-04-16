package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.entity.User;
import project.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController{
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/post")
    public ResponseEntity<User> postUser(@RequestBody User user){
        return userService.create(user);
    }
    
    @PutMapping("/put")
    public ResponseEntity<User> putUser(@RequestBody User user){
        return userService.update(user);
    }
}