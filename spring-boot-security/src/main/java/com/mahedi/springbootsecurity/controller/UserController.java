package com.mahedi.springbootsecurity.controller;

import com.mahedi.springbootsecurity.models.User;
import com.mahedi.springbootsecurity.services.UserServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
    private UserServies userServies;



@GetMapping("/")
    public List<User> getAllUser(){
        return this.userServies.getAllUser();
    }

//    return single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
    return this.userServies.getUser(username);
    }
//add user
    @PostMapping("/")
    public User add(@RequestBody User user){
        return  this.userServies.Adduser(user);
    }
}
