package com.app.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
//        String name = data.get("name");
//        String email = data.get("email");
//        User user = new User(name,email);
        repo.save(user);
        return user;
    }

    @GetMapping("/getUser")
    public List<User> getUser(){
        List<User> k = new ArrayList<>();
        for(User u:repo.findAll()){
            k.add(u);
        }
        return k;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @RequestBody Map<String,String> data){
        User k = repo.findById(UUID.fromString(id)).orElse(null);
        if(k!=null){
            k.setName(data.get("name"));
            k.setEmail(data.get("email"));
            repo.save(k);
            return k;
        }
        return null;
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable String id){
        User k = repo.findById(UUID.fromString(id)).orElse(null);
        if(k!=null){
            repo.delete(k);
            return true;
        }
        return false;
    }
}
