package com.app.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class TaskController2 {

    @Autowired
    TaskRepository repo;

    @PostMapping("/addTask/{oid}")
    public Task addTask(@PathVariable String oid, @RequestBody Map<String,String> data){
        Task t = new Task(UUID.fromString(oid),data.get("title"),data.get("content"));
        repo.save(t);
        return t;
    }

    @GetMapping("/getTask/{oid}")
    public List<Task> getTask(@PathVariable String oid,@RequestBody Map<String,String> data){
        List<Task> t = new ArrayList<Task>();
        UUID id = UUID.fromString(oid);
        for(Task k: repo.findAll()){
            if(k.getOwnerId().equals(id)){
                t.add(k);
            }
        }
        return t;
    }

    @PutMapping("/updateTask/{tid}")
    public Task updateTask(@PathVariable String tid,@RequestBody Map<String,String> data){
        UUID id = UUID.fromString(tid);
        Task k = repo.findById(id).orElse(null);
        if(k!=null){
            k.setTitle(data.get("title"));
            k.setContent(data.get("content"));
            repo.save(k);
            return k;
        }
        return null;
    }

    @DeleteMapping("/deleteTask/{tid}")
    public boolean deleteTask(@PathVariable String tid){
        UUID id = UUID.fromString(tid);
        Task k = repo.findById(id).orElse(null);
        if(k!=null){
            repo.delete(k);
            return true;
        }
        return false;
    }
}
