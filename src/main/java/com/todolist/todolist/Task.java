package com.todolist.todolist;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;
@Component
@RequestMapping("/task")
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
    @RequestMapping(value = "/getId",method = RequestMethod.GET)
    public UUID getId(){
        return id;
    }
    @RequestMapping(value = "/gettitle",method = RequestMethod.GET)
    public String getTitle(){
        return title;
    }
    @RequestMapping(value = "/getContent",method = RequestMethod.GET)
    public String getContent(){
        return content;
    }
    @RequestMapping(value = "/getCreate",method = RequestMethod.GET)
    public Date getCreated(){
        return created;
    }
    @RequestMapping(value = "/getupdate",method = RequestMethod.GET)
    public Date getUpdated(){
        return updated;
    }
    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public void setPara(@RequestParam(name="content") String content,@RequestParam(name = "title") String title){
        this.content = content;
        this.id = UUID.randomUUID();
        this.title = title;
        this.updated = new Date();
    }
}