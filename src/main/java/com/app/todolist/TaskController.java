package com.app.todolist;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/fake")
public class TaskController {

    TaskMockedData taskMockedData = TaskMockedData.getInstance();

    @GetMapping("/{id}/task")
    public List<Task> getTasks(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return taskMockedData.fetchTasks(uuid);
    }

    @PostMapping("/{id}/task/search")
    public List<Task> search(@PathVariable String id,@RequestBody Map<String,String> body){
        String searchTerm = body.get("text");
        UUID uuid = UUID.fromString(id);
        return taskMockedData.searchTasks(uuid,searchTerm);
    }

    @PostMapping("/{id}/task")
    public Task createTask(@PathVariable String id,@RequestBody Map<String ,String> body){
        UUID uuid = UUID.fromString(id);
        String title = body.get("title");
        String content = body.get("content");
        return taskMockedData.createTask(uuid,title,content);
    }

    @PutMapping("/task/{task_id}")
    public Task update(@PathVariable String task_id,@RequestBody Map<String,String> body){
        UUID tid = UUID.fromString(task_id);
        String title = body.get("title");
        String content = body.get("content");
        return taskMockedData.updateTask(tid,title,content);
    }

    @DeleteMapping("/task/{task_id}")
    public boolean delete(@PathVariable String task_id){
        UUID tid = UUID.fromString(task_id);
        return taskMockedData.deleteTask(tid);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return taskMockedData.getUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody Map<String,String> body){
        String name = body.get("name");
        String email = body.get("email");
        return taskMockedData.createUser(name,email);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id,@RequestBody Map<String,String> body){
        UUID uid = UUID.fromString(id);
        String name = body.get("name");
        String email = body.get("email");
        return taskMockedData.updateUser(uid,name,email);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable String id){
        UUID uid = UUID.fromString(id);
        taskMockedData.deleteAllTasks(uid);
        return taskMockedData.deleteUser(uid);
    }
}
