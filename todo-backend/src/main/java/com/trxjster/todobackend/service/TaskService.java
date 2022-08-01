package com.trxjster.todobackend.service;

import com.trxjster.todobackend.model.Task;
import com.trxjster.todobackend.model.User;
import com.trxjster.todobackend.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public Task getTaskById(String id){
        return taskRepo.findById(id).orElseThrow(() -> new IllegalStateException("Task with id "+id + " not found"));
    }

    public List<Task> getAllUserTasks(User user){
        return taskRepo.getTasksByCreatedBy(user);
    }

    public Task save(Task t){
        return taskRepo.save(t);
    }
}
