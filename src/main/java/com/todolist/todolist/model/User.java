package com.todolist.todolist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final List<String> taskList;
    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("email") String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.taskList = new ArrayList<String>();
    }
    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public List<String> getTaskList(){
        return taskList;
    }
}
