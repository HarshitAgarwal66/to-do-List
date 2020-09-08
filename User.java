package com.todolist.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String first_name;
    String last_name;
    String email;
    UUID id;
    List<Task> task_list;
    public User(String fn,String ln,String email){
        this.first_name = fn;
        this.last_name = ln;
        this.email = email;
        this.id = UUID.randomUUID();
        this.task_list = new ArrayList<Task>();
    }
    public String getFirst_name(){
        return first_name;
    }
    public String getLast_name(){
        return last_name;
    }
    public String getEmail(){
        return email;
    }
    public List<Task> getTasks(){
        return task_list;
    }
    public void addTask(Task t){
        this.task_list.add(t);
    }
    public UUID getUserId(){
        return this.id;
    }
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
    public void deleteTask(UUID id){
        task_list.remove(getIndex(id));
    }
}
