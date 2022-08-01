package com.trxjster.todobackend.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document @Data
public class Task {

    @Id
    private String id;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private User createdBy;

    private List<User> users;

    private boolean finished = false;

    private Category category;

    private String taskIconType;

}
