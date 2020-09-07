package com.todolist.todolist;

import java.util.Date;
import java.util.UUID;

public class Task {
    String title;
    String content;
    Date created;
    Date updated;
    UUID id;
    public Task(){
        this.id = UUID.randomUUID();
        this.title = "";
        this.content = "";
        this.created = new Date();
        this.updated = new Date();
    }
    public Task(String title, String content){
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.created = new Date();
        this.updated = new Date();
    }
    public UUID getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public Date getCreated(){
        return created;
    }
    public Date getUpdated(){
        return updated;
    }
    public void setUpdated(Date new_date){
        this.updated = new_date;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setID(UUID new_id){
        this.id = new_id;
    }
}
