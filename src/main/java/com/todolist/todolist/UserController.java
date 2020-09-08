package com.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequestMapping("/addNewUser")
public class UserController {
    @Autowired
    public static List<User> users_list;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void addUser(User u){
        users_list.add(u);
    }
    @RequestMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam(name="uid") UUID u){
        boolean flag = false;
        for(User k:users_list){
            if(k.getUserId() == u){
                users_list.remove(u);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("User not found!");
        }
    }
}
