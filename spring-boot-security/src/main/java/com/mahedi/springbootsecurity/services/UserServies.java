package com.mahedi.springbootsecurity.services;

import com.mahedi.springbootsecurity.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServies {

    List<User> list=new ArrayList<>();

//    public UserServies() {
//        list.add(new User("abc","abc","ABC@gmail.com"));
//        list.add(new User("def","def","def@gmail.com"));
//    }

//    get All users
    public List<User> getAllUser(){
         return this.list;
    }

//    getSingle User
    public User getUser(String userename){
        return this.list.stream().filter((user) -> user.getUsername().equals(userename)).findAny().orElse(null);
    }

//    Add new userename
    public User Adduser(User user){
        this.list.add(user);
        return user;
    }

}
