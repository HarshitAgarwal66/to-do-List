package com.app.todolist;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Task {
    private UUID ownerId;
    @Id
    private UUID taskId;
    private String title;
    private String content;

    public Task(){}

    public Task(UUID ownerId,String title,String content){
        this.ownerId = ownerId;
        this.taskId = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
