package com.trxjster.todobackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Document
public class User {

    @Id
    private String id;

    private String name;

    private String lastName;

    private String username;

    private List<Task> tasks;

    public void setTask(Task t){
        this.tasks.add(t);
    }
}
