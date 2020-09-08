package com.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/UserControl")
public class UserController {
@Autowired
List<User> users_list;
    public UserController(){
        users_list = new ArrayList<User>();
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public void addUser(User u){
        this.users_list.add(u);
    }
    @RequestMapping(value = "/deleteUser")
    public void deleteUser(User u){
        boolean flag = false;
        for(User k:users_list){
            if(k.getUserId() == u.getUserId()){
                this.users_list.remove(u);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("User not found!");
        }
    }
}