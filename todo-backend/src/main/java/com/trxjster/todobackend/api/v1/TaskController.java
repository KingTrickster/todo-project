package com.trxjster.todobackend.api.v1;

import com.trxjster.todobackend.model.Task;
import com.trxjster.todobackend.model.User;
import com.trxjster.todobackend.service.TaskService;
import com.trxjster.todobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable String userId){
    return taskService.getAllUserTasks(userService.getUserById(userId));
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable String taskId){
        return taskService.getTaskById(taskId);
    }

    //TODO: Remove code below when app is finished
    @Autowired
    private UserService userService;

    @GetMapping("populate")
    public Task populate(){
        Task t = new Task();
        t.setTitle("Mock Task");
        t.setFinishDate(LocalDateTime.of(2022, Month.DECEMBER, 12, 22, 30));
        t.setStartDate(LocalDateTime.now());
        t.setTaskIconType("Computer");
        User u = userService.getUserById("62e831f39193695190a7d9a5");
        t.setCreatedBy(u);
        return taskService.save(t);
    }

}
