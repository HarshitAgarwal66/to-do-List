package com.todolist.todolist;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> users_list;
    public UserController(){
        users_list = new ArrayList<User>();
    }
    public void addUser(User u){
        this.users_list.add(u);
    }
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
