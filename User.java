package com.todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
@RequestMapping("/user")
public class User {
    String first_name;
    String last_name;
    String email;
    UUID id;
    @Autowired
    List<Task> task_list;
    public User(String fn,String ln,String email){
        this.first_name = fn;
        this.last_name = ln;
        this.email = email;
        this.id = UUID.randomUUID();
        this.task_list = new ArrayList<Task>();
    }
    @RequestMapping(value="/getFn",method= RequestMethod.GET)
    public String getFirst_name(){
        return first_name;
    }
    @RequestMapping(value="/getLn",method= RequestMethod.GET)
    public String getLast_name(){
        return last_name;
    }
    @RequestMapping(value="/getEmail",method= RequestMethod.GET)
    public String getEmail(){
        return email;
    }
    @RequestMapping(value="/getTask",method= RequestMethod.GET)
    public List<Task> getTasks(){
        return task_list;
    }
    @RequestMapping(value="/addTask",method= RequestMethod.GET)
    public void addTask(Task t){
        this.task_list.add(t);
    }
    @RequestMapping(value="/getId",method= RequestMethod.GET)
    public UUID getUserId(){
        return this.id;
    }
    @RequestMapping(value="/getIndex",method= RequestMethod.GET)
    public int getIndex(UUID id){
        int index = 0;
        for(Task t:task_list){
            if(t.getId() == id){
                break;
            }
            index++;
        }
        return index;
    }
    @RequestMapping("/delete")
    public void deleteTask(UUID id){
        task_list.remove(getIndex(id));
    }
}