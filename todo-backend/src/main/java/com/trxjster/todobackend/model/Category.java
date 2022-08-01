package com.trxjster.todobackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data
public class Category {
    @Id
    private String id;

    private String title;
    
}
