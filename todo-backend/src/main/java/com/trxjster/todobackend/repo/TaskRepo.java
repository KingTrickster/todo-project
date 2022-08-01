package com.trxjster.todobackend.repo;

import com.trxjster.todobackend.model.Task;
import com.trxjster.todobackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends MongoRepository<Task, String> {
    List<Task> getTasksByCreatedBy(User user);
}
