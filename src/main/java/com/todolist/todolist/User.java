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
@RequestMapping("/user")
public class User {
    String first_name;
    String last_name;
    String email;
    UUID id;
    @Autowired
    List<Task> task_list;
    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public void createUser(@RequestParam(name="first_name") String fn,@RequestParam(name="last_name") String ln,@RequestParam(name="email") String email){
        User u = new User();
        u.first_name = fn;
        u.last_name = ln;
        u.email = email;
        u.id = UUID.randomUUID();
        u.task_list = new ArrayList<Task>();
        System.out.println("REACHED ADD USER HANDLER");
        System.out.println(u.id);
        System.out.println(u.first_name);
        System.out.println(u.last_name);
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