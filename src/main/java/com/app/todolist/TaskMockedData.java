package com.app.todolist;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskMockedData {
    private final Map<UUID,User> userMap;
    private final Map<UUID,Task> taskMap;

    private static TaskMockedData instance = null;
    public static TaskMockedData getInstance(){
        if(instance == null){
            instance = new TaskMockedData();
        }
        return instance;
    }

    public TaskMockedData(){
        userMap = new HashMap<>();
        taskMap = new HashMap<>();
        User u1 = new User("abc","abc@mail.com");
        User u2 = new User("def","def@mail.com");
        User u3 = new User("ghi","ghi@mail.com");
        userMap.put(u1.getId(),u1);
        userMap.put(u2.getId(),u2);
        userMap.put(u3.getId(),u3);
        Task t11 = new Task(u1.getId(),"title11","content11");
        Task t12 = new Task(u1.getId(),"title12","content12");
        Task t13 = new Task(u1.getId(),"title13","content13");
        Task t21 = new Task(u2.getId(),"title21","content21");
        Task t22 = new Task(u2.getId(),"title22","content22");
        Task t23 = new Task(u2.getId(),"title23","content23");
        Task t31 = new Task(u3.getId(),"title31","content31");
        Task t32 = new Task(u3.getId(),"title32","content32");
        Task t33 = new Task(u3.getId(),"title33","content33");
        taskMap.put(t11.getTaskId(),t11);
        taskMap.put(t12.getTaskId(),t12);
        taskMap.put(t13.getTaskId(),t13);
        taskMap.put(t21.getTaskId(),t21);
        taskMap.put(t22.getTaskId(),t22);
        taskMap.put(t23.getTaskId(),t23);
        taskMap.put(t31.getTaskId(),t31);
        taskMap.put(t32.getTaskId(),t32);
        taskMap.put(t33.getTaskId(),t33);
    }

    public List<Task> fetchTasks(UUID userId){
        List<Task> t1 = new ArrayList<>();
        for(Task t:taskMap.values()){
            if(t.getOwnerId().equals(userId)){
                t1.add(t);
            }
        }
        return  t1;
    }

    public List<Task> searchTasks(UUID user_id,String searchTerm){
        List<Task> searchedTask = new ArrayList<>();
        for(Task t:taskMap.values()){
            if(t.getOwnerId().equals(user_id)){
                if(t.getTitle().toLowerCase().contains(searchTerm) ||
                t.getContent().toLowerCase().contains(searchTerm)){
                    searchedTask.add(t);
                }
            }
        }
        return searchedTask;
    }

    public Task createTask(UUID userId,String title,String content){
        Task newTask = new Task(userId,title,content);
        taskMap.put(newTask.getTaskId(),newTask);
        return newTask;
    }

    public Task updateTask(UUID task_id,String title,String content){
        Task t1 = new Task();
        try {
            for (Task t : taskMap.values()) {
                if (t.getTaskId().equals(task_id)) {
                    t1 = t;
                    break;
                }
            }
            t1.setTitle(title);
            t1.setContent(content);
            return t1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteAllTasks(UUID user_id){
        List<Task> t1 = new ArrayList<>();
        try{
            for(Task t : taskMap.values()){
                if(t.getOwnerId().equals(user_id)){
                    t1.add(t);
                }
            }
            for(Task t:t1)
                taskMap.remove(t.getTaskId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean deleteTask(UUID task_id){
        Task k = taskMap.remove(task_id);
        return k!=null;
    }

    public List<User> getUsers(){
        List<User> userList;
        userList = new ArrayList<>(userMap.values());
        return userList;
    }

    public User createUser(String name,String email){
        User newUser = new User(name,email);
        userMap.put(newUser.getId(),newUser);
        return newUser;
    }

    public boolean deleteUser(UUID user_id){
        User u = userMap.remove(user_id);
        return u!=null;
    }

    public User updateUser(UUID id,String name,String email){
        try{
            User u1 = new User();
            for(User u:userMap.values()){
                if(u.getId().equals(id)){
                    u1 = u;
                    break;
                }
            }
            u1.setName(name);
            u1.setEmail(email);
            return u1;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
